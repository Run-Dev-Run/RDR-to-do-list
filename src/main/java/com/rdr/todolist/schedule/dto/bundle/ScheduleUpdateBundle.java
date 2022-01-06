package com.rdr.todolist.schedule.dto.bundle;

import com.rdr.todolist.schedule.dto.request.ScheduleUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ScheduleUpdateBundle {
    private Long id;
    private String title;
    private String content;

    private ScheduleUpdateBundle() {
    }

    public static ScheduleUpdateBundle convertFrom(Long id, ScheduleUpdateRequest request) {
        return ScheduleUpdateBundle.builder()
                .id(id)
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }
}
