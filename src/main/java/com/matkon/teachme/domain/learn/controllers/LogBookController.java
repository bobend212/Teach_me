package com.matkon.teachme.domain.learn.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matkon.teachme.domain.learn.dto.LogBookRequest;
import com.matkon.teachme.domain.learn.dto.LogBookResponse;
import com.matkon.teachme.domain.learn.services.LogBookService;

@RestController
@RequestMapping("/api/v1/log-book")
public class LogBookController {

    private final LogBookService logBookService;

    public LogBookController(LogBookService logBookService) {
        this.logBookService = logBookService;
    }

    @PostMapping
    public ResponseEntity<LogBookResponse> createLogBook(@RequestBody LogBookRequest request) {
        return new ResponseEntity<>(logBookService.createLogBook(request), HttpStatus.CREATED);
    }

}
