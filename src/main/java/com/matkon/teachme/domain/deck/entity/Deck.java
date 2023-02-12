package com.matkon.teachme.domain.deck.entity;

import com.matkon.teachme.domain.card.entity.Card;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "decks")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deckName;

    @OneToMany(mappedBy = "deck")
    private List<Card> cards;
}
