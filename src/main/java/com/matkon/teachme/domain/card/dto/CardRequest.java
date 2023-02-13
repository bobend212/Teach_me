package com.matkon.teachme.domain.card.dto;

import com.matkon.teachme.domain.card.entity.CardStatus;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {
    private String front;
    private String back;
    private CardStatus status;
    private Long deckId;
}
