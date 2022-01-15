package com.rdr.diary.dto;

import com.rdr.diary.domain.vo.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

public class DiaryCreateDto {
    private DiaryCreateDto() {
    }

    @Getter
    public static class Request {
        private String author;
        private String title;
        private String content;
    }

    @RequiredArgsConstructor
    @Builder
    @Getter
    public static class Response {
        private final String author;
        private final Status status;
        private final String title;
        private final String content;
        private final LocalDateTime createDate;
        private final LocalDateTime modifiedDate;
    }
}
