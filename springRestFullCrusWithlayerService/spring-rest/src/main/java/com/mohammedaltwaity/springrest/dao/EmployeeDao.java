package com.mohammedaltwaity.springrest.dao;

import com.mohammedaltwaity.springrest.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteEmployee(int id);
}
