package com.example.dao;

import com.example.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOMemoryImpl implements EmployeeDAO {
    private Employee[] employeeArray = new Employee[10];

    @Override
    public void add(Employee employee) {
        if (employee.getId() >= 0 && employee.getId() < employeeArray.length) {
            employeeArray[employee.getId()] = employee;
        }
    }

    @Override
    public void update(Employee employee) {
        if (employee.getId() >= 0 && employee.getId() < employeeArray.length) {
            employeeArray[employee.getId()] = employee;
        }
    }

    @Override
    public void delete(int id) {
        if (id >= 0 && id < employeeArray.length) {
            employeeArray[id] = null;
        }
    }

    @Override
    public Employee findById(int id) {
        if (id >= 0 && id < employeeArray.length) {
            return employeeArray[id];
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeArray) {
            if (employee != null) {
                employees.add(employee);
            }
        }
        return employees;
    }
}