package com.example;

import com.example.dao.EmployeeDAO;
import com.example.dao.EmployeeDAOFactory;
import com.example.model.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeTestInteractive {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = EmployeeDAOFactory.createEmployeeDAO();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");

        while (true) {
            System.out.println("1. Add Employee\n2. Update Employee\n3. Delete Employee\n4. Find Employee\n5. List Employees\n6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Birth Date (MMM dd, yyyy): ");
                    String birthDateStr = scanner.nextLine();
                    try {
                        Date birthDate = sdf.parse(birthDateStr);
                        employeeDAO.add(new Employee(id, name, birthDate));
                    } catch (ParseException e) {
                        System.out.println("Invalid date format.");
                    }
                    break;
                case 2:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Birth Date (MMM dd, yyyy): ");
                    String newBirthDateStr = scanner.nextLine();
                    try {
                        Date newBirthDate = sdf.parse(newBirthDateStr);
                        employeeDAO.update(new Employee(updateId, newName, newBirthDate));
                    } catch (ParseException e) {
                        System.out.println("Invalid date format.");
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    employeeDAO.delete(deleteId);
                    break;
                case 4:
                    System.out.print("Enter ID to find: ");
                    int findId = scanner.nextInt();
                    Employee foundEmployee = employeeDAO.findById(findId);
                    System.out.println(foundEmployee != null ? foundEmployee.getName() : "Not found");
                    break;
                case 5:
                    List<Employee> employees = employeeDAO.getAllEmployees();
                    for (Employee emp : employees) {
                        System.out.println(emp.getId() + ": " + emp.getName());
                    }
                    break;
                case 6:
                    return;
            }
        }
    }
}