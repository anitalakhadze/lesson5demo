package com.example.lesson5demo.service;

import com.example.lesson5demo.entity.Employee;
import com.example.lesson5demo.exception.EmployeeNotFoundException;
import com.example.lesson5demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> all() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee one(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public Employee newEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Employee replace(Employee employee, Long id) {
        return employeeRepository.findById(id)
                .map(oldEmployee -> {
                    oldEmployee.setName(employee.getName());
                    oldEmployee.setRole(employee.getRole());
                    return employeeRepository.save(oldEmployee);
                })
                .orElseGet(() -> {
                    employee.setId(id);
                    return employeeRepository.save(employee);
                });
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
