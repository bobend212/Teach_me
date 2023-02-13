package com.matkon.teachme.domain.learn.entity;

import java.time.LocalDateTime;

import com.matkon.teachme.domain.deck.entity.Deck;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "log_books")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;

    private LocalDateTime approachDate;

    private int totalScore;
}
