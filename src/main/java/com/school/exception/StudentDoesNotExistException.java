package com.school.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class StudentDoesNotExistException extends RuntimeException {
    private final HttpStatus httpStatus;

    public StudentDoesNotExistException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
