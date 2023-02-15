package com.matkon.teachme.domain.learn.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogBookRequest {
    private Long deckId;
    private int totalScore;
}
