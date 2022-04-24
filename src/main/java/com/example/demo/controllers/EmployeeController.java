package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @GetMapping("/singleEmployee")  //Skriv dette: http://localhost:8080/singleEmployee?id=7521   7521 er et eks på id nummer i databasen
    public String getAEmployee(Model m, @RequestParam int id){
        //opretter et enkelt single objekt af Employee og bruger metoden 'getSingleEntinityById' til at finde den ønskede Employee
        Employee oneEmployee = employeeRepository.getSingleEntityById(id);  //@RequestParam bruges til at kunne skrive i url'en (bruger id, til at finde employee)
       //bruger m (Model) til at hente data fra databasen (Employee data) til vores View
        m.addAttribute("employee",oneEmployee);
        return "singleEmployee";
    }

    @GetMapping("/allEmployees")
    public String getAllEmployees(Model employeesModelData){
        //Opretter en liste til at gemme alle Employee info fra databaasen ved hjælp af metoden ' getAllEntities'
        List<Employee> allEmployees = employeeRepository.getAllEntities();
        //Så referere vi til Model 'employeesModelData' - hvor vi adder alle Employee til VIEW
        employeesModelData.addAttribute("employees", allEmployees);
        return "employees";
    }

    @GetMapping("/create-new-employee")
    public String createNewEmployeePage(){
        return "createEmployee";
    }

    @PostMapping("/create-new-employee")
    public String createNewEmployee(WebRequest dataFromForm){
        //Få fat i inputtet fra brugeren via en form i HMTL sheet
        String employeeName = dataFromForm.getParameter("employeeName");
        String job = dataFromForm.getParameter("job");
        String manager = dataFromForm.getParameter("manager");
        String hireDate = dataFromForm.getParameter("hireDate");
        String salary = dataFromForm.getParameter("salary");
        String commission = dataFromForm.getParameter("commission");
        String departmentNo = dataFromForm.getParameter("departmentNo");
        //opret object af Employee
        Employee newEmployee = new Employee(employeeName,job,manager,hireDate,salary,commission,departmentNo);

        //Hvis employee objektet er udfyld rigtigt via Formen(HTML SHEET) vil vi få over blikket over allEmployees. ELLERs redirecter den til index side (/)
        if ( employeeRepository.create(newEmployee) == true){
            System.out.println(newEmployee);
            return "redirect:/allEmployees";
        } else{
            return "redirect:/";
        }

    }
}
