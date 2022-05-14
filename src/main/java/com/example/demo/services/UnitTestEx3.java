package com.example.demo.services;

import com.example.demo.models.Employee;

public class UnitTestEx3 {
    /*
    An employee can never receive a higher commission than their base salary
    The method receives an employee object and returns true if the salary is valid
    The method returns false if the salary is not valid
     */

    public boolean isSalaryValid (Employee oneEmployee){
        int commission = oneEmployee.getCommission();
        int baseSalary = oneEmployee.getSalary();

        if (commission > baseSalary){
            System.out.println("The salary is invalid --> The commission is higher than the employees base salary! 👎🏼 ");
            return false;
        } else{
            System.out.println("The salary is valid --> The commission is not higher than the base salary! 👍🏼");
            return true;
        }

    }
}
