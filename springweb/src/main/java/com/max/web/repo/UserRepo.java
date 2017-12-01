package com.max.web.repo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserRepo implements Repo, Serializable {
    public User getUser() {
        return new User("Max", 22);
    }
}
