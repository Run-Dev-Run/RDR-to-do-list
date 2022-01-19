package com.rdr.diary.dto;

import com.rdr.diary.domain.vo.Status;
import com.rdr.diary.utils.DiaryValidUtils;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DiaryCreateDto {
    @Getter
    public static class Request {
        @Pattern(regexp = DiaryValidUtils.Regexp.NAME, message = DiaryValidUtils.Message.NAME)
        private String author;

        private String title;

        private String content;
    }

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
