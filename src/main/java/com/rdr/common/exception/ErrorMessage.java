package com.rdr.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorMessage {
    DIARY_DOES_NOT_EXIST("E-D-001", HttpStatus.NOT_FOUND),
    ;

    private final String code;
    private final HttpStatus status;
}
