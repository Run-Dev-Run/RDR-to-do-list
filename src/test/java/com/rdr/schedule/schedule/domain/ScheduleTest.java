package com.rdr.schedule.schedule.domain;

import com.rdr.schedule.schedule.domain.vo.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScheduleTest {
    private Schedule schedule;

    @BeforeEach
    void setUp() {
        schedule = Schedule.builder()
                .author("이희찬")
                .title("인사말")
                .content("안녕하세요.")
                .build();
    }

    @Test
    void 저장_성공() {
        // when, then
        assertEquals("이희찬", schedule.getAuthor());
        assertEquals(Status.TODO, schedule.getStatus());
        assertEquals("인사말", schedule.getTitle());
        assertEquals("안녕하세요.", schedule.getContent());
    }

    @Test
    void 수정_성공() {
        // when
        schedule.update("Java 공부", "너무 어렵네요.");

        // then
        assertEquals("이희찬", schedule.getAuthor());
        assertEquals(Status.TODO, schedule.getStatus());
        assertEquals("Java 공부", schedule.getTitle());
        assertEquals("너무 어렵네요.", schedule.getContent());
    }

    @Test
    void 삭제_성공() {
        // when
        schedule.delete();

        // then
        assertEquals("이희찬", schedule.getAuthor());
        assertEquals(Status.DELETED, schedule.getStatus());
        assertEquals("인사말", schedule.getTitle());
        assertEquals("안녕하세요.", schedule.getContent());
    }

    @Test
    void 상태_한_번_변경_성공() {
        // when
        schedule.changeStatus();

        // then
        assertEquals("이희찬", schedule.getAuthor());
        assertEquals(Status.DOING, schedule.getStatus());
        assertEquals("인사말", schedule.getTitle());
        assertEquals("안녕하세요.", schedule.getContent());
    }

    @Test
    void 상태_두_번_변경_성공() {
        // when
        schedule.changeStatus();
        schedule.changeStatus();

        // then
        assertEquals("이희찬", schedule.getAuthor());
        assertEquals(Status.DONE, schedule.getStatus());
        assertEquals("인사말", schedule.getTitle());
        assertEquals("안녕하세요.", schedule.getContent());
    }

    @Test
    void 상태_세_번이상_변경_성공() {
        // when
        for (int i = 0; i < 123; i++) {
            schedule.changeStatus();
        }

        // then
        assertEquals("이희찬", schedule.getAuthor());
        assertEquals(Status.DONE, schedule.getStatus());
        assertEquals("인사말", schedule.getTitle());
        assertEquals("안녕하세요.", schedule.getContent());
    }
}
