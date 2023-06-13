package ru.skypro.lessons.springboot.weblibrary2.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrary2.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;
import ru.skypro.lessons.springboot.weblibrary2.service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/employees")
@RestController
@RestControllerAdvice
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/sum/salary")
    public double getSalarySum() {

        return employeeService.salarySum();
    }

    @GetMapping("/min/salary")
    public EmployeeDTO getSalaryMin() {
        return employeeService.minSalary();
    }

    @GetMapping("/max/salary")
    public EmployeeDTO getSalaryMax() {
        return employeeService.maxSalary();
    }

    @GetMapping("/high/salary")
    public List<EmployeeDTO> getEmployeeHighSalary() {
        return employeeService.employeeHighSalary();
    }

    @PostMapping
    public List<EmployeeDTO> addNewEmployee(@RequestBody List<EmployeeDTO> employeeDTOS) {
        return employeeService.addEmployee(employeeDTOS);
    }

    @GetMapping("{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("{id}")
    public void editEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.update(id, employeeDTO);
    }

    @GetMapping("salaryHigherThan")
    public List<EmployeeDTO> salaryHigherThan(@RequestParam("salary") Integer compareSalary) {
        return employeeService.salaryHigherThan(compareSalary);
    }

    @GetMapping("withHighestSalary")
    public List<EmployeeDTO> salaryWithHighestSalary() {
        return employeeService.withHighestSalary();
    }

    @GetMapping
    public List<EmployeeDTO> getEmployeesForPosition(@RequestParam(required = false) String position) {
        return employeeService.getEmployee(
                Optional.ofNullable(position)
                        .filter(p -> !p.isEmpty())
                        .orElse(null));
    }

    @GetMapping("/{id}/fullInfo")
    public EmployeeDTO getEmployeeFullInfo(@PathVariable int id) {
        return employeeService.getEmployeeFullInfo(id);
    }

    @GetMapping("/page")
    public List<EmployeeDTO> getEmployeesFromPage(@RequestParam(required = false, defaultValue = "0") int page) {
        return employeeService.getEmployeesFromPage(page);

    }

}