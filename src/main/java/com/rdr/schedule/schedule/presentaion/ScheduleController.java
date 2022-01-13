package com.rdr.schedule.schedule.presentaion;

import com.rdr.schedule.common.dto.BaseResponse;
import com.rdr.schedule.common.dto.ResponseMessage;
import com.rdr.schedule.schedule.application.ScheduleService;
import com.rdr.schedule.schedule.converter.ScheduleConverter;
import com.rdr.schedule.schedule.dto.bundle.*;
import com.rdr.schedule.schedule.dto.request.ScheduleCreateRequest;
import com.rdr.schedule.schedule.dto.request.ScheduleUpdateRequest;
import com.rdr.schedule.schedule.dto.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/v1/schedules")
@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final ScheduleConverter scheduleConverter;

    @PostMapping
    public BaseResponse<ScheduleCreateResponse> create(@RequestBody ScheduleCreateRequest request) {
        ScheduleCreateBundle.Request bundleRequest = scheduleConverter.toScheduleCreateBundleRequest(request);
        ScheduleCreateBundle.Response bundleResponse = scheduleService.create(bundleRequest);

        ScheduleCreateResponse response = scheduleConverter.toScheduleResponse(bundleResponse);
        return BaseResponse.of(ResponseMessage.SCHEDULE_CREATE_SUCCESS, response);
    }

    @GetMapping
    public BaseResponse<ScheduleFindAllResponse> find() {
        ScheduleGetCountBundle.Response countBundleResponse = scheduleService.getCount();
        ScheduleFindAllBundle.Response findBundleResponse = scheduleService.find();

        ScheduleFindAllResponse response = scheduleConverter.toScheduleResponse(countBundleResponse, findBundleResponse);
        return BaseResponse.of(ResponseMessage.SCHEDULES_FIND_SUCCESS, response);
    }

    @GetMapping("/{id}")
    public BaseResponse<ScheduleFindResponse> find(@PathVariable Long id) {
        ScheduleFindBundle.Request bundleRequest = ScheduleFindBundle.Request.of(id);
        ScheduleFindBundle.Response bundleResponse = scheduleService.find(bundleRequest);

        ScheduleFindResponse response = scheduleConverter.toScheduleResponse(bundleResponse);
        return BaseResponse.of(ResponseMessage.SCHEDULE_FIND_SUCCESS, response);
    }

    @PutMapping("/{id}")
    public BaseResponse<ScheduleUpdateResponse> update(@PathVariable Long id, @RequestBody ScheduleUpdateRequest request) {
        ScheduleUpdateBundle.Request bundleRequest = scheduleConverter.toScheduleUpdateBundleRequest(id, request);
        ScheduleUpdateBundle.Response bundleResponse = scheduleService.update(bundleRequest);

        ScheduleUpdateResponse response = scheduleConverter.toScheduleResponse(bundleResponse);
        return BaseResponse.of(ResponseMessage.SCHEDULE_UPDATE_SUCCESS, response);
    }

    @PatchMapping("/{id}")
    public BaseResponse<ScheduleChangeStatusResponse> changeStatus(@PathVariable Long id) {
        ScheduleChangeStatusBundle.Request bundleRequest = ScheduleChangeStatusBundle.Request.of(id);
        ScheduleChangeStatusBundle.Response bundleResponse = scheduleService.changeStatus(bundleRequest);

        ScheduleChangeStatusResponse response = scheduleConverter.toScheduleResponse(bundleResponse);
        return BaseResponse.of(ResponseMessage.SCHEDULE_CHANGE_STATUS_SUCCESS, response);
    }

    @DeleteMapping("/{id}")
    public BaseResponse<ScheduleDeleteResponse> delete(@PathVariable Long id) {
        ScheduleDeleteBundle.Request bundleRequest = ScheduleDeleteBundle.Request.of(id);
        ScheduleDeleteBundle.Response bundleResponse = scheduleService.delete(bundleRequest);

        ScheduleDeleteResponse response = scheduleConverter.toScheduleResponse(bundleResponse);
        return BaseResponse.of(ResponseMessage.SCHEDULE_DELETE_SUCCESS, response);
    }
}
