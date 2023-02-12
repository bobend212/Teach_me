package com.matkon.teachme.domain.deck.mapper;

import com.matkon.teachme.domain.deck.dto.DeckRequest;
import com.matkon.teachme.domain.deck.dto.DeckResponse;
import com.matkon.teachme.domain.deck.entity.Deck;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeckMapper {

    Deck deckRequestToDeck(DeckRequest request);

    DeckResponse deckRequestToDeckResponse(DeckRequest deckRequest);

    DeckResponse deckToDeckResponse(Deck deck);

}
