package org.michisoft.backendclassroom.problem.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorValidationResponse(HttpStatus httpStatus, Class<?> exceptionClass,
                                      List<String> messages, LocalDateTime timestamp) implements Error {

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public Class<?> getExceptionClass() {
        return exceptionClass;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
