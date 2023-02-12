package com.matkon.teachme.domain.card.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {
    private String front;
    private String back;
    private Long deckId;
}
