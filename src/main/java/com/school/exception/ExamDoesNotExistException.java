package com.school.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExamDoesNotExistException extends RuntimeException {
    private final HttpStatus httpStatus;

    public ExamDoesNotExistException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
