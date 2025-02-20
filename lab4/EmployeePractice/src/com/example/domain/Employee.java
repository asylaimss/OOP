package com.example.domain;

public class Employee {
    private int id;
    private String name;
    private String SSN;
    private double salary;

    public Employee() {} // Конструктор по умолчанию

    public Employee(int id, String name,String SSN, double salary) {
        this.id=id;
        this.name=name;
        this.SSN=SSN;
        this.salary=salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSSN() {
        return SSN;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String Name){
        this.name = name;
    }

    public void raiseSalary(double increase){
        if(increase > 0){
            this.salary += increase;
        } else{
            System.out.println("Mistake: the pay increase must be positive.");
        }
    }

}