package ru.skypro.lessons.springboot.weblibrary2.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary2.service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/employees")
@RestController
@RestControllerAdvice
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public List<Employee> showCount() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/sum/salary")
    public double getSalarySum(){
        return employeeService.salarySum();
    }
    @GetMapping("/min/salary")
    public double getSalaryMin(){
        return employeeService.minSalary();
    }
    @GetMapping("/max/salary")
    public double getSalaryMax(){
        return employeeService.maxSalary();
    }
    @GetMapping("/high/salary")
    public List<Employee> getEmployeeHighSalary(){
        return employeeService.employeeHighSalary();
    }
    @GetMapping("/salaryHigherThan")
    public List<Employee> getEmployeesWithSalaryHigherThan(@RequestParam("salary") Integer salary) {
        return employeeService.getEmployeesWithSalaryHigherThan(salary);
    }

    @GetMapping("{id}")
    public List<Employee> getEmployeesByIdWithRequired(@PathVariable(required = false) Integer id) {
        return employeeService.getEmployeesByIdWithRequired(id);
    }

    @DeleteMapping("{id}")//?
    public void deleteEmployeesWithId(@PathVariable(required = false) Integer id) {
        employeeService.deleteEmployeesWithId(id);
    }

    @PostMapping("/") //?
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("{id}") //?
    public void editEmployee(@RequestBody int id) {
        employeeService.editEmployee(id);
    }
}