package com.matkon.teachme.domain.card.dto;

import com.matkon.teachme.domain.card.entity.CardStatus;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {
    private Long id;
    private String front;
    private String back;
    private CardStatus status;
}
