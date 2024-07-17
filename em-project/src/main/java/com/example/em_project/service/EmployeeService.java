package com.example.em_project.service;
import java.util.List;
import com.example.em_project.model.Employee;
import org.springframework.stereotype.Service;


@Service
public interface EmployeeService {
    String createEmployee (Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
    Employee readEmployee(Long id);
}
