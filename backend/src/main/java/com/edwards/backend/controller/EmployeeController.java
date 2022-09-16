package com.edwards.backend.controller;

import com.edwards.backend.model.Employee;
import com.edwards.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //getAllEmployees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }

    //postNewEmployee
    @PostMapping("/register")
    public Employee saveNewEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    //getEmployeeById
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        return employeeService.findById(id);
    }

    //UpdateEmployee
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long id){
       return  employeeService.update(employee, id);

    }

    //deleteEmployee
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable long id){
        return employeeService.delete(id);

    }
}
