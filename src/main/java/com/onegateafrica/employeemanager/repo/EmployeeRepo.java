package com.onegateafrica.employeemanager.repo;

import com.onegateafrica.employeemanager.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<employee, Integer> {

}
