package com.rdr.common.dto;

import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
public class BaseResponse<T> {
    private final LocalDateTime localDateTime;
    private final ResponseMessage message;
    private final T result;

    public BaseResponse(ResponseMessage message, T result) {
        this.localDateTime = LocalDateTime.now();
        this.message = message;
        this.result = result;
    }

    public static <T> ResponseEntity<BaseResponse<T>> of(ResponseMessage message, T result) {
        return ResponseEntity
                .status(message.getStatus())
                .body(new BaseResponse<>(message, result));
    }
}
