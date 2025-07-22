package org.example.springdata.controller;


import org.example.springdata.model.Student;
import org.example.springdata.repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentRepo repo;

    public StudentController(StudentRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student) {
        Student oldData = repo.findById(id).orElse(null);
        if (oldData != null) {
            repo.save(oldData
                    .withAge(student.age())
                    .withName(student.name()));
        }
        return student;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
        repo.deleteById(id);
    }
}