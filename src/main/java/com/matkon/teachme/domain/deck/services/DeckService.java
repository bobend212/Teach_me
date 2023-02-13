package com.matkon.teachme.domain.deck.services;

import com.matkon.teachme.domain.deck.dto.DeckRequest;
import com.matkon.teachme.domain.deck.dto.DeckResponse;
import com.matkon.teachme.domain.deck.mapper.DeckMapper;
import com.matkon.teachme.domain.deck.repository.DeckRepository;
import com.matkon.teachme.exceptions.NotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {

    private final DeckRepository deckRepository;
    private final DeckMapper deckMapper;

    public DeckService(DeckRepository deckRepository, DeckMapper deckMapper) {
        this.deckRepository = deckRepository;
        this.deckMapper = deckMapper;
    }

    public List<DeckResponse> getAllDecks() {
        return deckRepository.findAll().stream().map(deckMapper::deckToDeckResponse).toList();
    }

    public DeckResponse getSingleDeck(Long deckId) {
        return deckRepository.findById(deckId).map(deckMapper::deckToDeckResponse)
                .orElseThrow(() -> new NotFoundException(String.format("Deck ID: %s, not found.", deckId)));
    }

    public DeckResponse createDeck(DeckRequest request) {
        return deckMapper.deckToDeckResponse(
                deckRepository.save(
                        deckMapper.deckRequestToDeck(
                                DeckRequest.builder().deckName(request.getDeckName()).build())));
    }
}
