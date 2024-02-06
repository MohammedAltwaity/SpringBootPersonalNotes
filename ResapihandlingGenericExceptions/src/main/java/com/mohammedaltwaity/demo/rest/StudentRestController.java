package com.mohammedaltwaity.demo.rest;

import com.mohammedaltwaity.demo.entity.Student;
import com.mohammedaltwaity.demo.exception.StudentErrorResponse;
import com.mohammedaltwaity.demo.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> students;
    @PostConstruct
    public void loadData(){

              students = new ArrayList<>(List.of(new Student("Mohammed", "Ali"),
                new Student("Ahmed", "Saleh"), new Student("yahaya", "Hussein")));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //check if the studentId is within the list range
        if(studentId >= students.size() || studentId < 0){
            throw new StudentNotFoundException("Student with id = " + studentId + " not found");
        }

        return students.get(studentId);
    }


}
