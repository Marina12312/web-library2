package ru.skypro.lessons.springboot.weblibrary2.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Employee {

    private String name;
    private int salary;
    private final Integer id;
    private static Integer idGenerator = 1;

    public int getSalary() {
        return salary;
    }

    public Employee(String name, int salary){
         this.name=name;
         this.salary=salary;
         this.id=idGenerator++;
     }
}
