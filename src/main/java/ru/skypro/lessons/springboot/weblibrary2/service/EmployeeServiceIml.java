package ru.skypro.lessons.springboot.weblibrary2.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary2.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceIml implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceIml(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public double salarySum() {
        return employeeRepository.getAllEmployees().stream().mapToDouble(Employee::getSalary).sum();
    }

    @Override
    public double minSalary() {
        return employeeRepository.getAllEmployees().stream().min(Comparator.comparing(Employee::getSalary)).orElseThrow().getSalary();
    }

    @Override
    public double maxSalary() {
        return employeeRepository.getAllEmployees().stream().max(Comparator.comparing(Employee::getSalary)).orElseThrow().getSalary();
    }

    @Override
    public List<Employee> employeeHighSalary() {
        double high = salarySum();
        int size = employeeRepository.getAllEmployees().size();
        return employeeRepository.getAllEmployees().stream()
                .filter(a -> a.getSalary() > high / size)
                .collect(Collectors.toList());
    }
}
