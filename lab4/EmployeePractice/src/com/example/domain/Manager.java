package com.example.domain;

public class Manager extends Employee {
    private String deptName;
    private Employee[] staff;   // Массив сотрудников
    private int employeeCount;  // Количество сотрудников

    public Manager(int id, String name, String SSN, double salary, String deptName) {
        super(id, name, SSN, salary);
        this.deptName = deptName;
        this.staff = new Employee[20];  // Максимум 20 сотрудников
        this.employeeCount = 0;
    }

    public String getDeptName() { return deptName; }

    public boolean addEmployee(Employee e) {
        if (employeeCount < staff.length) {
            staff[employeeCount++] = e;
            return true;
        }
        return false;  // Если массив заполнен
    }

    public boolean removeEmployee(int empId) {
        for (int i = 0; i < employeeCount; i++) {
            if (staff[i].getId() == empId) {
                // Сдвигаем массив, удаляя сотрудника
                for (int j = i; j < employeeCount - 1; j++) {
                    staff[j] = staff[j + 1];
                }
                staff[--employeeCount] = null;  // Убираем последний элемент
                return true;
            }
        }
        return false;  // Если сотрудник не найден
    }

    public void printStaffDetails() {
        System.out.println("\nManager: " + getName() + " (Department: " + deptName + ")");
        System.out.println("Staff under this manager:");
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(" - " + staff[i].getName() + " (ID: " + staff[i].getId() + ")");
        }
    }
}