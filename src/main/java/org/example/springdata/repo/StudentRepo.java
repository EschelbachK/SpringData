package org.example.springdata.repo;

import org.example.springdata.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {

    Student getStudentsByName(String StudentName);
}
