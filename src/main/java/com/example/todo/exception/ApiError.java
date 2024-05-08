package com.example.todo.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ApiError {
    private Integer errorCode;
    private String errorDesc;
    private Date date;

    public ApiError(Integer errorCode, String errorDesc, Date date) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.date = date;
    }
}
