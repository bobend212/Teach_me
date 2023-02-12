package com.matkon.teachme.domain.deck.repository;

import com.matkon.teachme.domain.deck.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Long> {

}
