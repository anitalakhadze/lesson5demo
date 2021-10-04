package com.example.lesson5demo.service;

import com.example.lesson5demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> all();
    Employee one(Long id);
    Employee newEmployee(Employee newEmployee);
    Employee replace(Employee employee, Long id);
    void delete(Long id);
}
