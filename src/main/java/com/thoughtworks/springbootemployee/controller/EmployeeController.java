package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.dto.EmployeeRequestDto;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

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
    public Employee insertEmployees(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.create(employeeRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployeeById(@PathVariable int id, @RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.update(id, employeeRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllEmployeesById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
    }
}
