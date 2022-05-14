package com.example.demo.repositories;

import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements CRUDInterface <Employee> {

    @Override
    public boolean create(Employee entity) {

        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO employees (employee_name,job,manager,hiredate,salary,commission,department_number)" +
                    "VALUES (?,?,?,?,?,?,?) ");

            stmt.setString(1,entity.getName());
            stmt.setString(2,entity.getJob());
            stmt.setInt(3,entity.getManager());
            stmt.setString(4,entity.getHireDate());
            stmt.setInt(5,entity.getSalary());
            stmt.setInt(6, entity.getCommission());
            stmt.setInt(7, entity.getDeptNo());

            stmt.executeUpdate();
            System.out.println("New employee updated to the DB");
            return true;

        } catch (SQLException e){
            System.out.println("something went wrong with adding an employee");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee getSingleEntityById(int id) {
        Employee chosenEmployee = null;

        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees WHERE id=?");
            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            int empId = rs.getInt("id");
            String name = rs.getString("employee_name");
            String job = rs.getString("job");
            int manager = rs.getInt("manager");
            String hireDate = rs.getString("hiredate");
            int salary = rs.getInt("salary");
            int commission = rs.getInt("commission");
            int deptNo = rs.getInt("department_number");

            chosenEmployee = new Employee(empId,name,job,manager,hireDate,salary,commission,deptNo);
            System.out.println("Single user is found: " + chosenEmployee);

        } catch (SQLException e) {
            System.out.println("something went wrong with finding a single employee with id");
            e.printStackTrace();
        }

        return chosenEmployee;
    }

    @Override
    public List getAllEntities() {
        ArrayList<Employee> allEmployees = new ArrayList<>();

        try {
            Connection conn = DatabaseConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employees ");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("employee_name");
                String job = rs.getString("job");
                int manager = rs.getInt("manager");
                String hireDate = rs.getString("hiredate");
                int salary = rs.getInt("salary");
                int commission = rs.getInt("commission");
                int deptNo = rs.getInt("department_number");

                Employee currentEmployee = new Employee(id,name,job, manager,hireDate,salary,commission,deptNo);
                allEmployees.add(currentEmployee);


            }
            System.out.println("All employees is found and shown!");
        } catch (SQLException e) {
            System.out.println("something went wrong with finding all employees");
            e.printStackTrace();
        }

        return allEmployees;
    }

    @Override
    public boolean update(Employee entity) {
        return false;
    }


    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
