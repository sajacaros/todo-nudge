package com.study.nudge.service.todo;

import com.study.nudge.dto.TodoDto;
import com.study.nudge.service.slack.SlackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Slf4j
public class TodoScheduler {
    @Autowired
    private TodoService todoService;
    @Autowired
    private SlackService slackService;

    @Scheduled(cron = "0 0 6 * * ?")
    public void run() {
        log.info("schedule run. current : {}", LocalDateTime.now());
        for( TodoDto.Details details :todoService.findTodo(LocalDate.now()) ) {
            slackService.sendTodo(details);
        }
    }
}
