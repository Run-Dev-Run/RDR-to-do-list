package com.rdr.todolist.schedule.dto.bundle;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class ScheduleUpdateBundle {
    private final Long id;
    private final String title;
    private final String content;
}
