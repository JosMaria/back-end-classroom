package org.michisoft.backendclassroom.controller;

import lombok.RequiredArgsConstructor;
import org.michisoft.backendclassroom.dto.TeacherDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;
import java.util.function.Function;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/login")
public class LoginController {

    public final WebClient.Builder webClient;

    private static final String DOMAIN = "http://localhost:8080/";
    private static final String RESOURCE = "api/v1/teachers";

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeacher(@RequestParam int page, @RequestParam int size) {
        Function<UriBuilder, URI> requestParams = uriBuilder -> uriBuilder
                .queryParam("page", page)
                .queryParam("size", size)
                .build();

        List<TeacherDTO> teachers = webClient.build()
                .get()
                .uri(DOMAIN + RESOURCE, requestParams)
                .retrieve()
                .bodyToFlux(TeacherDTO.class)
                .collectList()
                .block();

        return ResponseEntity.ok().body(teachers);
    }
}
