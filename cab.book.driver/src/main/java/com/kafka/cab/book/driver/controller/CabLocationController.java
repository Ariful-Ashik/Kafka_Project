package com.kafka.cab.book.driver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.cab.book.driver.model.Employee;
import com.kafka.cab.book.driver.service.CabLocationService;
import com.kafka.cab.book.driver.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")

public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeDetails) {
        Optional<Employee> updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        return updatedEmployee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        boolean deleted = employeeService.deleteEmployee(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }



//    @PostMapping("/{text}")
//    public ResponseEntity updateLocation(@PathVariable String text ) throws InterruptedException {
////        int range = 100;
////        while (range > 0) {
////            cabLocationService.updatelocation(Math.random() * 100 + " ," + Math.random() * 100);
////            Thread.sleep(1000);
////            range--;
////
////        }
//        cabLocationService.updatelocation(text);
//        return new ResponseEntity<>(Collections.singletonMap("message", "Location Updated"), HttpStatus.OK);

//    }


}
