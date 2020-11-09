package com.study.nudge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface TodoDto {
    @Getter
    @ToString
    @Setter
    class New {
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy/MM/dd", timezone = "Asia/Seoul")
        private LocalDate targetDate;
        private String channel;
        private String todo;
    }

    @Getter
    @ToString
    @Builder
    class Details {
        Long id;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy/MM/dd", timezone = "Asia/Seoul")
        private LocalDate targetDate;
        private String channel;
        private String todo;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy/MM/dd HH:mm:ss", timezone = "Asia/Seoul")
        private LocalDateTime registerDate;
    }
}
