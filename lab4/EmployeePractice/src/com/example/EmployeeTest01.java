package com.example;

import com.example.domain.*;

public class EmployeeTest01 {
    public static void main(String[] args) {
        Engineer eng = new Engineer(101, "Jane Smith", "012-34-4567", 120_345.27, "Engineering");
        Manager mgr = new Manager(207, "Barbara Johnson", "054-12-2367", 109_501.36, "Marketing");
        Admin adm = new Admin(304, "Bill Monroe", "108-23-6509", 75_002.34);
        Director dir = new Director(12, "Susan Wheeler", "099-45-2340", 120_567.36, "Sales", 1_000_000.00);

        printEmployee(eng);
        printEmployee(mgr);
        printEmployee(adm);
        printEmployee(dir);

        // Повышаем зарплату
        mgr.raiseSalary(5000);
        System.out.println("\nПосле повышения зарплаты:");
        printEmployee(mgr);
    }

    public static void printEmployee(Employee emp) {
        System.out.println("\nEmployee ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());
        System.out.println("SSN: " + emp.getSSN());
        System.out.println("Salary: " + emp.getSalary());

        if (emp instanceof Manager) {
            System.out.println("Department Name: " + ((Manager) emp).getDeptName());
        }
        if (emp instanceof Director) {
            System.out.println("Budget: " + ((Director) emp).getBudget());
        }
    }
}
