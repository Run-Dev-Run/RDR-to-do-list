package com.rdr.todolist.schedule.infrastructure;

import com.rdr.todolist.schedule.domain.Schedule;
import com.rdr.todolist.schedule.domain.vo.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "select s from Schedule s where not s.status = 'DELETED'")
    List<Schedule> findAll();

    @Query(value = "select s from Schedule s where not s.status = 'DELETED' and s.id = :id")
    Optional<Schedule> findById(Long id);
}
