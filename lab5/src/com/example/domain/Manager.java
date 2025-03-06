package com.example.domain;

public class Manager extends Employee {
    private String deptName;

    public Manager(int id, String name, String SSN, double salary, String deptName) {
        super(id, name, SSN, salary);
        this.deptName = deptName;
    }

    public String getDeptName() { return deptName; }

    @Override
    public String toString() {
        return super.toString() + "\nDepartment: " + deptName;
    }
}