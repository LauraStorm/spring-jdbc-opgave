package com.example.demo.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestEx2Test {

    @Test
    void isDepartmentNumberValid() {
        //Arrange
        UnitTestEx2 unitTestEx = new UnitTestEx2();
        boolean validDepartmentNumber = true;
        boolean invalidDepNumber = false;

        //Act
        boolean validDep = unitTestEx.isDepartmentNumberValid(990);
        boolean invalidDep = unitTestEx.isDepartmentNumberValid(11);

        //Assert
        assertTrue(validDep);
        assertFalse(invalidDep);

    }
}