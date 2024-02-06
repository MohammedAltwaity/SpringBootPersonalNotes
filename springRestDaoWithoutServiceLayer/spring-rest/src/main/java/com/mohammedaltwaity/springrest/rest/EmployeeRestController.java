package com.mohammedaltwaity.springrest.rest;

import com.mohammedaltwaity.springrest.dao.EmployeeDao;
import com.mohammedaltwaity.springrest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDao employeeDao;

    @Autowired
    public  EmployeeRestController(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employees")

    public List<Employee> findAll(){
        return employeeDao.findAll();
    }
}
