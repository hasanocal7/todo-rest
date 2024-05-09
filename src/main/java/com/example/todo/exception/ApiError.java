package com.example.todo.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ApiError {
    private Integer errorCode;
    private String errorMsg;
    private Date date;

    public ApiError(Integer errorCode, String errorMsg, Date date) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.date = date;
    }
}
