package com.quickchat.chat_server.Configurations.WebSocket;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket configuration for real-time chat messaging
 * Enables STOMP protocol over WebSocket with SockJS fallback
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Registers WebSocket endpoints for client connections
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Main WebSocket endpoint with CORS support and SockJS fallback
        registry.addEndpoint("/ws-chat")
                .setAllowedOriginPatterns("http://localhost:5173", "*")
                .setHandshakeHandler(new UserHandshakeHandler())
                .withSockJS();
    }

    /**
     * Configures message broker for routing messages
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Enable simple broker for broadcasting messages
        registry.enableSimpleBroker("/topic", "/queue");
        // Set prefix for client-to-server messages
        registry.setApplicationDestinationPrefixes("/app");
        // Set prefix for private messages
        registry.setUserDestinationPrefix("/user");
    }
}
