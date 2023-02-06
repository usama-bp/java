package com.usama.gettingstarted.datasource2.controller;

import com.usama.gettingstarted.datasource2.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    DepartmentRepo departmentRepo;

    @RequestMapping("/")
    public ResponseEntity<?> findAllDepartments(){
        return new ResponseEntity<>(departmentRepo.findAll(), HttpStatus.OK);
    }
}
