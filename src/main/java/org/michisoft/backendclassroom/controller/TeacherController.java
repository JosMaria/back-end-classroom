package org.michisoft.backendclassroom.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.michisoft.backendclassroom.dto.TeacherDTO;
import org.michisoft.backendclassroom.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/teachers")
public class TeacherController {

    private final TeacherService teacherService;

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

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeacher(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok().body(teacherService.getAllTeacher(page, size));
    }
}
