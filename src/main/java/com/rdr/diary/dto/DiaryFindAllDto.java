package com.rdr.diary.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DiaryFindAllDto {
    @Builder
    @Getter
    public static class Response {
        private final Long totalCount;
        private final List<DiaryFindDto.Response> diaries;
    }
}
