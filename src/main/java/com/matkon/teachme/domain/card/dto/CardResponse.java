package com.matkon.teachme.domain.card.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {
    private Long id;
    private String front;
    private String back;
}
