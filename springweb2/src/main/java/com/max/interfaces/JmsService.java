package com.max.interfaces;

import com.max.entities.User;

public interface JmsService {
    void sendMessage(User user);
    User receiveMessage();
    void listen(User user);
}
