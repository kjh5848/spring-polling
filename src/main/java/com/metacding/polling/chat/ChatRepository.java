package com.metacding.polling.chat;

import org.springframework.data.jpa.repository.JpaRepository;

// (3-2)/(4-2) 서비스에서 폴링 조회·저장 시 사용하는 JPA 리포지토리
public interface ChatRepository extends JpaRepository<Chat, Integer> {
}
