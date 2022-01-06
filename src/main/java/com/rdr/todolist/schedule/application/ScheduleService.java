package com.rdr.todolist.schedule.application;

import com.rdr.todolist.common.exception.ErrorMessage;
import com.rdr.todolist.schedule.domain.Schedule;
import com.rdr.todolist.schedule.domain.vo.Status;
import com.rdr.todolist.schedule.dto.bundle.ScheduleCreateBundle;
import com.rdr.todolist.schedule.dto.bundle.ScheduleUpdateBundle;
import com.rdr.todolist.schedule.infrastructure.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void create(ScheduleCreateBundle bundle) {
        Schedule schedule = Schedule.builder()
                .author(bundle.getAuthor())
                .status(Status.TODO)
                .title(bundle.getTitle())
                .content(bundle.getContent())
                .build();
        scheduleRepository.save(schedule);
    }

    public List<Schedule> find() {
        return scheduleRepository.findAll()
                .stream()
                .filter(schedule -> !schedule.getStatus().equals(Status.DELETED))
                .collect(Collectors.toList());
    }

    public Schedule find(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException(ErrorMessage.SCHEDULE_DOES_NOT_EXIST.toString()));

        if (schedule.isDelete()) {
            throw new RuntimeException(ErrorMessage.DELETED_SCHEDULE.toString());
        }
        return schedule;
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
