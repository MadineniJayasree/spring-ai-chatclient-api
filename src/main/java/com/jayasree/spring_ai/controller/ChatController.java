package com.jayasree.spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/jokes")
    public String generate(
            @RequestParam(
                    value = "message",
                    defaultValue = "Tell me a joke"
            ) String message) {

        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}