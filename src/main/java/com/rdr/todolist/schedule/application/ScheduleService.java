package com.rdr.todolist.schedule.application;

import com.rdr.todolist.common.exception.ErrorMessage;
import com.rdr.todolist.schedule.converter.ScheduleConverter;
import com.rdr.todolist.schedule.domain.Schedule;
import com.rdr.todolist.schedule.dto.bundle.*;
import com.rdr.todolist.schedule.infrastructure.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleConverter scheduleConverter;

    @Transactional
    public ScheduleCreateBundle.Response create(ScheduleCreateBundle.Request requestBundle) {
        Schedule schedule = scheduleRepository.save(scheduleConverter.toSchedule(requestBundle));
        return scheduleConverter.toScheduleCreateBundleResponse(schedule);
    }

    @Transactional(readOnly = true)
    public ScheduleFindAllBundle.Response find() {
        List<Schedule> Schedules = scheduleRepository.findAll();
        return scheduleConverter.toScheduleFindAllBundleResponse(Schedules);
    }

    @Transactional(readOnly = true)
    public ScheduleFindBundle.Response find(ScheduleFindBundle.Request requestBundle) {
        Schedule schedule = scheduleRepository.findById(requestBundle.getId())
                .orElseThrow(() -> new RuntimeException(ErrorMessage.SCHEDULE_DOES_NOT_EXIST.name()));
        return scheduleConverter.toScheduleFindBundleResponse(schedule);
    }

    @Transactional(readOnly = true)
    public ScheduleGetCountBundle.Response getCount() {
        Long totalCount = scheduleRepository.getCount();
        return ScheduleGetCountBundle.Response.of(totalCount);
    }

    @Transactional
    public ScheduleUpdateBundle.Response update(ScheduleUpdateBundle.Request requestBundle) {
        Schedule schedule = scheduleRepository.findById(requestBundle.getId())
                .orElseThrow(() -> new RuntimeException(ErrorMessage.SCHEDULE_DOES_NOT_EXIST.name()))
                .update(requestBundle.getTitle(), requestBundle.getContent());
        return scheduleConverter.toScheduleUpdateBundleResponse(schedule);
    }

    @Transactional
    public ScheduleChangeStatusBundle.Response changeStatus(ScheduleChangeStatusBundle.Request requestBundle) {
        Schedule schedule = scheduleRepository.findById(requestBundle.getId())
                .orElseThrow(() -> new RuntimeException(ErrorMessage.SCHEDULE_DOES_NOT_EXIST.name()))
                .changeStatus();
        return scheduleConverter.toScheduleChangeStatusBundleResponse(schedule);
    }

    @Transactional
    public ScheduleDeleteBundle.Response delete(ScheduleDeleteBundle.Request requestBundle) {
        Schedule schedule = scheduleRepository.findById(requestBundle.getId())
                .orElseThrow(() -> new RuntimeException(ErrorMessage.SCHEDULE_DOES_NOT_EXIST.name()))
                .delete();
        return scheduleConverter.toScheduleDeleteBundleResponse(schedule);
    }
}
