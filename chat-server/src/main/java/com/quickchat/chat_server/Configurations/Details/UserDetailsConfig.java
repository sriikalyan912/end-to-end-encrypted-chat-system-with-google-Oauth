package com.quickchat.chat_server.Configurations.Details;

import com.quickchat.chat_server.Services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserDetailsConfig {

    /*
     * Exposing AuthenticationManager as a Bean.
     * Required for injecting in AuthController
     * */
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserService();
    }
}
