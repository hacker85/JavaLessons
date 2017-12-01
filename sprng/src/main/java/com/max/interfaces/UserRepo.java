package com.max.interfaces;

import com.max.entities.User;

public interface UserRepo {
    User getById(int id);
}