package com.matkon.teachme.domain.card.mapper;

import com.matkon.teachme.domain.card.dto.CardRequest;
import com.matkon.teachme.domain.card.dto.CardResponse;
import com.matkon.teachme.domain.card.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {

    Card cardRequestToCard(CardRequest request);

    CardResponse cardToCardResponse(Card card);

}
