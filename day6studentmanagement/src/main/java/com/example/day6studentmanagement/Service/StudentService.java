package com.example.day6studentmanagement.Service;

import com.example.day6studentmanagement.DTO.StudentRequestDTO;
import com.example.day6studentmanagement.DTO.StudentResponseDTO;
import com.example.day6studentmanagement.Entity.Student1;
import com.example.day6studentmanagement.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private StudentRepository studentRepository;
//constructor injection(task2)//

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //task 4 mapping method
    //this convert between requested to entity

    private Student1 toEntity(StudentRequestDTO dto) {
        Student1 s = new Student1();
        s.setName(dto.getName());
        s.setAge(dto.getAge());
        s.setEmail(dto.getEmail());
        return s;
    }

    //entity to responseDTO

    private StudentResponseDTO toResponseDTO(Student1 s) {
        return new StudentResponseDTO(
                s.getId(),
                s.getName(),
                s.getAge(),
                s.getEmail());
    }

    //task 1 and task 6
    @Transactional
    public StudentResponseDTO addstudent(StudentRequestDTO dto) {
        Student1 entity = toEntity(dto); //dto to entity
        Student1 saved = studentRepository.save(entity); //insert into DB
//        if(saved.getName().equals("TestRollback")){
//            throw new RuntimeException("stimulated crash after save!");
//        }
        return toResponseDTO(saved); //entity->responseDTO
    }

    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public StudentResponseDTO getStudentById(Long id) {
        return studentRepository.findById(id).map(this::toResponseDTO).orElse(null);
    }

    @Transactional
    public StudentResponseDTO updateStudent(Long id,StudentRequestDTO dto) {
        Student1 existing = studentRepository.findById(id).orElse(null);
        if(existing == null) {
            return null;
        }
        existing.setName(dto.getName());
        existing.setAge(dto.getAge());
        existing.setEmail(dto.getEmail());
        return toResponseDTO(studentRepository.save(existing));
    }

    @Transactional
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Deleted student with id: " + id;
    }

    public List<StudentResponseDTO> searchByName(String name){
        return studentRepository.findByName(name).stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public List<StudentResponseDTO> getStudentsOlderThan(int age){
        return studentRepository.findByAgeGreaterThan(age).stream().map(this::toResponseDTO).collect(Collectors.toList());
    }
}
