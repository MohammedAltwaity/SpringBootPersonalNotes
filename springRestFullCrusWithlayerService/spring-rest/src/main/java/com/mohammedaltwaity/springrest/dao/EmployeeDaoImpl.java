package com.mohammedaltwaity.springrest.dao;

import com.mohammedaltwaity.springrest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.QTypeContributor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
//        String sqlQuery = "select * from employee";
//
//        // Create a native SQL query
//        Query query = entityManager.createNativeQuery(sqlQuery, Employee.class);
//
//       // Cast the query to TypedQuery<Employee>
//        TypedQuery<Employee> typedQuery = (TypedQuery<Employee>) query;
//
//      // Execute the query and get the result list
//        List<Employee> resultList = typedQuery.getResultList();

            //or  "JPQL" (Java Persistence Query Language), then it depends on your specific use case and requirements. Here are some considerations:




        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> resulList = theQuery.getResultList();

        return resulList ;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;

    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);

        return  dbEmployee;
    }

    @Override
    public void deleteEmployee(int id) {

        Employee employee = entityManager.find(Employee.class, id);

        entityManager.remove(employee);

    }
}
