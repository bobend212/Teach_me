package com.matkon.teachme.domain.card.repository;

import com.matkon.teachme.domain.card.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
