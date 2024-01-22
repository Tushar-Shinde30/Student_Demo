package com.example.student.demo_1.controller;


import com.example.student.demo_1.Service.StudentService;
import com.example.student.demo_1.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){

        String response = studentService.addStudent(student);
        return new ResponseEntity(response, HttpStatus.CREATED);

    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo){
        Student student = studentService.getStudent(regNo);
        if (student!=null){
            return new ResponseEntity(student,HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid id...!",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update-age/{regNo}")
    public ResponseEntity updateStudentAge(@PathVariable int regNo, @RequestParam int newAge) {
        Student updatedStudent = studentService.updateStudentAge(regNo, newAge);
        if (updatedStudent != null) {
            return new ResponseEntity(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity("Student not found with registration number: " + regNo, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{regNo}")
    public String deleteStudent(@PathVariable int regNo){
        studentService.deleteStudent(regNo);
        return "Student Record Deleted...!";
    }






//    @DeleteMapping("/remove/{regNo}")
//    public ResponseEntity removeStudent(@PathVariable int regNo) {
//        boolean isRemoved = studentService.removeStudentByRegNo(regNo);
//
//        if (isRemoved) {
//            return new ResponseEntity("Student removed successfully", HttpStatus.OK);
//        } else {
//            return new ResponseEntity("Student not found", HttpStatus.NOT_FOUND);
//        }
//    }




}
