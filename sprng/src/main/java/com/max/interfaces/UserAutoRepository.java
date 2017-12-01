package com.max.interfaces;

import com.max.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserAutoRepository extends JpaRepository<User,Long>, UserRepo {
    @Query("select u from User u where u.name = :name")
    User getByName(@Param("name") String name);
//    User findByName(String name);
//    User readByName(String name);
//    User getUserByName(String name);
//    int countByName(String name);
}
