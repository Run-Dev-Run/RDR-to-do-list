package com.rdr.todolist.schedule.dto.request;

import lombok.Getter;

@Getter
public class ScheduleCreateRequest {
    private String author;
    private String title;
    private String content;

    private ScheduleCreateRequest() {
    }
}
