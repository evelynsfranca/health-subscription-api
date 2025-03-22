package com.healthsubscriptionapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {
    
    @GetMapping
    private ResponseEntity<String> getTest() {
        return new ResponseEntity<String>("Hello world!", HttpStatus.OK);
    } 
}
