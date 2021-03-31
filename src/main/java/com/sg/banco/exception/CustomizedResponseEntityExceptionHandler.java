package com.sg.banco.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(
            Exception ex,
            WebRequest request) {

        ExceptionResponse response = ExceptionResponse.Builder.newBuilder()
                .timestamp(new Date())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Not found")
                .details(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex,
            Object body,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        ExceptionResponse response = ExceptionResponse.Builder.newBuilder()
                .timestamp(new Date())
                .status(status.value())
                .title("Internal error")
                .details(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build();
        return new ResponseEntity<>(response, headers, status);
    }

}
