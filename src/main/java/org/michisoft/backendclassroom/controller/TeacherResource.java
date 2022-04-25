package org.michisoft.backendclassroom.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/teachers")
public class TeacherResource {

    @GetMapping("first")
    public ResponseEntity<?> firstFunctionality() {
        log.info("First Functionality");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("second")
    public ResponseEntity<?> secondFunctionality() {
        log.info("Second Functionality");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("third")
    public ResponseEntity<?> thirdFunctionality() {
        log.info("Third Functionality");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("fourth")
    public ResponseEntity<?> fourthFunctionality() {
        log.info("Fourth Functionality");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("fifth")
    public ResponseEntity<?> fifthFunctionality() {
        log.info("Fifth Functionality");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
