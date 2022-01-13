package com.rdr.schedule.schedule.domain;

import com.rdr.schedule.common.domain.BaseEntity;
import com.rdr.schedule.schedule.domain.vo.Status;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

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

    @Builder
    private Schedule(String author, String title, String content) {
        this.author = author;
        this.status = Status.TODO;
        this.title = title;
        this.content = content;
    }

    protected Schedule() {
    }

    public Schedule update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }

    public Schedule delete() {
        this.status = Status.DELETED;
        return this;
    }

    public Schedule changeStatus() {
        this.status = Status.change(this.status);
        return this;
    }
}
