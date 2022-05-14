package com.example.demo.services;

public class UnitTestEx2 {

    public boolean isDepartmentNumberValid(int departmentNumber){

        if(departmentNumber < 10){
            return false;
        }
        if (departmentNumber < 1000){
            if (departmentNumber % 10 == 0){
                return true;
            }
        }

       return false;
    }
}
