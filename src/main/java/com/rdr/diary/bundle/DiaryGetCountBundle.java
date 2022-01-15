package com.rdr.diary.bundle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class DiaryGetCountBundle {
    private DiaryGetCountBundle() {
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
