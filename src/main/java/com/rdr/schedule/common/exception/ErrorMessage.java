package com.rdr.schedule.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
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
