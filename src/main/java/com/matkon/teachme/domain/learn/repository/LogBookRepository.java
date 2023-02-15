package com.matkon.teachme.domain.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matkon.teachme.domain.learn.entity.LogBook;

public interface LogBookRepository extends JpaRepository<LogBook, Long> {

}
