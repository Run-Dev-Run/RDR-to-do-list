package com.rdr.schedule.schedule.domain.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatusTest {
    @Test
    void TODO에서_상태_변경_성공() {
        // when
        Status status = Status.change(Status.TODO);

        // then
        assertEquals(Status.DOING, status);
    }

    @Test
    void DOING에서_상태_변경_성공() {
        // when
        Status status = Status.change(Status.DOING);

        // then
        assertEquals(Status.DONE, status);
    }

    @Test
    void DONE에서_상태_변경_성공() {
        // when
        Status status = Status.change(Status.DONE);

        // then
        assertEquals(Status.DONE, status);
    }
}
