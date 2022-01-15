package com.rdr.diary.domain;

import com.rdr.diary.domain.vo.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiaryTest {
    private Diary diary;

    @BeforeEach
    void setUp() {
        diary = Diary.builder()
                .author("이희찬")
                .title("인사말")
                .content("안녕하세요.")
                .build();
    }

    @Test
    void 저장_성공() {
        // when, then
        assertEquals("이희찬", diary.getAuthor());
        Assertions.assertEquals(Status.TODO, diary.getStatus());
        assertEquals("인사말", diary.getTitle());
        assertEquals("안녕하세요.", diary.getContent());
    }

    @Test
    void 수정_성공() {
        // when
        diary.update("Java 공부", "너무 어렵네요.");

        // then
        assertEquals("이희찬", diary.getAuthor());
        Assertions.assertEquals(Status.TODO, diary.getStatus());
        assertEquals("Java 공부", diary.getTitle());
        assertEquals("너무 어렵네요.", diary.getContent());
    }

    @Test
    void 삭제_성공() {
        // when
        diary.delete();

        // then
        assertEquals("이희찬", diary.getAuthor());
        Assertions.assertEquals(Status.DELETED, diary.getStatus());
        assertEquals("인사말", diary.getTitle());
        assertEquals("안녕하세요.", diary.getContent());
    }

    @Test
    void 상태_한_번_변경_성공() {
        // when
        diary.updateStatus();

        // then
        assertEquals("이희찬", diary.getAuthor());
        Assertions.assertEquals(Status.DOING, diary.getStatus());
        assertEquals("인사말", diary.getTitle());
        assertEquals("안녕하세요.", diary.getContent());
    }

    @Test
    void 상태_두_번_변경_성공() {
        // when
        diary.updateStatus();
        diary.updateStatus();

        // then
        assertEquals("이희찬", diary.getAuthor());
        Assertions.assertEquals(Status.DONE, diary.getStatus());
        assertEquals("인사말", diary.getTitle());
        assertEquals("안녕하세요.", diary.getContent());
    }

    @Test
    void 상태_세_번이상_변경_성공() {
        // when
        for (int i = 0; i < 123; i++) {
            diary.updateStatus();
        }

        // then
        assertEquals("이희찬", diary.getAuthor());
        Assertions.assertEquals(Status.DONE, diary.getStatus());
        assertEquals("인사말", diary.getTitle());
        assertEquals("안녕하세요.", diary.getContent());
    }
}
