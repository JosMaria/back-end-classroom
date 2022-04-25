package org.michisoft.backendclassroom.service.impl;

import lombok.RequiredArgsConstructor;
import org.michisoft.backendclassroom.dto.TeacherDTO;
import org.michisoft.backendclassroom.service.HomeService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService, UserDetailsService {

    private static final String DOMAIN = "http://localhost:8080/";
    private static final String GET_ALL_TEACHERS = "api/v1/teachers";
    private static final String GET_TEACHER_BY_EMAIL = "api/v1/teachers/email";

    private final WebClient.Builder webClient;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Function<UriBuilder, URI> requestParams = uriBuilder -> uriBuilder
                .queryParam("email", email)
                .build();

        TeacherDTO teacher = webClient.build()
                .get()
                .uri(DOMAIN + GET_TEACHER_BY_EMAIL, requestParams)
                .retrieve()
                .bodyToMono(TeacherDTO.class)
                .block();

        if (teacher == null) {
            throw new UsernameNotFoundException("Teacher with email " + email + " does not exists.");
        } else {
            return new User(teacher.getEmail(), passwordEncoder.encode(teacher.getPassword()), new ArrayList<>());
        }
    }

    @Override
    public List<TeacherDTO> getAllTeacher(int page, int size) {
        Function<UriBuilder, URI> requestParams = uriBuilder -> uriBuilder
                .queryParam("page", page)
                .queryParam("size", size)
                .build();

        return webClient.build()
                .get()
                .uri(DOMAIN + GET_ALL_TEACHERS, requestParams)
                .retrieve()
                .bodyToFlux(TeacherDTO.class)
                .collectList()
                .block();
    }
}
