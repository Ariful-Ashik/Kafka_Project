package com.kafka.cab.book.driver.controller;


import com.kafka.cab.book.driver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/location")

public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    @PutMapping
    public ResponseEntity updateLocation() throws InterruptedException {
        int range = 100;
        while (range > 0) {
            cabLocationService.updatelocation(Math.random() * 100 + " ," + Math.random() * 100);
            Thread.sleep(1000);
            range--;

        }
        return new ResponseEntity<>(Collections.singletonMap("message", "Location Updated"), HttpStatus.OK);

    }
}
