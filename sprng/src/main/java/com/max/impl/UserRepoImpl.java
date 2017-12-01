package com.max.impl;

import com.max.entities.User;
import com.max.interfaces.UserRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class UserRepoImpl implements UserRepo {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public User getById(int id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = " + id, User.class);
        return query.getSingleResult();
    }
}
