package com.rdr.todolist.schedule.domain.vo;

public enum Status {
    TODO,
    DOING,
    DONE,
    DELETED;

    public static Status change(Status status) {
        if (status.equals(Status.TODO)) {
            return Status.DOING;
        }
        if (status.equals(Status.DOING)) {
            return Status.DONE;
        }
        return status;
    }
}
