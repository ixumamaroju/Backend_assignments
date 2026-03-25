package com.example.day6studentmanagement.Controller;

import com.example.day6studentmanagement.DTO.StudentRequestDTO;
import com.example.day6studentmanagement.DTO.StudentResponseDTO;
import com.example.day6studentmanagement.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentss")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentResponseDTO addstudent(@RequestBody StudentRequestDTO dto){
        return studentService.addstudent(dto);
    }

    @GetMapping
    public List<StudentResponseDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable Long id,@RequestBody StudentRequestDTO dto){
        return studentService.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/search")
    public List<StudentResponseDTO> searchByName(@RequestParam String name){
        return studentService.searchByName(name);
    }

    @GetMapping("/age")
    public List<StudentResponseDTO> searchByAge(@RequestParam int age){
        return studentService.getStudentsOlderThan(age);
    }


}
