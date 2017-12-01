package com.max.mongo;

import com.max.mongo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository implements StudentRepo {
    @Autowired
    MongoOperations mongoOperations;
    @Override
    public void saveStudent() {
        mongoOperations.save(new Student("Mike"), "students");
    }
}
