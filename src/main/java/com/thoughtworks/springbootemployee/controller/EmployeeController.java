package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.respority.EmployeeRepository;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    List<Employee> employees = new LinkedList<>();

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController() {
    }

    @GetMapping
    public List<Employee> getEmployees(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize,
            @RequestParam(required = false, defaultValue = "") String gender) {
        List<Employee> employeesList = new LinkedList<>();

        if (page == 0 && gender.equals("")) {
            employeesList = employeeService.getAllEmployees();
        } else if (!gender.equals("")) {
            employeesList = employeeService.getEmployeeByGender(gender);
        } else if (page > 0) {
            employeesList = (List<Employee>) employeeService.getEmployeeByPage(page, pageSize);
        }

        return employeesList;
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updataEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.removeEmployee(id);
        if(employeeService.getEmployeeById(id) == null) {
            return "Delete Employee id = " + id + " Success";
        }
        return "Delete Unsuccess";
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }
}
