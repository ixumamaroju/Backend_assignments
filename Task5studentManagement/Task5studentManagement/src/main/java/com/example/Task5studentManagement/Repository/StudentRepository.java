package com.example.Task5studentManagement.Repository;

import com.example.Task5studentManagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);

    @Query("SELECT s FROM Student s WHERE s.age> :age")
    List<Student> findByAgeGreaterThan(int age);
}
