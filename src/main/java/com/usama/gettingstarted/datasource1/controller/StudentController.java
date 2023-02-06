package com.usama.gettingstarted.datasource1.controller;

import com.usama.gettingstarted.datasource1.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @RequestMapping("/")
    public ResponseEntity<?> findAllStudents(){
        return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);
    }
}
