package ru.skypro.lessons.springboot.weblibrary2.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary2.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Override
    public List<Employee> getEmployeesWithSalaryHigherThan(Integer salary) {
        List<Employee> salaryEmployeeBigerThenSalary = getAllEmployees().stream().filter(i -> i.getSalary() >= salary).toList();
        return salaryEmployeeBigerThenSalary;
    }

    @Override
    public List<Employee> getEmployeesByIdWithRequired(Integer id) {
        List<Employee> getIdEmployee = getAllEmployees().stream().filter(i -> i.equals(getAllEmployees().get(id))).toList();
        return getIdEmployee;
    }

    @Override
    public void deleteEmployeesWithId(Integer id) {
        getAllEmployees().remove(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        getAllEmployees().add(employee);
    }

    @Override
    public void editEmployee(int id) {
        getAllEmployees().get(id);
    }



}
