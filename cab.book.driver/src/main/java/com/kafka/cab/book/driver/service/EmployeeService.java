package com.kafka.cab.book.driver.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.cab.book.driver.Constant.AppConstant;
import com.kafka.cab.book.driver.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        // Initialize with some employee details
        employees.add(new Employee(1, "John Doe", "123 Main St", "555-1234", "john.doe@example.com"));
        employees.add(new Employee(2, "Jane Smith", "456 Elm St", "555-5678", "jane.smith@example.com"));
        employees.add(new Employee(3, "Alice Johnson", "789 Oak St", "555-9012", "alice.johnson@example.com"));
    }

    public List<Employee> getAllEmployees() {
//        String employeeJson = null;
//        try {
//            employeeJson = objectMapper.writeValueAsString(employees);
//            kafkaTemplate.send(AppConstant.CAB_LOCATION, employeeJson);
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        return employees;
    }

    //    The error you're encountering indicates that Kafka is attempting to serialize
    //    an Employee object using StringSerializer, which is incompatible because
    //    StringSerializer expects a String, not a complex object like Employee.
    public Employee addEmployee(Employee employee) {
//        kafkaTemplate.
//                send(AppConstant.CAB_LOCATION+"XX", employee);
        employees.add(employee);
//
//        try {
//            String employeeJson = objectMapper.writeValueAsString(employee);
//            kafkaTemplate.send(AppConstant.CAB_LOCATION, employeeJson);
//            kafkaTemplate.
//                    send(AppConstant.CAB_LOCATION, employeeJson);
//
//        }
//        catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return employee;
        System.out.println(employee);
        return employee;
    }

//  ------------------------

    public Optional<Employee> getEmployeeById(Integer id) {
        return employees.stream()
                .filter(employee -> employee.getID().equals(id))
                .findFirst();
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

