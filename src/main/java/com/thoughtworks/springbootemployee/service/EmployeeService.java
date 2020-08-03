package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.EmployeeRequestDto;
import com.thoughtworks.springbootemployee.exceptioin.NotFoundException;
import com.thoughtworks.springbootemployee.mapper.EmployeeMapper;
import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper = new EmployeeMapper();

    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    public List<Employee> findAll(int page, int pageSize) {
        return this.employeeRepository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    public Employee create(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public Employee findById(int employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public List<Employee> findAllByGender(String gender) {
        return this.employeeRepository.findAllByGender(gender);
    }

    public Employee update(int employeeId, Employee employee) throws NotFoundException {
        Employee employeeUpdated = this.employeeRepository.findById(employeeId).orElseThrow(NotFoundException::new);
        if (employeeUpdated == null) {
            return null;
        }
        employeeUpdated.setName(employee.getName());
        employeeUpdated.setAge(employee.getAge());
        employeeUpdated.setGender(employee.getGender());
        employeeUpdated.setSalery(employee.getSalery());
        employeeUpdated.setCompany_id(employee.getCompany_id());
        return this.employeeRepository.save(employeeUpdated);
    }

    public Boolean deleteEmployeeById(int i) {
        employeeRepository.deleteById(i);
        return !employeeRepository.findById(i).isPresent();
    }
}
