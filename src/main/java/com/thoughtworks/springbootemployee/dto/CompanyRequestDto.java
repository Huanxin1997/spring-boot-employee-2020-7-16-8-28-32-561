package com.thoughtworks.springbootemployee.dto;

public class CompanyRequestDto {

    private Integer company_id;
    private String companyName;
    private Integer employeesNumber;

    public CompanyRequestDto(Integer company_id, String companyName, Integer employeesNumber) {
        this.company_id = company_id;
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
    }

    public CompanyRequestDto() {
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }
}
