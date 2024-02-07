package com.mohammedaltwaity.springrest.rest;

import com.mohammedaltwaity.springrest.dao.EmployeeDao;
import com.mohammedaltwaity.springrest.entity.Employee;
import com.mohammedaltwaity.springrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public  EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")

    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")

    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
//        if(employee == null){
//            throw    new RuntimeException("Employee with id = " + employee +" not found.");
//        }
        return  employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
          Employee dbEmployee = employeeService.save(employee);
          return  dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee dbEmployee = employeeService.findById(employeeId);
                if(dbEmployee == null){
                     throw    new RuntimeException("Employee with id = " + employeeId +" not found.");
       }

        employeeService.deleteEmployee(employeeId);
        return "Employee with id = " + employeeId + " deleted";
    }

}
