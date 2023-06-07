package ru.skypro.lessons.springboot.weblibrary2.service;

import org.springframework.web.bind.annotation.RequestBody;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    double salarySum();
    double minSalary();
    double maxSalary();
    List<Employee> employeeHighSalary();
    HashMap<Integer, Employee> getAllNew();

    void addEmployee();

    Employee getEmployeeById(int id);

    void deleteEmployee(int id);

    List<Map.Entry<Integer, Employee>> salaryHigherThan(Integer than);




}
