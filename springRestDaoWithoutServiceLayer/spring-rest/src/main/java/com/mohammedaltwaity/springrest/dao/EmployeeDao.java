package com.mohammedaltwaity.springrest.dao;

import com.mohammedaltwaity.springrest.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
}
