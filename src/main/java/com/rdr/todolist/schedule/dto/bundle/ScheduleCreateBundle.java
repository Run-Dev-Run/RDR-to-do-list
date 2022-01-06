package com.rdr.todolist.schedule.dto.bundle;

import com.rdr.todolist.schedule.dto.request.ScheduleCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ScheduleCreateBundle {
    private String author;
    private String title;
    private String content;

    private ScheduleCreateBundle() {
    }

    public static ScheduleCreateBundle convertFrom(ScheduleCreateRequest request) {
        return ScheduleCreateBundle.builder()
                .author(request.getAuthor())
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }
}
