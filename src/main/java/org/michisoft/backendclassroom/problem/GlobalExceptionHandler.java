package org.michisoft.backendclassroom.problem;

import org.michisoft.backendclassroom.problem.error.Error;
import org.michisoft.backendclassroom.problem.error.ErrorResponse;
import org.michisoft.backendclassroom.problem.error.ErrorValidationResponse;
import org.michisoft.backendclassroom.problem.exception.SubjectAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleInvalidArgument(MethodArgumentNotValidException exception) {
        List<String> messages = new ArrayList<>();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(error -> messages.add(error.getDefaultMessage()));

        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(statusCode)
                .body(new ErrorValidationResponse(statusCode, exception.getClass(), messages, LocalDateTime.now()));
    }

    @ExceptionHandler(SubjectAlreadyExistsException.class)
    public ResponseEntity<Error> handleSubjectAlreadyExistsException(SubjectAlreadyExistsException ex) {
        HttpStatus statusCode = HttpStatus.CONFLICT;
        return ResponseEntity.status(statusCode)
                .body(new ErrorResponse(statusCode, ex.getClass(), ex.getMessage(), LocalDateTime.now()));
    }
}
