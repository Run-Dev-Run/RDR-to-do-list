package com.rdr.todolist.schedule.infrastructure;

import com.rdr.todolist.schedule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
