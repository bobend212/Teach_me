package com.matkon.teachme.domain.card.dto;

import com.matkon.teachme.domain.card.entity.CardStatus;
import com.matkon.teachme.domain.deck.dto.DeckDTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {
    private Long id;
    private String front;
    private String back;
    private CardStatus status;
    private DeckDTO deck;
}
