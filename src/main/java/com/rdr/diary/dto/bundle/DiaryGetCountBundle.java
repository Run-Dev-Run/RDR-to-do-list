package com.rdr.diary.dto.bundle;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DiaryGetCountBundle {
    @RequiredArgsConstructor
    @Getter
    public static class Response {
        private final Long totalCount;

        public static Response of(Long totalCount) {
            return new Response(totalCount);
        }
    }
}
