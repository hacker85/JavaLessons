package com.max.impl;

import com.max.entities.User;
import com.max.interfaces.UserRepo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


//@Repository
public class UserRepository implements UserRepo {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getById(int id) {
        return null;
    }
}
