package com.rdr.diary.domain.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatusTest {
    @Test
    void TODO에서_상태_변경_성공() {
        // when
        Status status = Status.update(Status.TODO);

        // then
        assertEquals(Status.DOING, status);
    }

    @Test
    void DOING에서_상태_변경_성공() {
        // when
        Status status = Status.update(Status.DOING);

        // then
        assertEquals(Status.DONE, status);
    }

    @Test
    void DONE에서_상태_변경_성공() {
        // when
        Status status = Status.update(Status.DONE);

        // then
        assertEquals(Status.DONE, status);
    }
}
