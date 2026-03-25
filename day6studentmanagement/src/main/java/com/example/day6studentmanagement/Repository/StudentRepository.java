package com.example.day6studentmanagement.Repository;

import com.example.day6studentmanagement.Entity.Student1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student1,Long> {
    List<Student1> findByName(String name);

    @Query("SELECT s FROM Student1 s WHERE s.age> :age")
    List<Student1> findByAgeGreaterThan(@Param("age") int age);

}
