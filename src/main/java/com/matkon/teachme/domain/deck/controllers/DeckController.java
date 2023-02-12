package com.matkon.teachme.domain.deck.controllers;

import com.matkon.teachme.domain.deck.dto.DeckRequest;
import com.matkon.teachme.domain.deck.dto.DeckResponse;
import com.matkon.teachme.domain.deck.entity.Deck;
import com.matkon.teachme.domain.deck.services.DeckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/decks")
public class DeckController {

    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping
    public ResponseEntity<List<DeckResponse>> getAllDecks() {
        return new ResponseEntity<>(deckService.getAllDecks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeckResponse> createDeck(@RequestBody DeckRequest request) {
        return new ResponseEntity<>(deckService.createDeck(request), HttpStatus.CREATED);
    }
}
