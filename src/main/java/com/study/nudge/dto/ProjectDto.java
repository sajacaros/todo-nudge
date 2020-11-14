package com.study.nudge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ProjectDto {
    @Getter
    @ToString
    @Setter
    class New {
        private String channel;
        private String description;
    }

    @Getter
    @ToString
    @Builder
    class Details {
        private Long id;
        private String channel;
        private String description;
        private Summary summary;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy/MM/dd HH:mm:ss", timezone = "Asia/Seoul")
        private LocalDateTime createdDate;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy/MM/dd HH:mm:ss", timezone = "Asia/Seoul")
        private LocalDateTime lastModifiedDate;
    }

    class Summary {
        private Integer total;
        private Integer done;
        private Integer remainder;
        private LocalDate startedDate;
        private LocalDate endDate;
    }
}
