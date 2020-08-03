package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.exceptioin.NotFoundException;
import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getCompanies(Integer page, Integer pageSize) {
        if (page != null || pageSize != null) {
            return companyService.findAll(page, pageSize);
        }
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company getCompanyById(@PathVariable int id) throws NotFoundException {
        return companyService.findById(id);
    }

    @GetMapping("/{id}/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployeesByCompanyId(@PathVariable int id) throws NotFoundException {
        return companyService.findEmployeesById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company insertCompany(@RequestBody Company company) {
        return companyService.add(company);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Company updateCompanyById(@PathVariable int id, @RequestBody Company company) throws NotFoundException {
        return companyService.update(id, company);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteAllEmployeesByCompanyId(@PathVariable int id) throws NotFoundException {
        if (companyService.deleteById(id)) return "Delete employees Success";
        else {
            return "Delete fail";
        }
    }
}
