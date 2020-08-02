package com.thoughtworks.springbootemployee.dto;

import com.thoughtworks.springbootemployee.model.Employee;

public class EmployeeRequestDto {
    private Integer age;
    private String name;
    private String gender;
    private Integer company_id;
    private Double salery;

    public EmployeeRequestDto(Integer age, String name, String gender, Integer company_id, Double salery) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.company_id = company_id;
        this.salery = salery;
    }

    public EmployeeRequestDto() {
    }


    public static Employee toEmployeeEntity(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();
        employee.setCompanyId(employeeRequestDto.getCompany_id());
        employee.setName(employeeRequestDto.getName());
        employee.setGender(employeeRequestDto.getGender());
        employee.setAge(employeeRequestDto.getAge());
        employee.setSalery(employeeRequestDto.getSalery());
        return employee;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Double getSalery() {
        return salery;
    }

    public void setSalery(Double salery) {
        this.salery = salery;
    }
}
