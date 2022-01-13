package com.rdr.schedule.schedule.dto.response;

import com.rdr.schedule.schedule.domain.vo.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
@Getter
public class ScheduleChangeStatusResponse {
    private final String author;
    private final Status status;
    private final String title;
    private final String content;
    private final LocalDateTime createDate;
    private final LocalDateTime modifiedDate;
}
