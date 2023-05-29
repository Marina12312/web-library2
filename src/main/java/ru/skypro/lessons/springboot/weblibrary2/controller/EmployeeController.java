package ru.skypro.lessons.springboot.weblibrary2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary2.service.EmployeeService;

import java.util.List;

@RequestMapping("/employee/")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> showCount() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("sum")
    public double getSalarySum(){
        return employeeService.salarySum();
    }
    @GetMapping("min")
    public double getSalaryMin(){
        return employeeService.minSalary();
    }
    @GetMapping("max")
    public double getSalaryMax(){
        return employeeService.maxSalary();
    }
    @GetMapping("high")
    public List<Employee> getEmployeeHighSalary(){
        return employeeService.employeeHighSalary();
    }

}