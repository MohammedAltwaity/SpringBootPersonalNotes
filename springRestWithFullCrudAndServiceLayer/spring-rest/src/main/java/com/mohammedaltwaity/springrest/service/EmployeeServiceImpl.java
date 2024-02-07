package com.mohammedaltwaity.springrest.service;

import com.mohammedaltwaity.springrest.dao.EmployeeDao;
import com.mohammedaltwaity.springrest.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

//in the service we are just delegating the calls from dao to service
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Transactional
    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }
}
