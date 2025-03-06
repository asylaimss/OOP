package com.example.domain;

public class Director extends Manager {
    private double budget;

    public Director(int id, String name, String SSN, double salary, String deptName, double budget) {
        super(id, name, SSN, salary, deptName);
        this.budget = budget;
    }

    public double getBudget() { return budget; }

    @Override
    public String toString() {
        return super.toString() + "\nBudget: " + budget;
    }
}