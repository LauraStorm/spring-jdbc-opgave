package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.CRUDInterface;
import org.junit.jupiter.api.Test;
import repositories.EmployeeTestRepository;

import static org.junit.jupiter.api.Assertions.*;

class Exercise1Test {

    @Test
    void getHighestDepartmentNumber() {
        //Arrange
        CRUDInterface<Employee> testEmployeeRepository = new EmployeeTestRepository();
        Exercise1 exercise1Service = new Exercise1(testEmployeeRepository);

        int expectedHighestDepartmentNumber = 40;  //Højeste i testRepo er 40 Hvis dette tal ændres vil testen fejle - så det virker
        int expectedLowestDepartmentNumber = 10;


        //Act
        int highestDepartmentNumberResult = exercise1Service.getHighestDepartmentNumber();
        int lowestDepartmentNumberResult = exercise1Service.getHighestDepartmentNumber();

        //Assert
        assertEquals(expectedHighestDepartmentNumber,highestDepartmentNumberResult);
    }
}