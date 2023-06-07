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
    @PostMapping
    public void addNewEmployee(){
        employeeService.addEmployee();
    }
    @PutMapping  ("/{id}")
public void editEmployee(@PathVariable int id,@RequestBody Employee employee) {
    employeeService.getEmployeeById(id).setName(employee.getName());
    employeeService.getEmployeeById(id).setSalary(employee.getSalary());
}
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }
@DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        
}
    @GetMapping("/all-employee-new")
    public HashMap<Integer, Employee> all() {
        return employeeService.getAllNew();
    }

    @GetMapping("salaryHigherThan")
    public List<Map.Entry<Integer, Employee>> salaryHigherThan(@RequestParam("salary") Integer compareSalary) {
        return employeeService.salaryHigherThan(compareSalary);
    }
}