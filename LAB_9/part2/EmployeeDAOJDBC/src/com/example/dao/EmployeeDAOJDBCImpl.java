package com.example.dao;

import com.example.model.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {

    private Connection con = null;

    public EmployeeDAOJDBCImpl() {
        String url = "jdbc:postgresql://localhost:5432/employee";
        String username = "postgres";
        String password = "postgres";

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException se) {
            System.out.println("Error obtaining connection: " + se);
            System.exit(1);
        }
    }

    @Override
    public void add(Employee emp) throws DAOException {
        String query = "INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getFirstName());
            stmt.setString(3, emp.getLastName());
            stmt.setDate(4, new java.sql.Date(emp.getBirthDate().getTime()));
            stmt.setFloat(5, emp.getSalary());

            if (stmt.executeUpdate() != 1) {
                throw new DAOException("Error adding employee");
            }
        } catch (SQLException se) {
            throw new DAOException("Error adding employee in DAO", se);
        }
    }

    @Override
    public void update(Employee emp) throws DAOException {
        String query = "UPDATE EMPLOYEE SET FIRSTNAME=?, LASTNAME=?, BIRTHDATE=?, SALARY=? WHERE ID=?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, emp.getFirstName());
            stmt.setString(2, emp.getLastName());
            stmt.setDate(3, new java.sql.Date(emp.getBirthDate().getTime()));
            stmt.setFloat(4, emp.getSalary());
            stmt.setInt(5, emp.getId());

            if (stmt.executeUpdate() != 1) {
                throw new DAOException("Error updating employee");
            }
        } catch (SQLException se) {
            throw new DAOException("Error updating employee in DAO", se);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        Employee emp = findById(id);
        if (emp == null) {
            throw new DAOException("Employee ID " + id + " does not exist.");
        }

        String query = "DELETE FROM EMPLOYEE WHERE ID = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);

            if (stmt.executeUpdate() != 1) {
                throw new DAOException("Error deleting employee");
            }
        } catch (SQLException se) {
            throw new DAOException("Error deleting employee in DAO", se);
        }
    }

    @Override
    public Employee findById(int id) throws DAOException {
        String query = "SELECT * FROM EMPLOYEE WHERE ID = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Employee(
                        rs.getInt("ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getDate("BIRTHDATE"),
                        rs.getFloat("SALARY")
                );
            } else {
                return null;
            }
        } catch (SQLException se) {
            throw new DAOException("Error finding employee", se);
        }
    }

    @Override
    public Employee[] getAllEmployees() throws DAOException {
        ArrayList<Employee> emps = new ArrayList<>();
        String query = "SELECT * FROM EMPLOYEE";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                emps.add(new Employee(
                        rs.getInt("ID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getDate("BIRTHDATE"),
                        rs.getFloat("SALARY")
                ));
            }
        } catch (SQLException se) {
            throw new DAOException("Error retrieving all employees", se);
        }

        return emps.toArray(new Employee[0]);
    }

    @Override
    public void close() {
        try {
            if (con != null) con.close();
        } catch (SQLException se) {
            System.out.println("Exception closing connection: " + se);
        }
    }
}

