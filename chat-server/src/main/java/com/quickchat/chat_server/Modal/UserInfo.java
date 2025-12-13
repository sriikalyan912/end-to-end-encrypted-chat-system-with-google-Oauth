package com.quickchat.chat_server.Modal;

import java.util.List;

public class UserInfo {
    private String userId;
    private String email;
    private String name;
    private String username;
    private List<String> activeUserDevicesIds;
    
    public UserInfo(String userId, String email, String username, String name, List<String> activeUserDevicesIds) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.username = username;
        this.activeUserDevicesIds = activeUserDevicesIds;
    }
    
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getActiveUserDevicesIds() {
        return activeUserDevicesIds;
    }

    public void setActiveUserDevicesIds(List<String> activeUserDevicesIds) {
        this.activeUserDevicesIds = activeUserDevicesIds;
    }
}
