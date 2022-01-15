package com.rdr.diary.bundle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class DiaryFindAllBundle {
    private DiaryFindAllBundle() {
    }

    @RequiredArgsConstructor
    @Getter
    public static class Response {
        private final List<DiaryFindBundle.Response> diaryFindBundleResponses;

        public static Response of(List<DiaryFindBundle.Response> diaryFindBundleResponses) {
            return new Response(diaryFindBundleResponses);
        }
    }
}
