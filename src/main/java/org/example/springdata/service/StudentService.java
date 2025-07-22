package org.example.springdata.service;

import org.example.springdata.model.Student;
import org.example.springdata.repo.StudentRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class StudentService {

   private final StudentRepo repo;

    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }
    public Student getStudentById(String id) {
        return repo.findById(id).orElse(null);
    }
    public Student addStudent(Student student) {
        return repo.save(student);
    }
    public Student updateStudent(String id, Student student) {
        Student oldData = repo.findById(id).orElse(null);
        if (oldData != null) {
            repo.save(oldData
                    .withAge(student.age())
                    .withName(student.name()));
        }
        return student;
    }
    public void deleteStudent(String id) {
        repo.deleteById(id);
    }
}
