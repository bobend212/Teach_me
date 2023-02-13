package com.matkon.teachme.domain.deck.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeckDTO {
    private Long id;
    private String deckName;
}
