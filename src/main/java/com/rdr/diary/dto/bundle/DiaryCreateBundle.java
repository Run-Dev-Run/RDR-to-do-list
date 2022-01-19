package com.rdr.diary.dto.bundle;

import com.rdr.diary.domain.vo.Status;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DiaryCreateBundle {
    @Builder
    @Getter
    public static class Request {
        private final String author;
        private final String title;
        private final String content;
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
