package com.example.dao;

public class EmployeeDAOFactory {

    public EmployeeDAO createEmployeeDAO() {
        return new EmployeeDAOJDBCImpl(); // swapped to JDBC implementation
    }
}
