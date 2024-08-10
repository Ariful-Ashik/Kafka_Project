package com.kafka.cab.book.user.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.cab.book.driver.model.Employee;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.asm.TypeReference;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LocationService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "cab-location", groupId = "user-group")
    public void consume(String message) {

        System.out.println("Received message: " + message);

        // Process the message as a list of employees
        List<Employee> employees = parseEmployeeDetails(message);
        for (Employee employee : employees) {
            System.out.println("Processed Employee: " + employee);
        }
    }

    private List<Employee> parseEmployeeDetails(String message) {
        try {
            // Deserialize the JSON array to a list of Employee objects
            return List.of(objectMapper.readValue(message, Employee[].class));

//             return objectMapper.readValue(message, new TypeReference<List<Employee>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}



//-----------------------

//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @KafkaListener(topics = "cab-location", groupId = "user-group")
//    public void consume(String message) {
//        System.out.println("Received message: " + message);
//
//        // Process the message as an employee
//        Employee employee = parseEmployeeDetails(message);
//        System.out.println("Processed Employee: " + employee);
//    }
//
//     Employee parseEmployeeDetails(String message) {
//        // Assume message is a JSON string of an Employee object
//        // Parse it using your preferred method (e.g., Jackson ObjectMapper)
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            return objectMapper.readValue(message, Employee.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }


//    @KafkaListener(topics = "cab-location", groupId = "user-group")
//    public void cabLocation(Employee employee) {
//        System.out.println(employee);
//    }
//    // Process the message as an employee
//    Employee employee = parseEmployeeDetails(message);
//        System.out.println("Processed Employee: " + employee);
//}
