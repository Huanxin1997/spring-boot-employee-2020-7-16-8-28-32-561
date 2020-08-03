package com.thoughtworks.springbootemployee.model;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Double salery;
    private Integer companyId;

    public Employee() {
    }

    public Employee(String name, Integer age, String gender, Double salery, Integer company_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salery = salery;
        this.companyId = company_id;
    }

    public Employee(Integer id, String name, Integer age, String gender, Double salery) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salery = salery;
    }

    public Employee(String name, Integer age, String gender, Double salery) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salery = salery;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalery() {
        return salery;
    }

    public void setSalery(Double salery) {
        this.salery = salery;
    }

    public Integer getCompany_id() {
        return companyId;
    }

    public void setCompany_id(Integer company_id) {
        this.companyId = company_id;
    }
}
