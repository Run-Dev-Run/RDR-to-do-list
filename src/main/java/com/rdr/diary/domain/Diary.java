package com.rdr.diary.domain;

import com.rdr.common.domain.BaseEntity;
import com.rdr.diary.domain.vo.Status;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Diary extends BaseEntity {
    @Id
    @Column(name = "DIARY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DIARY_AUTHOR")
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(name = "DIARY_STATUS")
    private Status status;

    @Column(name = "DIARY_TITLE")
    private String title;

    @Column(name = "DIARY_CONTENT")
    private String content;

    protected Diary() {
    }

    @Builder
    private Diary(String author, String title, String content) {
        this.author = author;
        this.status = Status.TODO;
        this.title = title;
        this.content = content;
    }

    public Diary update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }

    public Diary delete() {
        this.status = Status.DELETED;
        return this;
    }

    public Diary updateStatus() {
        this.status = Status.update(this.status);
        return this;
    }
}
