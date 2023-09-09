package com.vi5hnu.employeeapi.service;

import com.vi5hnu.employeeapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Long id);

    public Employee updateEmployeeInfo(Employee employee, Long id);

    public Employee deleteEmployee(Long id);
}
