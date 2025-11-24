package com.metacding.polling.chat;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatRepository chatRepository;

    @Transactional
    public Chat save(String sender, String message) {
        Chat chat = Chat.builder()
                .sender(sender)
                .message(message)
                .createdAt(LocalDateTime.now())
                .build();

        return chatRepository.save(chat);
    }

    public List<Chat> findAll() {
        return chatRepository.findAllByOrderByIdAsc();
    }

    public List<Chat> findAfter(Integer lastId) {
        if (lastId == null) {
            return findAll();
        }
        return chatRepository.findByIdGreaterThanOrderByIdAsc(lastId);
    }
}