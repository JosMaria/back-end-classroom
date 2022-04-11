package org.michisoft.backendclassroom.problem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = SubjectAlreadyExistsException.REASON)
public class SubjectAlreadyExistsException extends RuntimeException {

    public static final String REASON = "Subject already exists";

    public SubjectAlreadyExistsException(String message) {
        super(message);
    }
}
