package com.kafka.cab.book.driver.service;


import com.kafka.cab.book.driver.model.Employee;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        // Initialize with some employee details
        employees.add(new Employee(1, "John Doe", "123 Main St", "555-1234", "john.doe@example.com"));
        employees.add(new Employee(2, "Jane Smith", "456 Elm St", "555-5678", "jane.smith@example.com"));
        employees.add(new Employee(3, "Alice Johnson", "789 Oak St", "555-9012", "alice.johnson@example.com"));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Optional<Employee> getEmployeeById(Integer id) {
        return employees.stream()
                .filter(employee -> employee.getID().equals(id))
                .findFirst();
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Optional<Employee> updateEmployee(Integer id, Employee employeeDetails) {
        return getEmployeeById(id).map(employee -> {
            employee.setName(employeeDetails.getName());
            employee.setAddress(employeeDetails.getAddress());
            employee.setPhone(employeeDetails.getPhone());
            employee.setEmail(employeeDetails.getEmail());
            return employee;
        });
    }

    public boolean deleteEmployee(Integer id) {
        return employees.removeIf(employee -> employee.getID().equals(id));
    }
}

