package com.example.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = TodoNotFoundException.class)
    public ResponseEntity<ApiError> handleTodoNotFoundException(){
        ApiError error = new ApiError(404, "No such Todo", new Date());

        return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
    }
}
