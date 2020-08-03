package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.exceptioin.NotFoundException;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    public static final String DELETE_SUCCESS = "Delete Success";
    public static final String DELETE_FAIL = "Delete fail";
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees(Integer page, Integer pageSize, String gender) {
        if (page != null && pageSize != null) {
            return employeeService.findAll(page, pageSize);
        }
        if (gender != null) {
            return employeeService.findAllByGender(gender);
        }
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeByID(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee insertEmployees(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) throws NotFoundException {
        System.out.println(employee);
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteAllEmployeesById(@PathVariable int id) {
        if(employeeService.deleteEmployeeById(id)) {
            return DELETE_SUCCESS;
        } else {
            return DELETE_FAIL;
        }
    }
}
