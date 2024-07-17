package com.example.em_project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.em_project.model.Employee;
import com.example.em_project.service.EmployeeService;




@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from the frontend@CrossOrigin(origins = "http://localhost:3000") 
public class EmpController {
    

    //EmployeeService employeeService = new EmployeeServiceImpl();
    @Autowired
    EmployeeService employeeService;
    

    @GetMapping("employees")
    public List <Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        System.out.println("Yes m aa rha hu ");
        return employeeService.readEmployee(id);
    }
  

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        //employees.add(employee);
       
        return employeeService.createEmployee(employee);
    }
    
    @DeleteMapping("employees/{id}")
        public String deleteEmployee(@PathVariable Long id){
           if( employeeService.deleteEmployee(id)){
            return "Deleted Successfully";
           }
           return "Not found";
        }

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
        //TODO: process PUT request
        
        return employeeService.updateEmployee(id, employee);
    }
    
    
    }

