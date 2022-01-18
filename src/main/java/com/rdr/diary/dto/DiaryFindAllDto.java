package com.rdr.diary.dto;

import com.rdr.diary.dto.bundle.DiaryFindBundle;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class DiaryFindAllDto {
    private DiaryFindAllDto() {
    }

    @RequiredArgsConstructor
    @Builder
    @Getter
    public static class Response {
        private final Long totalCount;
        private final List<DiaryFindBundle.Response> diaries;
    }
}
