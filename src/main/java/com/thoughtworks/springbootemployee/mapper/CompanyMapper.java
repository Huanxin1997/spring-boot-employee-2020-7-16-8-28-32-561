package com.thoughtworks.springbootemployee.mapper;

import com.thoughtworks.springbootemployee.dto.CompanyRequestDto;
import com.thoughtworks.springbootemployee.model.Company;

public class CompanyMapper {
    public Company toCompanyEntity(CompanyRequestDto companyRequestDto) {
        Company company = new Company();
        company.setCompanyName(companyRequestDto.getCompanyName());
        company.setEmployeesNumber(companyRequestDto.getEmployeesNumber());
        return company;
    }
}
