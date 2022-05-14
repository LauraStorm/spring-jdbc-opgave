package com.example.demo.services;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.repositories.CRUDInterface;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.EmployeeRepository;

import java.util.*;

/*
Exercise 2
Implement the following functionality:
Write a service method that returns department with the most employees
 */
public class Exercise2 {
    private CRUDInterface employeeRepository;
    private CRUDInterface departmentRepository;

    public Exercise2 (CRUDInterface<Employee> repoEmployee, CRUDInterface<Department> repoDepartment){
        this.employeeRepository = repoEmployee;
        this.departmentRepository = repoDepartment;
    }


    public Department getDepartmentWithMostEmployees(){

        //Get all employees
        List<Employee> allEmployees = employeeRepository.getAllEntities();

        //gem departmentID i hashmap<key,Value>
        HashMap<Integer, Integer> departmentsIDs = new HashMap<>();

        for (Employee currentEmployee: allEmployees) {
            int currentEmployeeDepNumberID = currentEmployee.getDeptNo();

            if (departmentsIDs.containsKey(currentEmployeeDepNumberID)){        //Hvis depNo allerede er i listen
                int count = departmentsIDs.get(currentEmployeeDepNumberID);
                departmentsIDs.put(currentEmployeeDepNumberID,count + 1);       //Så skal value + med 1

            } else {
                departmentsIDs.put(currentEmployeeDepNumberID,1 );              //Hvis ikke depNo er i listen, tilføjes den
            }

        }

        //find det departmentID der er flest employee der har
        int maxValueInMap = (Collections.max(departmentsIDs.values()));

        // Iterate through HashMap
        int depNoIDMaxV = 0;

        for (Map.Entry<Integer, Integer> entry : departmentsIDs.entrySet()) {

            if (entry.getValue() == maxValueInMap) {
                // Print the key with max value
                depNoIDMaxV = entry.getKey();
            }
        }

        //Get Department
        List<Department> d = departmentRepository.getAllEntities();

        Department mostPopular = null;
        for (Department current : d) {
            if (current.getDeptno() == depNoIDMaxV){
                int depNo = current.getDeptno();
                String name = current.getDeptName();
                String location = current.getLocation();
                mostPopular = new Department(depNo,name,location);
            }

        }

        //Object departmentWithMostEmployees = departmentRepository.getSingleEntityById(depNoIDMaxV);



        //Returner departmentet'
        return mostPopular;
    }


}
