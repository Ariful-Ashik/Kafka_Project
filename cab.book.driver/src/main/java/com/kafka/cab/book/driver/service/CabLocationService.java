//package com.kafka.cab.book.driver.service;
//
//import com.kafka.cab.book.driver.Constant.AppConstant;
//import com.kafka.cab.book.driver.model.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CabLocationService {
//
//    @Autowired
//    private KafkaTemplate<String, Object> kafkaTemplate;
//
//    public boolean updatelocation(Employee location) {
//        kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
//        return true;
//    }
//}
