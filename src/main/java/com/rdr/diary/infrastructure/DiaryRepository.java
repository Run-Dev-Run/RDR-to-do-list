package com.rdr.diary.infrastructure;

import com.rdr.diary.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    @Query(value = "select d from Diary d where not d.status = 'DELETED'")
    List<Diary> findAll();

    @Query(value = "select d from Diary d where not d.status = 'DELETED' and d.id = :id")
    Optional<Diary> findById(Long id);

    @Query(value = "select count(d) from Diary d where not d.status = 'DELETED'")
    Long getCount();
}
