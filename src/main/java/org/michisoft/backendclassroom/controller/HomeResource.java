package org.michisoft.backendclassroom.controller;

import lombok.RequiredArgsConstructor;
import org.michisoft.backendclassroom.dto.TeacherDTO;
import org.michisoft.backendclassroom.service.HomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/login")
public class HomeResource {

    private final HomeService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeacher(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok().body(teacherService.getAllTeacher(page, size));
    }
}
