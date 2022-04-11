package org.michisoft.backendclassroom.controller;

import lombok.RequiredArgsConstructor;
import org.michisoft.backendclassroom.dto.SubjectDTO;
import org.michisoft.backendclassroom.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectDTO> save(@RequestBody @Valid SubjectDTO subjectDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(subjectService.save(subjectDTO));
    }
}
