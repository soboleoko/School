package com.school.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TeacherDoesNotExistException extends RuntimeException {
    private final HttpStatus httpStatus;

    public TeacherDoesNotExistException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
