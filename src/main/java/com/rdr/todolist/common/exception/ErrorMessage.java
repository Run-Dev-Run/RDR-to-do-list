package com.rdr.todolist.common.exception;

import org.springframework.http.HttpStatus;

public enum ErrorMessage {
    SCHEDULE_DOES_NOT_EXIST("E-S-001", HttpStatus.NOT_FOUND),
    ;

    private final String code;
    private final HttpStatus status;

    ErrorMessage(String code, HttpStatus status) {
        this.code = code;
        this.status = status;
    }
}
