package com.matkon.teachme.domain.learn.services;

import org.springframework.stereotype.Service;

import com.matkon.teachme.domain.deck.repository.DeckRepository;
import com.matkon.teachme.domain.learn.dto.LogBookRequest;
import com.matkon.teachme.domain.learn.dto.LogBookResponse;
import com.matkon.teachme.domain.learn.entity.LogBook;
import com.matkon.teachme.domain.learn.mapper.LogBookMapper;
import com.matkon.teachme.domain.learn.repository.LogBookRepository;
import com.matkon.teachme.exceptions.NotFoundException;

import jakarta.transaction.Transactional;

@Service
public class LogBookService {

    private final LogBookRepository logBookRepository;
    private final DeckRepository deckRepository;
    private final LogBookMapper logBookMapper;

    public LogBookService(LogBookRepository logBookRepository, DeckRepository deckRepository,
            LogBookMapper logBookMapper) {
        this.logBookRepository = logBookRepository;
        this.deckRepository = deckRepository;
        this.logBookMapper = logBookMapper;
    }

    @Transactional
    public LogBookResponse createLogBook(LogBookRequest request) {

        LogBook logBook = logBookRepository.save(
                logBookMapper.logBookRequestToLogBook(
                        LogBookRequest.builder()
                                .deckId(request.getDeckId())
                                .totalScore(request.getTotalScore())
                                .build()));

        assignLogBookToDeck(request, logBook);
        return logBookMapper.logBookToLogBookResponse(logBook);
    }

    private void assignLogBookToDeck(LogBookRequest request, LogBook logBook) {
        deckRepository.findById(request.getDeckId()).map(deck -> {
            logBook.setDeck(deck);
            return deckRepository.save(deck);
        }).orElseThrow(() -> new NotFoundException(String.format("Deck ID: %s, not found.", request.getDeckId())));
    }

}
