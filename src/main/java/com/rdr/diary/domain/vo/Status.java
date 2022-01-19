package com.rdr.diary.domain.vo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum Status {
    TODO,
    DOING,
    DONE,
    DELETED,
    ;

    public static Status update(Status status) {
        if (status.equals(Status.TODO)) {
            return Status.DOING;
        }
        if (status.equals(Status.DOING)) {
            return Status.DONE;
        }
        return status;
    }
}
