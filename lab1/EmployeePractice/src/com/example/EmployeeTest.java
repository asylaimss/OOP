package com.example;

import com.example.domain.Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp = new Employee(101, "Jane Smith", "012-34-4567");
        emp.setId(101);
        emp.setName("Jane Smith");
        emp.setSSN("012-34-4567");
        emp.setSalary(120_345.27);
        emp.setDepartment("Marketing");
        emp.setEmail("jane.smith@example.com");

        System.out.println("Employee id = " + emp.getId());
        System.out.println("Employee name = " + emp.getName());
        System.out.println("Employee Social Security Number = " + emp.getSSN());
        System.out.println("Employee salary = " + emp.getSalary());
        System.out.println("Employee department = " + emp.getDepartment());
        System.out.println("Employee email = " + emp.getEmail());
    }
}