package com.onegateafrica.employeemanager;

import com.onegateafrica.employeemanager.model.employee;
import com.onegateafrica.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<employee>> getAllEmployee(){
        List<employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<employee> getEmployeeById(@PathVariable("id") int id){
        employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<employee> addEmployee(@RequestBody employee employee){
        employee NewEmployee = employeeService.AddEmployee(employee);
        return new ResponseEntity<>(NewEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<employee> updateEmployee(@RequestBody employee employee){
        employee NewEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(NewEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
