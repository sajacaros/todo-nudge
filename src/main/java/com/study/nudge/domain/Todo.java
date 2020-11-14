package com.study.nudge.domain;

import com.study.nudge.dto.TodoDto;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate targetDate;
    private String todo;

    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private Project project;

    @CreatedDate
    private LocalDateTime registerDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public Todo(TodoDto.New todoRequest) {
        this.targetDate = todoRequest.getTargetDate();
        this.todo = todoRequest.getTodo();
    }

    public Long id() {
        return this.id;
    }

    public LocalDate targetDate() {
        return this.targetDate;
    }

    public String todo() {
        return this.todo;
    }

    public LocalDateTime registerDate() {
        return this.registerDate;
    }

    public LocalDateTime lastModifiedDate() {
        return this.modifiedDate;
    }
}


