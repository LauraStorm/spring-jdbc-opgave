package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

/* Exercise-set #2
    (Improvement) Exercise 4.2 - employees and departments
     Implement the following functionality:
     Given an Employee object, return true if the Employee has a salary above the average of all employees
    */
public class UnitTestEx4 {
    private CRUDInterface employeeRepo;

    public UnitTestEx4 (CRUDInterface<Employee> repo){
        this.employeeRepo = repo;
    }

    public boolean isSalaryAboveTheAverage (Employee employee){
        //One emplyees salary
        int employeeSalary = employee.getSalary();

        //Get all employees
        List<Employee> allEmployee = employeeRepo.getAllEntities();

        //Find the average
        int sum = 0;
        for (Employee currentEmployee: allEmployee) {
            int currentEmployeeSalary = currentEmployee.getSalary();
            sum = sum + currentEmployeeSalary;

        }
        //Average Result
        int average = sum / allEmployee.size();

        //Check if the salary is above the average
        if (average < employeeSalary){
            return true;
        }else{
            return false;
        }

    }

}
