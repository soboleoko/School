package com.school.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SchoolClassDoesNotExistException extends RuntimeException {
    private final HttpStatus httpStatus;

    public SchoolClassDoesNotExistException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
