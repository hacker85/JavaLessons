package com.max.test.impl;

import com.max.test.entities.User;
import com.max.test.interfaces.TestRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TestRepoImpl implements TestRepo {
//    @Autowired
//    SessionFactory sessionFactory;
    @Override
    @Transactional
    public void saveUser(User user) {
//        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User findUser() {
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
//        return query.getSingleResult();
        return new User();
    }
}
