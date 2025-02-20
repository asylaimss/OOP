package com.example.domain;

public class Employee {
    private int id;
    private String name;
    private String SSN;
    private double salary;
    private String department;
    private String email;

    public Employee() {} // Конструктор по умолчанию

    public Employee(int id, String name,String SSN) {

        this.id=id;
        this.name=name;
        this.SSN=SSN;

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSSN() {
        return SSN;
    }
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}