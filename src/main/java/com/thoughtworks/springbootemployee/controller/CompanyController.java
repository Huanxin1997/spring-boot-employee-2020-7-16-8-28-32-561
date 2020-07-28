package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @GetMapping
    public List<Company> getAll() {
        List<Company> companies = new LinkedList<>();
        companies.add(new Company("OOCL", 1));
        companies.add(new Company("CargoSmart", 2));
        companies.add(new Company("OOIL", 3));
        companies.add(new Company("COSCO", 4));
        return companies;
    }
}

