package com.matkon.teachme.domain.deck.dto;

import com.matkon.teachme.domain.card.dto.CardDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeckResponse {

    private Long id;
    private String deckName;
    private List<CardDTO> cards;
}
