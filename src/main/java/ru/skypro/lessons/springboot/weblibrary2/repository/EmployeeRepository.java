package ru.skypro.lessons.springboot.weblibrary2.repository;

import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> getAllEmployees();
}
