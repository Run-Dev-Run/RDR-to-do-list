package com.rdr.todolist.schedule.dto.bundle;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class ScheduleCreateBundle {
    private final String author;
    private final String title;
    private final String content;
}
