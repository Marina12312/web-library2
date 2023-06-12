package ru.skypro.lessons.springboot.weblibrary2.service;

import org.springframework.web.bind.annotation.RequestBody;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    double salarySum();
    double minSalary();
    double maxSalary();
    List<Employee> employeeHighSalary();

     List<Employee> getEmployeesWithSalaryHigherThan(Integer salary);
     List<Employee> getEmployeesByIdWithRequired(Integer id);
    void deleteEmployeesWithId(Integer id);

    void addEmployee(@RequestBody Employee employee);
    void editEmployee(@RequestBody int id);






}
