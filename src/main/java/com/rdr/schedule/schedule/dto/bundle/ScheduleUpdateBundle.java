package com.rdr.schedule.schedule.dto.bundle;

import com.rdr.schedule.schedule.domain.vo.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

public class ScheduleUpdateBundle {
    private ScheduleUpdateBundle() {
    }

    @RequiredArgsConstructor
    @Builder
    @Getter
    public static class Request {
        private final Long id;
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
