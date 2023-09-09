package com.vi5hnu.employeeapi.repository;

import com.vi5hnu.employeeapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
