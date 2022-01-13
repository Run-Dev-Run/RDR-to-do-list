package com.rdr.todolist.schedule.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class SchedulesResponse {
    private final Long totalCount;
    private final List<ScheduleResponse> schedules;

    private SchedulesResponse(Long totalCount, List<ScheduleResponse> schedules) {
        this.totalCount = totalCount;
        this.schedules = schedules;
    }

    public static SchedulesResponse of(Long totalCount, List<ScheduleResponse> schedules) {
        return new SchedulesResponse(totalCount, schedules);
    }
}
