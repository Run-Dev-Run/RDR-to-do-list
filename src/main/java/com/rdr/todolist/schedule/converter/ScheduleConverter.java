package com.rdr.todolist.schedule.converter;

import com.rdr.todolist.schedule.domain.Schedule;
import com.rdr.todolist.schedule.dto.bundle.*;
import com.rdr.todolist.schedule.dto.request.ScheduleCreateRequest;
import com.rdr.todolist.schedule.dto.request.ScheduleUpdateRequest;
import com.rdr.todolist.schedule.dto.response.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleConverter {
    private ScheduleConverter() {
    }

    /**
     * toEntity
     */
    public Schedule toSchedule(ScheduleCreateBundle.Request bundleRequest) {
        return Schedule.builder()
                .author(bundleRequest.getAuthor())
                .title(bundleRequest.getTitle())
                .content(bundleRequest.getContent())
                .build();
    }

    /**
     * toBundleRequest
     */
    public ScheduleCreateBundle.Request toScheduleCreateBundleRequest(ScheduleCreateRequest request) {
        return ScheduleCreateBundle.Request
                .builder()
                .author(request.getAuthor())
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public ScheduleUpdateBundle.Request toScheduleUpdateBundleRequest(Long id, ScheduleUpdateRequest request) {
        return ScheduleUpdateBundle.Request
                .builder()
                .id(id)
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    /**
     * toBundleResponse
     */
    public ScheduleCreateBundle.Response toScheduleCreateBundleResponse(Schedule schedule) {
        return ScheduleCreateBundle.Response
                .builder()
                .author(schedule.getAuthor())
                .status(schedule.getStatus())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .createDate(schedule.getCreatedDate())
                .modifiedDate(schedule.getModifiedDate())
                .build();
    }

    public ScheduleFindAllBundle.Response toScheduleFindAllBundleResponse(List<Schedule> schedules) {
        List<ScheduleFindBundle.Response> scheduleFindBundleResponses = schedules.stream()
                .map(this::toScheduleFindBundleResponse)
                .collect(Collectors.toList());
        return ScheduleFindAllBundle.Response.of(scheduleFindBundleResponses);
    }

    public ScheduleFindBundle.Response toScheduleFindBundleResponse(Schedule schedule) {
        return ScheduleFindBundle.Response
                .builder()
                .author(schedule.getAuthor())
                .status(schedule.getStatus())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .createDate(schedule.getCreatedDate())
                .modifiedDate(schedule.getModifiedDate())
                .build();
    }

    public ScheduleUpdateBundle.Response toScheduleUpdateBundleResponse(Schedule schedule) {
        return ScheduleUpdateBundle.Response
                .builder()
                .author(schedule.getAuthor())
                .status(schedule.getStatus())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .createDate(schedule.getCreatedDate())
                .modifiedDate(schedule.getModifiedDate())
                .build();
    }

    public ScheduleDeleteBundle.Response toScheduleDeleteBundleResponse(Schedule schedule) {
        return ScheduleDeleteBundle.Response
                .builder()
                .author(schedule.getAuthor())
                .status(schedule.getStatus())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .createDate(schedule.getCreatedDate())
                .modifiedDate(schedule.getModifiedDate())
                .build();
    }

    public ScheduleChangeStatusBundle.Response toScheduleChangeStatusBundleResponse(Schedule schedule) {
        return ScheduleChangeStatusBundle.Response
                .builder()
                .author(schedule.getAuthor())
                .status(schedule.getStatus())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .createDate(schedule.getCreatedDate())
                .modifiedDate(schedule.getModifiedDate())
                .build();
    }

    /**
     * toResponse
     */
    public ScheduleCreateResponse toScheduleResponse(ScheduleCreateBundle.Response bundleResponse) {
        return ScheduleCreateResponse.builder()
                .author(bundleResponse.getAuthor())
                .status(bundleResponse.getStatus())
                .title(bundleResponse.getTitle())
                .content(bundleResponse.getContent())
                .createDate(bundleResponse.getCreateDate())
                .modifiedDate(bundleResponse.getModifiedDate())
                .build();
    }

    public ScheduleFindAllResponse toScheduleResponse(ScheduleGetCountBundle.Response countBundleResponse, ScheduleFindAllBundle.Response findBundleResponse) {
        return ScheduleFindAllResponse.builder()
                .totalCount(countBundleResponse.getTotalCount())
                .schedules(findBundleResponse.getScheduleFindBundleResponses())
                .build();
    }

    public ScheduleFindResponse toScheduleResponse(ScheduleFindBundle.Response bundleResponse) {
        return ScheduleFindResponse.builder()
                .author(bundleResponse.getAuthor())
                .status(bundleResponse.getStatus())
                .title(bundleResponse.getTitle())
                .content(bundleResponse.getContent())
                .createDate(bundleResponse.getCreateDate())
                .modifiedDate(bundleResponse.getModifiedDate())
                .build();
    }

    public ScheduleUpdateResponse toScheduleResponse(ScheduleUpdateBundle.Response bundleResponse) {
        return ScheduleUpdateResponse.builder()
                .author(bundleResponse.getAuthor())
                .status(bundleResponse.getStatus())
                .title(bundleResponse.getTitle())
                .content(bundleResponse.getContent())
                .createDate(bundleResponse.getCreateDate())
                .modifiedDate(bundleResponse.getModifiedDate())
                .build();
    }

    public ScheduleChangeStatusResponse toScheduleResponse(ScheduleChangeStatusBundle.Response bundleResponse) {
        return ScheduleChangeStatusResponse.builder()
                .author(bundleResponse.getAuthor())
                .status(bundleResponse.getStatus())
                .title(bundleResponse.getTitle())
                .content(bundleResponse.getContent())
                .createDate(bundleResponse.getCreateDate())
                .modifiedDate(bundleResponse.getModifiedDate())
                .build();
    }

    public ScheduleDeleteResponse toScheduleResponse(ScheduleDeleteBundle.Response bundleResponse) {
        return ScheduleDeleteResponse.builder()
                .author(bundleResponse.getAuthor())
                .status(bundleResponse.getStatus())
                .title(bundleResponse.getTitle())
                .content(bundleResponse.getContent())
                .createDate(bundleResponse.getCreateDate())
                .modifiedDate(bundleResponse.getModifiedDate())
                .build();
    }
}
