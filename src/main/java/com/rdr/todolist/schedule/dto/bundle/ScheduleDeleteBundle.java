package com.rdr.todolist.schedule.dto.bundle;

import com.rdr.todolist.schedule.domain.vo.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

public class ScheduleDeleteBundle {
    private ScheduleDeleteBundle() {
    }

    @RequiredArgsConstructor
    @Getter
    public static class Request {
        private final Long id;

        public static Request of(Long id) {
            return new Request(id);
        }
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
