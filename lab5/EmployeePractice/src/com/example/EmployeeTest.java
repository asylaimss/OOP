package com.example;

import com.example.domain.*;
import com.example.business.*;

public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeStockPlan esp = new EmployeeStockPlan();

        Engineer eng = new Engineer(101, "Jane Smith", "012-34-4567", 120345.27);
        Manager mgr = new Manager(207, "Barbara Johnson", "054-12-2367", 109501.36, "US Marketing");
        Director dir = new Director(12, "Susan Wheeler", "099-45-2340", 120567.36, "Global Marketing", 1_000_000.00);

        printEmployee(eng, esp);
        printEmployee(mgr, esp);
        printEmployee(dir, esp);
    }

    public static void printEmployee(Employee emp, EmployeeStockPlan esp) {
        System.out.println("\nEmployee Type: " + emp.getClass().getSimpleName());
        System.out.println(emp);
        System.out.println("Stock Options: " + esp.grantStock(emp));
    }
}