package ru.skypro.lessons.springboot.weblibrary2.pojo;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@EqualsAndHashCode
@Table(name = "employee")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String name;
    private int salary;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;

public  Employee(){
}
    public Employee(String name, int salary){
         this.name=name;
         this.salary=salary;
         this.id=id;

     }

    public int getSalary() {
        return salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
