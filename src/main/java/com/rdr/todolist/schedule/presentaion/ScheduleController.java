package com.rdr.todolist.schedule.presentaion;

import com.rdr.todolist.common.dto.BaseResponse;
import com.rdr.todolist.common.dto.ResponseMessage;
import com.rdr.todolist.schedule.application.ScheduleService;
import com.rdr.todolist.schedule.converter.ScheduleConverter;
import com.rdr.todolist.schedule.dto.bundle.ScheduleCreateBundle;
import com.rdr.todolist.schedule.dto.bundle.ScheduleUpdateBundle;
import com.rdr.todolist.schedule.dto.request.ScheduleCreateRequest;
import com.rdr.todolist.schedule.dto.request.ScheduleUpdateRequest;
import com.rdr.todolist.schedule.dto.response.ScheduleResponse;
import com.rdr.todolist.schedule.dto.response.SchedulesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/schedules")
@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final ScheduleConverter scheduleConverter;

    @PostMapping
    public BaseResponse<ScheduleResponse> create(@RequestBody ScheduleCreateRequest request) {
        ScheduleCreateBundle bundle = scheduleConverter.toScheduleCreateBundle(request);
        ScheduleResponse response = scheduleConverter.toScheduleResponse(scheduleService.create(bundle));
        return BaseResponse.of(ResponseMessage.SCHEDULE_CREATE_SUCCESS, response);
    }

    @GetMapping
    public BaseResponse<SchedulesResponse> find() {
        Long totalCount = scheduleService.getCount();
        List<ScheduleResponse> scheduleResponses = scheduleConverter.toScheduleResponses(scheduleService.find());
        SchedulesResponse response = SchedulesResponse.of(totalCount, scheduleResponses);
        return BaseResponse.of(ResponseMessage.SCHEDULES_FIND_SUCCESS, response);
    }

    @GetMapping("/{id}")
    public BaseResponse<ScheduleResponse> find(@PathVariable Long id) {
        ScheduleResponse response = scheduleConverter.toScheduleResponse(scheduleService.find(id));
        return BaseResponse.of(ResponseMessage.SCHEDULE_FIND_SUCCESS, response);
    }

    @PutMapping("/{id}")
    public BaseResponse<ScheduleResponse> update(@PathVariable Long id, @RequestBody ScheduleUpdateRequest request) {
        ScheduleUpdateBundle bundle = scheduleConverter.toScheduleUpdateBundle(id, request);
        ScheduleResponse response = scheduleConverter.toScheduleResponse(scheduleService.update(bundle));
        return BaseResponse.of(ResponseMessage.SCHEDULE_UPDATE_SUCCESS, response);
    }

    @PatchMapping("/{id}")
    public BaseResponse<ScheduleResponse> changeStatus(@PathVariable Long id) {
        ScheduleResponse response = scheduleConverter.toScheduleResponse(scheduleService.changeStatus(id));
        return BaseResponse.of(ResponseMessage.SCHEDULE_CHANGE_STATUS_SUCCESS, response);
    }

    @DeleteMapping("/{id}")
    public BaseResponse<ScheduleResponse> delete(@PathVariable Long id) {
        ScheduleResponse response = scheduleConverter.toScheduleResponse(scheduleService.delete(id));
        return BaseResponse.of(ResponseMessage.SCHEDULE_DELETE_SUCCESS, response);
    }
}
