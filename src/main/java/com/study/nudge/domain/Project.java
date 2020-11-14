package com.study.nudge.domain;

import com.study.nudge.dto.ProjectDto;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String channel;
    private String description;

    @OneToMany(mappedBy = "project")
    private List<Todo> todos = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public Project(ProjectDto.New newProject) {
        this.channel = newProject.getChannel();
        this.description = newProject.getDescription();
    }

    public Long id() {
        return this.id;
    }

    public String channel() {
        return this.channel;
    }

    public LocalDateTime createdDate() {
        return this.createdDate;
    }

    public LocalDateTime lastModifiedDate() {
        return this.modifiedDate;
    }
}


