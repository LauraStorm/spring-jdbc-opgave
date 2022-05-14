package com.example.demo.services;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import repositories.DepartmentTestRepository;
import repositories.EmployeeTestRepository;

import static org.junit.jupiter.api.Assertions.*;

class Exercise2Test {

    @Test
    void getDepartmentWithMostEmployees() {
        //ARRANGE
        CRUDInterface<Employee> employeeTestRepo = new EmployeeTestRepository();
        CRUDInterface<Department> departmentTestRepo = new DepartmentTestRepository();
        Exercise2 exercise2Service = new Exercise2(employeeTestRepo,departmentTestRepo);

        int expectedMostEmployeeId = 10;
        Department expectedDepartment = new Department(10, "SALES","CHICAGO");

        //ACT
        Department depIDMostEmployees = exercise2Service.getDepartmentWithMostEmployees();

        //ASSERT
        assertEquals(expectedDepartment.toString(),depIDMostEmployees.toString());
    }
}