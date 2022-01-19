package com.rdr.diary.dto.bundle;

import com.rdr.diary.domain.vo.Status;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DiaryDeleteBundle {
    @RequiredArgsConstructor
    @Getter
    public static class Request {
        private final Long id;

        public static Request of(Long id) {
            return new Request(id);
        }
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
