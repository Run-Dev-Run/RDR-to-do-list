package com.rdr.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorMessage {
    DIARY_DOES_NOT_EXIST("E-D-001", HttpStatus.NOT_FOUND),
    ;

    private final String code;
    private final HttpStatus status;

    ErrorMessage(String code, HttpStatus status) {
        this.code = code;
        this.status = status;
    }
}
