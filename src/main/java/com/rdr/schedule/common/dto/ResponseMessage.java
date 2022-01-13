package com.rdr.schedule.common.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseMessage {
    /**
     * Schedule response message
     */
    SCHEDULE_CREATE_SUCCESS("R-S-001", HttpStatus.CREATED),
    SCHEDULES_FIND_SUCCESS("R-S-002", HttpStatus.FOUND),
    SCHEDULE_FIND_SUCCESS("R-S-003", HttpStatus.FOUND),
    SCHEDULE_UPDATE_SUCCESS("R-S-004", HttpStatus.OK),
    SCHEDULE_CHANGE_STATUS_SUCCESS("R-S-005", HttpStatus.OK),
    SCHEDULE_DELETE_SUCCESS("R-S-006", HttpStatus.OK),
    ;

    private final String code;
    private final HttpStatus status;

    ResponseMessage(String code, HttpStatus status) {
        this.code = code;
        this.status = status;
    }
}
