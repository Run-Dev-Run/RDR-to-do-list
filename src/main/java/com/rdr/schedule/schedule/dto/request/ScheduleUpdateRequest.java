package com.rdr.schedule.schedule.dto.request;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequest {
    private Long updateId;
    private String title;
    private String content;

    private ScheduleUpdateRequest() {
    }
}
