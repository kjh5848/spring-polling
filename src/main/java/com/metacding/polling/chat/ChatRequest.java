package com.metacding.polling.chat;

// (4-0) POST /chats 요청 바디를 전달하는 DTO
public record ChatRequest(String message) {
}
