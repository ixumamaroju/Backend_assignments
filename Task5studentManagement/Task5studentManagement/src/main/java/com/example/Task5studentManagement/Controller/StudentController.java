package com.example.Task5studentManagement.Controller;

import com.example.Task5studentManagement.Entity.Student;
import com.example.Task5studentManagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Student addStudennt(@RequestBody Student student) {return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String name) {
        return studentRepository.findByName(name);
    }

    @GetMapping("/age")
    public List<Student> searchByAge(@RequestParam int age) {
        return  studentRepository.findByAgeGreaterThan(age);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "Deleted student with id: " + id;
    }
}
