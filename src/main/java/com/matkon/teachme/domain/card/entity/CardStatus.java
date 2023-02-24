package com.matkon.teachme.domain.card.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardStatus {
    NEW("NEW"),
    POORLY("POORLY"),
    OK("OK"),
    GREAT("GREAT");

    private final String value;
}
