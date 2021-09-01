package com.onegateafrica.employeemanager.service;

import com.onegateafrica.employeemanager.model.employee;
import com.onegateafrica.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public employee AddEmployee(employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public employee updateEmployee(employee employee){
        return employeeRepo.save(employee);
    }

    public employee findEmployeeById(int id){
        return employeeRepo.findEmployeeById(id);
    }

    public void deleteEmployee(int id){
        employeeRepo.deleteEmployeeById(id);
    }


}
