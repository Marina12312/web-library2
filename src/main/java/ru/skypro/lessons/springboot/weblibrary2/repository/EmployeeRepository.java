package ru.skypro.lessons.springboot.weblibrary2.repository;

import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeRepository {
    public List<Employee> getAllEmployees();

    void addEmployee();
    Employee getEmployeeById(int id) throws IOException;
    void deleteEmployee(int id) throws IOException;

    HashMap<Integer, Employee> getNewEmployees();
}
