package com.max.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.max.web.entities.User;

public interface UserAutoRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
