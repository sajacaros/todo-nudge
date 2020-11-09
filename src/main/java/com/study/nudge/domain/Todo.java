package com.study.nudge.domain;

import com.study.nudge.dto.TodoDto;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String channel;
    private LocalDate targetDate;
    private String todo;
    private LocalDateTime registerDate;

    public Todo(TodoDto.New todoRequest) {
        this.channel = todoRequest.getChannel();
        this.targetDate = todoRequest.getTargetDate();
        this.todo = todoRequest.getTodo();
        registerDate = LocalDateTime.now();
    }

    public Long id() {
        return this.id;
    }

    public String channel() {
        return this.channel;
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
}


