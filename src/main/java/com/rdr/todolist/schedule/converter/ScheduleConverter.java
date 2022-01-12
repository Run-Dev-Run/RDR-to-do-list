package com.rdr.todolist.schedule.converter;

import com.rdr.todolist.schedule.domain.Schedule;
import com.rdr.todolist.schedule.dto.bundle.ScheduleCreateBundle;
import com.rdr.todolist.schedule.dto.bundle.ScheduleUpdateBundle;
import com.rdr.todolist.schedule.dto.request.ScheduleCreateRequest;
import com.rdr.todolist.schedule.dto.request.ScheduleUpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConverter {
    public Schedule toSchedule(ScheduleCreateBundle bundle) {
        return Schedule.builder()
                .author(bundle.getAuthor())
                .title(bundle.getTitle())
                .content(bundle.getContent())
                .build();
    }

    public ScheduleCreateBundle toScheduleCreateBundle(ScheduleCreateRequest request) {
        return ScheduleCreateBundle.builder()
                .author(request.getAuthor())
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public ScheduleUpdateBundle toScheduleUpdateBundle(Long id, ScheduleUpdateRequest request) {
        return ScheduleUpdateBundle.builder()
                .id(id)
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }
}
