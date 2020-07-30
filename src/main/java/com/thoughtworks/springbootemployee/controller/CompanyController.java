package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    List<Company> companies = new LinkedList<>();

    @Autowired
    private CompanyService companyService;

    public CompanyController() {
    }

    @GetMapping
    public List<Company> getCompanies(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "0") int pageSize
    ) {
        if (page == 0) {
            return companyService.getAllCompanies();
        } else {
            return (List<Company>) companyService.getCompanyByPage(page, pageSize);
        }
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployees(@PathVariable int id) {
        return companyService.getCompanyEmployeesById(id);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable int id, @RequestBody Company company) {
        Company updatedCompany = companyService.updateCompany(id, company);
        return updatedCompany;
    }

    @DeleteMapping("/{id}")
//    TODO return type
    public String deleteAllEmployees(@PathVariable int id) {
        companyService.removeCompany(id);
        return "Delete Success";
    }
}

