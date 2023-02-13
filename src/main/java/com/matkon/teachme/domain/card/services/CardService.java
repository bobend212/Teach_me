package com.matkon.teachme.domain.card.services;

import com.matkon.teachme.domain.card.dto.CardRequest;
import com.matkon.teachme.domain.card.dto.CardResponse;
import com.matkon.teachme.domain.card.entity.Card;
import com.matkon.teachme.domain.card.mapper.CardMapper;
import com.matkon.teachme.domain.card.repository.CardRepository;
import com.matkon.teachme.domain.deck.repository.DeckRepository;
import com.matkon.teachme.exceptions.NotFoundException;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final DeckRepository deckRepository;
    private final CardMapper cardMapper;

    public CardService(CardRepository cardRepository, DeckRepository deckRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.deckRepository = deckRepository;
        this.cardMapper = cardMapper;
    }

    public List<CardResponse> getAllCards() {
        return cardRepository.findAll().stream().map(cardMapper::cardToCardResponse).toList();
    }

    public CardResponse getSingleCard(Long cardId) {
        return cardRepository.findById(cardId).map(cardMapper::cardToCardResponse)
                .orElseThrow(() -> new NotFoundException(String.format("Card ID: %s, not found.", cardId)));
    }

    @Transactional
    public CardResponse createCard(CardRequest request) {

        Card card = cardRepository.save(
                cardMapper.cardRequestToCard(
                        CardRequest.builder()
                                .front(request.getFront())
                                .back(request.getBack())
                                .deckId(request.getDeckId())
                                .build()));

        assignCardToDeck(request, card);

        return cardMapper.cardToCardResponse(card);
    }

    private void assignCardToDeck(CardRequest request, Card card) {
        deckRepository.findById(request.getDeckId()).map(deck -> {
            card.setDeck(deck);
            return deckRepository.save(deck);
        }).orElseThrow(() -> new NotFoundException(String.format("Card ID: %s, not found.", card.getId())));
    }

    public void deleteCard(Long cardId) {
        getSingleCard(cardId);
        cardRepository.deleteById(cardId);
    }

    @Transactional
    public CardResponse partialUpdate(Long cardId, CardRequest request) {
        var findCard = cardRepository.findById(cardId)
                .orElseThrow(() -> new NotFoundException(String.format("Card ID: %s, not found.", cardId)));

        Optional.ofNullable(request.getFront()).ifPresent(findCard::setFront);
        Optional.ofNullable(request.getBack()).ifPresent(findCard::setBack);
        Optional.ofNullable(request.getDeckId()).ifPresent(deckId -> {
            deckRepository.findById(deckId).map(deck -> {
                findCard.setDeck(deck);
                return deckRepository.save(deck);
            }).orElseThrow(() -> new NotFoundException(String.format("Deck ID: %s, not found.", deckId)));
        });

        return cardMapper.cardToCardResponse(cardRepository.save(findCard));
    }

    public CardResponse shuffleCardByDeck(Long deckId) {
        // to improve
        var findCards = getAllCards().stream().filter(xxx -> xxx.getDeck().getId() == deckId)
                .mapToLong(qqq -> qqq.getId()).toArray();

        int rnd = new Random().nextInt(findCards.length);

        return getSingleCard(Long.valueOf(rnd + 1));
    }
}
