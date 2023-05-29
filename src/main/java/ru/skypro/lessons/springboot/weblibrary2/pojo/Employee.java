package ru.skypro.lessons.springboot.weblibrary2.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private String name;
    private int salary;

    public int getSalary() {
        return salary;
    }

    public Employee(String name, int salary){
         this.name=name;
         this.salary=salary;
     }
}
