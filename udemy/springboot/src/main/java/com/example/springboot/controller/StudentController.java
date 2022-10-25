package com.example.springboot.controller;

import com.example.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent(){
        Student student =new Student(
                1,
                "Do",
                "Lee"
        );
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student>students = new ArrayList<>();
        students.add(new Student(1,"Wanne","Rooney"));
        students.add(new Student(2,"Steven","Gerard"));
        students.add(new Student(3,"Harry","Kane"));
        students.add(new Student(4,"Frank","Rampard"));
        return students;
    }



    @GetMapping("student/{id}/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable String firstName,
                                       @PathVariable String lastName){
        return new Student(studentId, firstName,lastName);
    }


}
