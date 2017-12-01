package com.max.mongo;

import com.max.mongo.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StudentAutoRepository extends MongoRepository<Student, String> {
    @Query("{'name': ?0}")
    Student getStudentByName(String name);
}
