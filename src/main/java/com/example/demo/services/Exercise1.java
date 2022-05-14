package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.EmployeeRepository;

import java.util.List;

/*
Exercise 1
Implement the following functionality:
Write a service method that finds and returns the highest department number
 */
public class Exercise1 {
    private CRUDInterface employeeRepository;

    public Exercise1 (CRUDInterface<Employee> repo){
        this.employeeRepository = repo;
    }

    public int getHighestDepartmentNumber(){
        //Get all employees
        List<Employee> allEmployees = employeeRepository.getAllEntities();

        //find highest department number
        int maxDepartmentNumber = 0;

        for (Employee currentEmployee: allEmployees) {
            int currentEmployeesDepartmentNumber = currentEmployee.getDeptNo();

            if (maxDepartmentNumber < currentEmployeesDepartmentNumber){
                maxDepartmentNumber = currentEmployeesDepartmentNumber;
            }
        }
        return maxDepartmentNumber;

    }

}
