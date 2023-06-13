package ru.skypro.lessons.springboot.weblibrary2.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Integer salary;

    private String position;


    public EmployeeDTO() {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
