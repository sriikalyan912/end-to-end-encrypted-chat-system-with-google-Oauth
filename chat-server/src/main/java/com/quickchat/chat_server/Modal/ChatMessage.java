package com.quickchat.chat_server.Modal;

import java.time.LocalDateTime;

public class ChatMessage {
    private String id;
    private String content;
    private String senderId;
    private String senderName;
    private String recipientId;
    private String recipientName;
    private String chatRoomId;
    private MessageType type;
    private LocalDateTime timestamp;

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    public ChatMessage() {}

    public ChatMessage(String content, String senderId, String senderName, String chatRoomId, MessageType type) {
        this.content = content;
        this.senderId = senderId;
        this.senderName = senderName;
        this.chatRoomId = chatRoomId;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public ChatMessage(String content, String senderId, String senderName, String recipientId, String recipientName, MessageType type) {
        this.content = content;
        this.senderId = senderId;
        this.senderName = senderName;
        this.recipientId = recipientId;
        this.recipientName = recipientName;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }

    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }

    public String getChatRoomId() { return chatRoomId; }
    public void setChatRoomId(String chatRoomId) { this.chatRoomId = chatRoomId; }

    public MessageType getType() { return type; }
    public void setType(MessageType type) { this.type = type; }

    public String getRecipientId() { return recipientId; }
    public void setRecipientId(String recipientId) { this.recipientId = recipientId; }

    public String getRecipientName() { return recipientName; }
    public void setRecipientName(String recipientName) { this.recipientName = recipientName; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
