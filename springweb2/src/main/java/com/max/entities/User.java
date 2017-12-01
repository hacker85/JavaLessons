package com.max.entities;

import java.io.Serializable;

public class User implements Serializable {
    String name;

    public User() {}
    public User(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
