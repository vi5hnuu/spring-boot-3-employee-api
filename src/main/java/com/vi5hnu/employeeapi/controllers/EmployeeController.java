package com.vi5hnu.employeeapi.controllers;

import com.vi5hnu.employeeapi.model.Employee;
import com.vi5hnu.employeeapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        final Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(this.employeeService.getAllEmployees(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(this.employeeService.getEmployeeById(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeInfo(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
        return new ResponseEntity<>(this.employeeService.updateEmployeeInfo(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(id + " : Employee deletion success", HttpStatus.OK);
    }

}
