package com.matkon.teachme.domain.card.controllers;

import com.matkon.teachme.domain.card.dto.CardRequest;
import com.matkon.teachme.domain.card.dto.CardResponse;
import com.matkon.teachme.domain.card.services.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseEntity<CardResponse> createCard(@RequestBody CardRequest request) {
        return new ResponseEntity<>(cardService.createCard(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long cardId) {
        cardService.deleteCard(cardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}