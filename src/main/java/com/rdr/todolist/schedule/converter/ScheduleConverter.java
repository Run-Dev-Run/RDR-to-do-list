package com.rdr.todolist.schedule.converter;

import com.rdr.todolist.schedule.domain.Schedule;
import com.rdr.todolist.schedule.dto.bundle.ScheduleCreateBundle;
import com.rdr.todolist.schedule.dto.bundle.ScheduleUpdateBundle;
import com.rdr.todolist.schedule.dto.request.ScheduleCreateRequest;
import com.rdr.todolist.schedule.dto.request.ScheduleUpdateRequest;
import com.rdr.todolist.schedule.dto.response.ScheduleResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleConverter {
    private ScheduleConverter() {
    }

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

    public ScheduleResponse toScheduleResponse(Schedule schedule) {
        return ScheduleResponse.builder()
                .author(schedule.getAuthor())
                .status(schedule.getStatus())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .createDate(schedule.getCreatedDate())
                .modifiedDate(schedule.getModifiedDate())
                .build();
    }

    public List<ScheduleResponse> toScheduleResponses(List<Schedule> schedules) {
        return schedules.stream()
                .map(this::toScheduleResponse)
                .collect(Collectors.toList());
    }
}
