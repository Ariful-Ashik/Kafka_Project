package com.kafka.cab.book.user.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.cab.book.driver.model.Employee;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service

public class LocationService {

    @KafkaListener(topics = "cab-location", groupId = "user-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);

        // Process the message as an employee
        Employee employee = parseEmployeeDetails(message);
        System.out.println("Processed Employee: " + employee);
    }

    private Employee parseEmployeeDetails(String message) {
        // Assume message is a JSON string of an Employee object
        // Parse it using your preferred method (e.g., Jackson ObjectMapper)
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(message, Employee.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @KafkaListener(topics = "cab-location", groupId = "user-group")
//    public void cabLocation(Employee employee) {
//        System.out.println(employee);
//    }
//    // Process the message as an employee
//    Employee employee = parseEmployeeDetails(message);
//        System.out.println("Processed Employee: " + employee);
}
