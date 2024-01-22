package com.example.student.demo_1.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Student_Information")
public class Student {

    @Id
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
    int regNo;

    String name;
    int age;
    @Column(unique = true)
    String email;   //for unique email.

    String mobile;

    //Gender
    @Enumerated(EnumType.STRING)
    Gender gender;


}
