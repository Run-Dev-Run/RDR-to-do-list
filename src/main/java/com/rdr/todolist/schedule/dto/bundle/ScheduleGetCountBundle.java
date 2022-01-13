package com.rdr.todolist.schedule.dto.bundle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class ScheduleGetCountBundle {
    private ScheduleGetCountBundle() {
    }

    @RequiredArgsConstructor
    @Getter
    public static class Response {
        private final Long totalCount;

        public static Response of(Long totalCount) {
            return new Response(totalCount);
        }
    }
}
