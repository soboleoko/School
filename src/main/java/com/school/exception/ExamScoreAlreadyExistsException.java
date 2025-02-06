package com.school.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExamScoreAlreadyExistsException extends RuntimeException {
    private final HttpStatus httpStatus;

    public ExamScoreAlreadyExistsException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
