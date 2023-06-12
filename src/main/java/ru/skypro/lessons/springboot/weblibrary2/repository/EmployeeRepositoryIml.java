package ru.skypro.lessons.springboot.weblibrary2.repository;

import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
@Repository
@EqualsAndHashCode
public class EmployeeRepositoryIml implements EmployeeRepository{
    private final List<Employee> employeeList = List.of(
            new Employee("Катя", 90_000),
            new Employee("Дима", 102_000),
            new Employee("Олег", 80_000),
            new Employee("Вика", 165_000));
    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }





    }





