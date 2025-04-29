package com.practice.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TeacherData")
public class Teacher {
    @Id
    int id ;
 int salary;

    public int getId() {
        return id;
    }

    public Teacher(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Teacher(int id, int salary, String address) {
        this.id = id;
        this.salary = salary;
        this.address = address;
    }
    public  Teacher(){

    }

    String address;
}
