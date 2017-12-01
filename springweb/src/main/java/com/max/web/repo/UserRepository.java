package com.max.web.repo;

import com.max.web.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

//@Repository
public class UserRepository implements MyRepo {
//    @Autowired
    SessionFactory sessionFactory;
//    @Transactional
    public void saveUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }
}
