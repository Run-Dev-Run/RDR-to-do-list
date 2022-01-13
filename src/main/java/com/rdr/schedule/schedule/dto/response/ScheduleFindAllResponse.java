package com.rdr.schedule.schedule.dto.response;

import com.rdr.schedule.schedule.dto.bundle.ScheduleFindBundle;
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
