package com.rdr.schedule.schedule.infrastructure;

import com.rdr.schedule.schedule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "select s from Schedule s where not s.status = 'DELETED'")
    List<Schedule> findAll();

    @Query(value = "select s from Schedule s where not s.status = 'DELETED' and s.id = :id")
    Optional<Schedule> findById(Long id);

    @Query(value = "select count(s) from Schedule s where not s.status = 'DELETED'")
    Long getCount();
}
