package com.matkon.teachme.domain.learn.dto;

import java.time.LocalDateTime;

import com.matkon.teachme.domain.deck.dto.DeckDTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogBookResponse {
    private Long id;
    private DeckDTO deck;
    private LocalDateTime approachDate;
    private int totalScore;
}
