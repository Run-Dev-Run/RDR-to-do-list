package com.rdr.todolist.common.dto;

import lombok.Getter;

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

    public static <T> BaseResponse<T> of(ResponseMessage msg, T result) {
        return new BaseResponse<>(msg, result);
    }
}
