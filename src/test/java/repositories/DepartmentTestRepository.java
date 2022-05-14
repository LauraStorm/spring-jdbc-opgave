package repositories;

import com.example.demo.models.Department;
import com.example.demo.repositories.CRUDInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentTestRepository implements CRUDInterface<Department> {
    ArrayList<Department> allDepartments = new ArrayList<Department>(
            Arrays.asList(
                    new Department(10, "SALES","CHICAGO"),
                    new Department(20, "MARKETING","CHICAGO"),
                    new Department(30, "HR","CHICAGO"),
                    new Department(40, "CUSTOMERSERVICE","CHICAGO")
            )
    );

    @Override
    public List<Department> getAllEntities() {
        return allDepartments;
    }

    @Override
    public boolean create(Department entity) {
        return false;
    }

    @Override
    public Department getSingleEntityById(int id) {
        return null;
    }

    @Override
    public boolean update(Department entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
