package com.matkon.teachme.domain.card.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardStatus {
    NEW("NEW"),
    AGAIN("AGAIN"),
    GOOD("GOOD"),
    EASY("EASY");

    private final String value;
}
