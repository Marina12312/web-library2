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
    private final HashMap<Integer, Employee> employeeMap = new HashMap<>();

    @Override
    public void addEmployee() {
        Employee employee = new Employee("Лариса", 98_000);
        Employee employee1 = new Employee("Полина", 110_000);
        Employee employee2 = new Employee("Алиса", 89_000);
        Employee employee3 = new Employee("Влада", 101_000);

    }
@SneakyThrows
    @Override
    public Employee getEmployeeById(int id) throws IOException {
        if (!employeeMap.containsKey(id)) {
            throw new IOException();
        }
        return employeeMap.get(id);
    }

@SneakyThrows
    @Override
    public void deleteEmployee(int id) throws IOException {
    if (!employeeMap.containsKey(id)) {
        throw new IOException();
    }
    employeeMap.remove(id);
}


    @Override
    public HashMap<Integer, Employee> getNewEmployees() {
        return employeeMap;
    }


}
