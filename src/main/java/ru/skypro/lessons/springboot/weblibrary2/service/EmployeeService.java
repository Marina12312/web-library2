package ru.skypro.lessons.springboot.weblibrary2.service;

import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    double salarySum();
    double minSalary();
    double maxSalary();
    List<Employee> employeeHighSalary();
}
