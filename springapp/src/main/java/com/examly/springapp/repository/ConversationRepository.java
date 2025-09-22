package com.examly.springapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Conversation;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByCategory(String category);

    List<Conversation> findAllByOrderByTimestampDesc();
}
