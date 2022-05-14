package com.example.demo.repositories;

import com.example.demo.models.Department;
import com.example.demo.utility.DatabaseConnectionManager;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class  DepartmentRepository implements CRUDInterface<Department>{
    @Override
    public List<Department> getAllEntities() {
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Department> allDepartments = new ArrayList<Department>();

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM departments");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Department tempDepartment = new Department(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
                );
                allDepartments.add(tempDepartment);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Something wrong with database - statement");
        }
        return allDepartments;
    }

    @Override
    public Department getSingleEntityById(int id) {
        Department singleDepartment = null;

        Connection conn = DatabaseConnectionManager.getConnection();

        try {
            PreparedStatement prstmt = conn.prepareStatement("SELECT * FROM departments WHERE department_number =?");
            prstmt.setInt(1, id);
            ResultSet rs = prstmt.executeQuery();

            //Springer første linje over
            rs.next();

            int departmentNumber = rs.getInt(1);
            String name = rs.getString(2);
            String location = rs.getString(3);

            singleDepartment = new Department(departmentNumber,name,location);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return singleDepartment;
    }

    @Override
    public boolean create(Department entity) {
        return false;
    }




    @Override
    public boolean update(Department entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
