package com.study.nudge.service.todo;

import com.study.nudge.domain.Todo;
import com.study.nudge.dto.TodoDto;
import com.study.nudge.repository.TodoRepository;
import com.study.nudge.service.slack.SlackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public interface TodoService {
    Long newTodo(TodoDto.New todo);

    List<TodoDto.Details> findTodo(LocalDate theDate);

    void sendToSlackOnToday();

    @Service
    @Slf4j
    @Transactional
    class Default implements TodoService {

        @Autowired
        private TodoRepository repository;
        @Autowired
        private SlackService slackService;

        @Override
        public Long newTodo(TodoDto.New todoRequest) {
            log.info("new todo : {}", todoRequest);
            Todo newTodo = new Todo(todoRequest);
            return repository.save(newTodo).id();
        }

        @Override
        public List<TodoDto.Details> findTodo(LocalDate theDate) {
            return repository.findByTargetDate(theDate).stream()
                    .map(t->TodoDto.Details.builder()
                        .id(t.id())
                        .channel(t.channel())
                        .targetDate(t.targetDate())
                        .todo(t.todo())
                        .registerDate(t.registerDate())
                        .build()
                    ).collect(Collectors.toList());
        }

        @Override
        public void sendToSlackOnToday() {
            for( TodoDto.Details details : findTodo(LocalDate.now()) ) {
                log.info("send to slack, todo : {}", details);
                slackService.sendTodo(details);
            }
        }

    }
}
