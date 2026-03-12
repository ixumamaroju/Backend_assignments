package com.example.task4.Controllers;

import com.example.task4.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1,"uma",21));
        students.add(new Student(2,"sri",24));
        students.add(new Student(3,"sai",25));
    }
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        for(Student student : students){
            if(student.getStudentID() == id){
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudentByName(@RequestParam String name){
        List<Student> searchedStudents = new ArrayList<>();
        for(Student student : students){
            if(student.getStudentName().toLowerCase().contains(name.toLowerCase())){
                searchedStudents.add(student);
            }
        }
        return ResponseEntity.ok(searchedStudents);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        students.add(student);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student UpdateStudent){
        for(Student student : students){
            if(student.getStudentID() == id){
                student.setStudentName(UpdateStudent.getStudentName());
                student.setStudentName(UpdateStudent.getStudentName());

                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        for(Student student : students){
            if(student.getStudentID() == id){
                students.remove(student);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }



}
