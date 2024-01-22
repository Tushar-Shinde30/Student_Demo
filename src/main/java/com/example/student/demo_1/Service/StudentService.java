package com.example.student.demo_1.Service;

import com.example.student.demo_1.entity.Student;
import com.example.student.demo_1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return "Student saved succesfully";

    }

    public Student getStudent(int regNo) {
        Optional<Student> studentOptional = studentRepository.findById(regNo);
        if (studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
        //return studentRepository.getStudent(regNo);
    }

    public Student updateStudentAge(int regNo, int newAge) {
        Optional<Student> optionalStudent = studentRepository.findById(regNo);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setAge(newAge);
            return studentRepository.save(existingStudent);
        } else {
            return null;
        }
    }

    public Student deleteStudent(int regNo) {
        studentRepository.deleteById(regNo);
        return null;
    }


//    public boolean removeStudentByRegNo(int regNo) {
//        if (studentRepository.existById(regNo)) {
//            studentRepository.deleteById(regNo);
//            return true;
//        } else {
//            return false;
//        }
//    }

}
