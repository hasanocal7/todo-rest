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

    @ExceptionHandler({TodoNotFoundException.class})
    public ResponseEntity<ApiError> handleTodoNotFoundException(
            Exception ex
    ){
        ApiError error = new ApiError(404, ex.getMessage(), new Date());

        return new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
    }
}
