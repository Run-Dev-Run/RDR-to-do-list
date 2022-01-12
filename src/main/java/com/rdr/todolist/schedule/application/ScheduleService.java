package com.rdr.todolist.schedule.application;

import com.rdr.todolist.common.exception.ErrorMessage;
import com.rdr.todolist.schedule.converter.ScheduleConverter;
import com.rdr.todolist.schedule.domain.Schedule;
import com.rdr.todolist.schedule.domain.vo.Status;
import com.rdr.todolist.schedule.dto.bundle.ScheduleCreateBundle;
import com.rdr.todolist.schedule.dto.bundle.ScheduleUpdateBundle;
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
    public void create(ScheduleCreateBundle bundle) {
        scheduleRepository.save(
                scheduleConverter.toSchedule(bundle)
        );
    }

    @Transactional(readOnly = true)
    public List<Schedule> find() {
        return scheduleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Schedule find(Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException(ErrorMessage.SCHEDULE_DOES_NOT_EXIST.name()));
    }

    @Transactional
    public void update(ScheduleUpdateBundle bundle) {
        find(bundle.getId()).update(bundle.getTitle(), bundle.getContent());
    }

    @Transactional
    public void delete(Long id) {
        find(id).delete();
    }

    @Transactional
    public void changeStatus(Long id) {
        find(id).changeStatus();
    }
}
