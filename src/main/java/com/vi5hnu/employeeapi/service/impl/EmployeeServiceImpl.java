package com.vi5hnu.employeeapi.service.impl;

import com.vi5hnu.employeeapi.exception.ResourceNotFoundException;
import com.vi5hnu.employeeapi.model.Employee;
import com.vi5hnu.employeeapi.repository.EmployeeRepository;
import com.vi5hnu.employeeapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployeeInfo(Employee newEmployee, Long id) {
        final Employee exEmployee = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        exEmployee.setFirstName(newEmployee.getFirstName());
        exEmployee.setLastName(newEmployee.getLastName());
        exEmployee.setEmail(newEmployee.getEmail());
        return this.employeeRepository.save(exEmployee);
    }

    @Override
    public Employee deleteEmployee(Long id) {
        final Employee exEmployee = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        this.employeeRepository.deleteById(id);
        return exEmployee;
    }
}
