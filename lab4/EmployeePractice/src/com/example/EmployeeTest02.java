package com.example;

import com.example.domain.*;

public class EmployeeTest02 {
    public static void main(String[] args) {
        // Создаем сотрудников
        Engineer eng = new Engineer(101, "Jane Smith", "012-34-5678", 120_345.27, "Engineering");
        Admin adm = new Admin(304, "Bill Monroe", "108-23-6509", 75_002.34);

        // Создаем менеджера
        Manager mgr = new Manager(207, "Barbara Johnson", "054-12-2367", 109_501.36, "Marketing");

        Director dir = new Director(12, "Susan Wheeler", "099-45-2340", 120_567.36, "Sales", 1_000_000.00);

        // Добавляем сотрудников в менеджера
        mgr.addEmployee(eng);
        mgr.addEmployee(adm);

        // Выводим информацию
        printEmployee(mgr);
        mgr.printStaffDetails();

        // Удаляем сотрудника и повторно выводим список
        System.out.println("\nУдаляем сотрудника с ID 304...");
        mgr.removeEmployee(304);
        mgr.printStaffDetails();
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
