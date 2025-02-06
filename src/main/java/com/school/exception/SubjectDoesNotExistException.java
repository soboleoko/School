package com.school.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SubjectDoesNotExistException extends RuntimeException {
    private final HttpStatus httpStatus;

    public SubjectDoesNotExistException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
