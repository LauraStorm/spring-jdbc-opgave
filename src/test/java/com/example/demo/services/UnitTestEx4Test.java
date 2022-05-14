package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import repositories.EmployeeTestRepository;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestEx4Test {

    @Test
    void isSalaryAboveTheAverage() {
        //Arrange
        CRUDInterface<Employee> testEmployeeRepository = new EmployeeTestRepository();
        UnitTestEx4 unitTestEx4EmployeeService = new UnitTestEx4(testEmployeeRepository);

        Employee expectedValidSalaryAbove = new Employee("laura","test","0","01-02-2019", "400", "99", "10" );
        Employee expectedInvalidSalaryAbove =new Employee("laura","test","0","01-02-2019", "100", "100", "10" );

        //Act
        boolean valid = unitTestEx4EmployeeService.isSalaryAboveTheAverage(expectedValidSalaryAbove); //500 er over average
        boolean invalid = unitTestEx4EmployeeService.isSalaryAboveTheAverage(expectedInvalidSalaryAbove); //100 er ikke

        //Assert
        assertTrue(valid);
        assertFalse(invalid);
    }
}