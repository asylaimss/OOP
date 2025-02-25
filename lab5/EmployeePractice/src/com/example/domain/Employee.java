package com.example.domain;

import java.text.NumberFormat;

public class Employee {
    private int id;
    private String name;
    private String SSN;
    private double salary;

    public Employee(int id, String name, String SSN, double salary) {
        this.id = id;
        this.name = name;
        this.SSN = SSN;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSSN() { return SSN; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee ID:   " + id + "\n" +
                "Employee Name: " + name + "\n" +
                "Employee SSN:  " + SSN + "\n" +
                "Salary:        " + NumberFormat.getCurrencyInstance().format(salary);
    }
}