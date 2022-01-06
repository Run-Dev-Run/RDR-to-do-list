package com.rdr.todolist.schedule.domain;

import com.rdr.todolist.common.domain.BaseEntity;
import com.rdr.todolist.schedule.domain.vo.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@AllArgsConstructor
@Builder
@Getter
@Entity
public class Schedule extends BaseEntity {
    @Id
    @Column(name = "SCHEDULE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SCHEDULE_AUTHOR")
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(name = "SCHEDULE_STATUS")
    private Status status;

    @Column(name = "SCHEDULE_TITLE")
    private String title;

    @Column(name = "SCHEDULE_CONTENT")
    private String content;

    protected Schedule() {
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void delete() {
        this.status = Status.DELETED;
    }

    public void changeStatus() {
        this.status = Status.change(this.status);
    }

    public boolean isDelete() {
        return this.status.equals(Status.DELETED);
    }
}
