package com.example.student.demo_1.repository;

import com.example.student.demo_1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
//@EnableJpaRepositories

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

   // boolean existById(int regNo);

}
