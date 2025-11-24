package com.metacding.polling.chat;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final ChatService chatService;

    // UI 제공
    @GetMapping("/")
    public String index() {
        return "chat"; // chat.mustache
    }

    // 메시지 저장 (JS fetch)
    @PostMapping("/api/chat")
    @ResponseBody
    public ResponseEntity<Chat> save(@RequestBody ChatRequest req) {
        Chat saved = chatService.save(req.getSender(), req.getMessage());
        return ResponseEntity.ok(saved);
    }

    // Polling 메시지 GET
    @GetMapping("/api/chat")
    @ResponseBody
    public ResponseEntity<List<Chat>> list() {
        List<Chat> chats = chatService.findAll();
        return ResponseEntity.ok(chats);
    }
}
