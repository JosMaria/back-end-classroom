package org.michisoft.backendclassroom.problem.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(HttpStatus httpStatus, Class<?> exceptionClass,
                            String message, LocalDateTime timestamp) implements Error {

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
