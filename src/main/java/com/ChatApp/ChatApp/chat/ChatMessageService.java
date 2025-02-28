package com.ChatApp.ChatApp.chat;

import com.ChatApp.ChatApp.chatroom.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage){
        var chatId=chatRoomService.getChatRoomId(
                chatMessage.getSenderId(),
                chatMessage.getRecipientId(),
                true
        ).orElseThrow();//set custom exception
        chatMessage.setChatId(chatId);
        return repository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessages(
            String senderId,
            String recipientId
    ){
        var chatId=chatRoomService.getChatRoomId(senderId,recipientId,false);
        return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
    }
}
