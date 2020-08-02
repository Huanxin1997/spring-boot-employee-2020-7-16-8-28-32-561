package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll() {
        return this.companyRepository.findAll();
    }

    public List<Company> findAll(int page, int pageSize) {
        return this.companyRepository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    public Company findById(int companyId) {
        return this.companyRepository.findById(companyId).orElse(null);
    }

    public List<Employee> findEmployeesById(int companyId) {
        Company company = this.companyRepository.findById(companyId).orElse(null);
        return company == null ? null : company.getEmployees();
    }

    public Company add(Company company) {
        return this.companyRepository.save(company);
    }

    public Company update(int companyId, Company company) {
        Company companyUpdated = this.companyRepository.findById(companyId).orElse(null);
        if (companyUpdated == null) {
            return null;
        }
        companyUpdated.setCompanyName(company.getCompanyName());
        companyUpdated.setEmployeesNumber(company.getEmployeesNumber());
        return this.companyRepository.save(companyUpdated);
    }

    public boolean deleteById(int companyId) {
        companyRepository.deleteById(companyId);
        return findById(companyId) == null;
    }
}
