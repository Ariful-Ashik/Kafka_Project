package com.kafka.cab.book.driver.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.cab.book.driver.Constant.AppConstant;
import com.kafka.cab.book.driver.model.Employee;
import com.kafka.cab.book.driver.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

//    @Autowired
//    private ObjectMapper objectMapper;

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
@Autowired
private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> updateEmployee(Long id, Employee employeeDetails) {
        return getEmployeeById(id).map(employee -> {
            employee.setName(employeeDetails.getName());
            employee.setAddress(employeeDetails.getAddress());
            employee.setPhone(employeeDetails.getPhone());
            employee.setEmail(employeeDetails.getEmail());
            return employeeRepository.save(employee);  // Save the updated employee
        });
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }


//    public List<Employee> getAllEmployees() {
////        String employeeJson = null;
////        try {
////            employeeJson = objectMapper.writeValueAsString(employees);
////            kafkaTemplate.send(AppConstant.CAB_LOCATION, employeeJson);
////
////        } catch (JsonProcessingException e) {
////            e.printStackTrace();
////        }
//        return employees;
//    }

    //    The error you're encountering indicates that Kafka is attempting to serialize
    //    an Employee object using StringSerializer, which is incompatible because
    //    StringSerializer expects a String, not a complex object like Employee.
    public Employee addEmployee(Employee employee) {
//        kafkaTemplate.
//                send(AppConstant.CAB_LOCATION+"XX", employee);
        employeeRepository.save(employee);
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

//    public Optional<Employee> getEmployeeById(Integer id) {
//        return employees.stream()
//                .filter(employee -> employee.getID().equals(id))
//                .findFirst();
//    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }



}

