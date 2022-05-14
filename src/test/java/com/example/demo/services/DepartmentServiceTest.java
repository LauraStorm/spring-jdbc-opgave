package com.example.demo.services;

import com.example.demo.models.Department;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.DepartmentRepository;
import org.junit.jupiter.api.Test;
import repositories.DepartmentTestRepository;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    @Test
    void findLongestNameOfDepartments() {
        //Arrange
        CRUDInterface<Department> testDepartmentRepository = new DepartmentTestRepository();
        DepartmentService deptService = new DepartmentService(testDepartmentRepository);
        int expectedLongestDepartmentNameResult = 15;  //15 er det længeste Department Name - ændres tallet vil testen fejle
        //act
        int validLengthResult = deptService.findLongestNameOfDepartments();

        //assert
        assertEquals(expectedLongestDepartmentNameResult,validLengthResult);
    }
}