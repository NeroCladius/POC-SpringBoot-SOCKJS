package com.budka.src.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    private final SimpMessagingTemplate simpMessagingTemplate;

    public HomeController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostMapping("/topic/{text}")
    public ResponseEntity<?> test(@PathVariable("text") String asdf) {
        simpMessagingTemplate.convertAndSend("/topic/messages", asdf);
        return ResponseEntity.ok().build();
    }

}
