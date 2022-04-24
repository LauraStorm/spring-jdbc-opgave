package com.example.demo.models;

import java.util.Date;

public class Employee {
    private int employeeId;
    private String name;
    private String job;
    private int manager;
    private String hireDate;
    private int salary;
    private int commission;
    private int deptNo;

    public Employee(String name, String job, String manager, String hireDate, String salary, String commission, String deptNo) {
        this.name = name;
        this.job = job;
        if (!manager.isEmpty()) {
            this.manager = Integer.parseInt(manager);
        } else {
            this.manager = 0;
        }
        this.hireDate = hireDate;
        this.salary = Integer.parseInt(salary);
        if (!commission.isEmpty()) {
            this.commission = Integer.parseInt(commission);
        } else {
            this.commission =0;
        }
        this.deptNo = Integer.parseInt(deptNo);
    }

    public Employee(int employeeId, String name, String job, int manager, String hireDate, int salary, int commission, int deptNo) {
        this.employeeId = employeeId;
        this.name = name;
        this.job = job;
        this.manager = manager;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commission = commission;
        this.deptNo = deptNo;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                "\t name= " + name + '\'' +
                "\t job= " + job + '\'' +
                "\t manager= " + manager +
                "\t hireDate= " + hireDate + '\'' +
                "\t salary= " + salary +
                "\t commission= " + commission +
                "\t deptNo= " + deptNo +
                "}";
    }
}
