package com.example.demo.services;

import com.example.demo.models.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestEx3Test {

    @Test
    void isSalaryValid() {
        //Arrange
        UnitTestEx3 unitTestEx3 = new UnitTestEx3();
        Employee expectedValidSalary = new Employee("laura","test","0","01-02-2019", "100", "99", "10" );
        Employee expectedInvalidSalary =new Employee("laura","test","0","01-02-2019", "100", "101", "10" );

        //Act
        boolean valid = unitTestEx3.isSalaryValid(expectedValidSalary);
        boolean invalid = unitTestEx3.isSalaryValid(expectedInvalidSalary);

        //Assert
        assertTrue(valid);
        assertFalse(invalid);
    }

    @Test
    void isSalaryValidInterface(){

    }
}