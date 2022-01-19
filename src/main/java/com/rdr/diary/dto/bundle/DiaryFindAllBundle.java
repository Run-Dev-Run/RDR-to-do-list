package com.rdr.diary.dto.bundle;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DiaryFindAllBundle {
    @RequiredArgsConstructor
    @Getter
    public static class Response {
        private final List<DiaryFindBundle.Response> diaryFindBundleResponses;

        public static Response of(List<DiaryFindBundle.Response> diaryFindBundleResponses) {
            return new Response(diaryFindBundleResponses);
        }
    }
}
