package com.rdr.todolist.schedule.dto.response;

import com.rdr.todolist.schedule.dto.bundle.ScheduleFindBundle;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Builder
@Getter
public class ScheduleFindAllResponse {
    private final Long totalCount;
    private final List<ScheduleFindBundle.Response> schedules;
}
