package com.max.test.interfaces;

import com.max.test.entities.User;

public interface TestRepo {
    void saveUser(User student);
    User findUser();
}
