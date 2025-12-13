package com.quickchat.chat_server.Services;

import com.quickchat.chat_server.Modal.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("SriiKalyan")) {
            return new User("SriiKalyan", "{noop}password", "USER");
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
