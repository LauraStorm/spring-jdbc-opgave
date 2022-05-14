package com.example.demo.services;

import com.example.demo.models.Department;
import com.example.demo.repositories.CRUDInterface;

import java.util.List;

public class DepartmentService {
    private final CRUDInterface<Department> repo;

    public DepartmentService(CRUDInterface<Department> repo){
        this.repo = repo;
    }

    public int findLongestNameOfDepartments(){
        //Kalde Repository
        //Få alle Departments
        List<Department> allDepartments = repo.getAllEntities();

        //Finde længste navn
        int currentMax = 0;
        for (Department dept: allDepartments) {
            if(dept.getDeptName().length() > currentMax){
                currentMax = dept.getDeptName().length();
            }
        }
        //Returnere tallet på det længste navn
        return currentMax;
    }
}
