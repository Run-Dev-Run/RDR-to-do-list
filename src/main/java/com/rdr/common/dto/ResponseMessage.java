package com.rdr.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ResponseMessage {
    /**
     * Diary response message
     */
    DIARY_CREATE_SUCCESS("R-D-001", HttpStatus.CREATED),
    DIARIES_FIND_SUCCESS("R-D-002", HttpStatus.FOUND),
    DIARY_FIND_SUCCESS("R-D-003", HttpStatus.FOUND),
    DIARY_UPDATE_SUCCESS("R-D-004", HttpStatus.OK),
    DIARY_UPDATE_STATUS_SUCCESS("R-D-005", HttpStatus.OK),
    DIARY_DELETE_SUCCESS("R-D-006", HttpStatus.OK),
    ;

    private final String code;
    private final HttpStatus status;
}
