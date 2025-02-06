package com.school.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExamScoreDoesNotExistException extends RuntimeException {
    private final HttpStatus httpStatus;

    public ExamScoreDoesNotExistException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}