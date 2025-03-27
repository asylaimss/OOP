package com.example.dao;

import com.example.model.Employee;
import java.util.List;

public interface EmployeeDAO {
    void add(Employee employee);
    void update(Employee employee);
    void delete(int id);
    Employee findById(int id);
    List<Employee> getAllEmployees();
}