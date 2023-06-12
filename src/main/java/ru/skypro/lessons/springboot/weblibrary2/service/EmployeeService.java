package ru.skypro.lessons.springboot.weblibrary2.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestBody;
import ru.skypro.lessons.springboot.weblibrary2.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeService  {
    List<EmployeeDTO> getAllNew();
    double salarySum();
    EmployeeDTO minSalary();
    EmployeeDTO maxSalary();
    List<EmployeeDTO> employeeHighSalary();

    List<EmployeeDTO> addEmployee(@RequestBody List<EmployeeDTO> employeeDTOS);
    void update(@RequestBody  int id, EmployeeDTO employeeDTO);
    void deleteEmployees(Integer id);
    EmployeeDTO getEmployeeById(@RequestBody  int id);

    List<EmployeeDTO> salaryHigherThan(Integer than);
    List<EmployeeDTO> withHighestSalary();
    List<EmployeeDTO> getEmployee(String e);
    EmployeeDTO getEmployeeFullInfo(int id);
    List<EmployeeDTO> getEmployeesFromPage(int page);






}
