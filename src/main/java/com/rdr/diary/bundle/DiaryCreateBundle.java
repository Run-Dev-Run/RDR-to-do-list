package com.rdr.diary.bundle;

import com.rdr.diary.domain.vo.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

public class DiaryCreateBundle {
    private DiaryCreateBundle() {
    }

    @RequiredArgsConstructor
    @Builder
    @Getter
    public static class Request {
        private final String author;
        private final String title;
        private final String content;
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
