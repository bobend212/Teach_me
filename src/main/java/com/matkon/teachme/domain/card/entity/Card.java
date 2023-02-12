package com.matkon.teachme.domain.card.entity;

import com.matkon.teachme.domain.deck.entity.Deck;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cards")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String front;

    private String back;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;
}
