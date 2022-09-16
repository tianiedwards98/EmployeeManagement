package com.edwards.backend.service;

import com.edwards.backend.exceptions.ResourceNotFoundException;
import com.edwards.backend.model.Employee;
import com.edwards.backend.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findById(long id) {
        if (employeeRepo.existsById(id)) {
            return employeeRepo.findById(id);
        }else{
            throw new  ResourceNotFoundException("Employee not exist with id: " + id);
        }
    }

    public ResponseEntity<Map<String,Boolean>> delete(long id) {
        if(employeeRepo.existsById(id)){
            Employee employee = employeeRepo.findById(id);
            employeeRepo.delete(employee);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }else{
            throw new ResourceNotFoundException("Employee does not exist with id: " + id);
        }
    }

    public ResponseEntity<Employee> update(Employee employee, long id) {
        if(employeeRepo.existsById(id)){
            Employee em = employeeRepo.findById(id);
            em.setFirstname(employee.getFirstname());
            em.setLastname(employee.getLastname());
            em.setEmailId(employee.getEmailId());

            Employee updatedEmployee = employeeRepo.save(em);
            return ResponseEntity.ok(updatedEmployee);
        }else{
            throw new ResourceNotFoundException("Employee does not exist with id: " + id);
        }


    }
}
