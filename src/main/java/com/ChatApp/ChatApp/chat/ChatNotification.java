package com.ChatApp.ChatApp.chat;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatNotification {
    private String id;
    private String senderId;
    private String  recipientId;
    private String  content;
}
