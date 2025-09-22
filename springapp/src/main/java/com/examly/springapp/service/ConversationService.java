package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.examly.springapp.model.Conversation;
import com.examly.springapp.repository.ConversationRepository;

@Service
@Transactional
public class ConversationService {
    private final ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public Conversation saveConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    @Transactional(readOnly = true)
    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Conversation> getConversationsByCategory(String category) {
        return conversationRepository.findByCategory(category);
    }

    @Transactional(readOnly = true)
    public List<Conversation> getConversationsSortedByTime() {
        return conversationRepository.findAllByOrderByTimestampDesc();
    }

    public void deleteConversation(Long id) {
        conversationRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Conversation> findById(Long id) {
        return conversationRepository.findById(id);
    }
}
