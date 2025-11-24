package com.metacding.polling.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

    List<Chat> findAllByOrderByIdAsc();
}
