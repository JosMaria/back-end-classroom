package org.michisoft.backendclassroom.problem.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public interface Error {

    HttpStatus getHttpStatus();

    Class<?> getExceptionClass();

    LocalDateTime getTimestamp();
}
