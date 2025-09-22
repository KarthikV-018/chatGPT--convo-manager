package com.examly.springapp.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.Conversation;
import com.examly.springapp.service.ConversationService;

@RestController
@RequestMapping("/api/chats")
public class ConversationController {
    private final ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("/addConversation")
    public ResponseEntity<Conversation> addConversation(@RequestBody Conversation conversation) {
        Conversation saved = conversationService.saveConversation(conversation);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/allConversations")
    public ResponseEntity<List<Conversation>> getAllConversations() {
        return ResponseEntity.ok(conversationService.getAllConversations());
    }

    @GetMapping("/byCategory")
    public ResponseEntity<List<Conversation>> getByCategory(@RequestParam String category) {
        return ResponseEntity.ok(conversationService.getConversationsByCategory(category));
    }

    @GetMapping("/sortedByTime")
    public ResponseEntity<List<Conversation>> getSortedByTime() {
        return ResponseEntity.ok(conversationService.getConversationsSortedByTime());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConversation(@PathVariable Long id) {
        conversationService.deleteConversation(id);
        return ResponseEntity.ok().build();
    }
}
