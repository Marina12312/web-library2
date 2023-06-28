package ru.skypro.lessons.springboot.weblibrary2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.skypro.lessons.springboot.weblibrary2.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrary2.pojo.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT SUM(e.salary) from  Employee e")
    double salarySum();
    @Query("SELECT AVG(e.salary) from  Employee e")
    int employeeHighSalary();

    @Query("SELECT new ru.skypro.lessons.springboot.weblibrary2.dto.EmployeeDTO(e.id, e.name, e.salary, p.position) FROM Employee  e left join Position p on p.id = e.position.id where  e.salary = (SELECT MIN(e.salary) from  Employee e)")
    Optional<EmployeeDTO> minSalary();
    @Query("SELECT new ru.skypro.lessons.springboot.weblibrary2.dto.EmployeeDTO(e.id, e.name, e.salary, p.position) FROM Employee  e left join Position p on p.id = e.position.id where e.salary = (SELECT MAX(e.salary) from  Employee e)")
    List<EmployeeDTO> maxSalary();

    List<Employee> findEmployeeBySalaryIsGreaterThan(Integer salary);
    List<Employee> findEmployeeByPosition_Position(String position);


}
