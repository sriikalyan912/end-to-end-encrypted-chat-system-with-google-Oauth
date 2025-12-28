package com.quickchat.chat_server.Controllers.Messaging;

import com.quickchat.chat_server.Modal.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class MessageController {

    public final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public MessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/deliver/message")
    public void sendMessageToUser(ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());
        this.messagingTemplate.convertAndSendToUser(message.getRecipientId(), "/queue/message", message);
    }
}
