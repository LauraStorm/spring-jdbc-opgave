package repositories;

import com.example.demo.models.Employee;
import com.example.demo.repositories.CRUDInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeTestRepository implements CRUDInterface<Employee> {
    ArrayList<Employee> allEmployees = new ArrayList<Employee>(
            Arrays.asList(
                    new Employee(1,"laura","Tester",7902,"01-01-2010", 100,0,10),
                    new Employee(2,"lene","Tester",7903,"01-02-2010", 100,0,20),
                    new Employee(3,"morten","Tester",7904,"01-03-2010", 100,0,10),
                    new Employee(4,"jeppe","Tester",7905,"01-04-2010", 100,0,40)
            )
    );

    @Override
    public List<Employee> getAllEntities() {
        return allEmployees;
    }
    @Override
    public boolean create(Employee entity) {
        return false;
    }

    @Override
    public Employee getSingleEntityById(int id) {
        return null;
    }


    @Override
    public boolean update(Employee entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
