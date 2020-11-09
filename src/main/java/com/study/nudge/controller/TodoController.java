package com.study.nudge.controller;

import com.study.nudge.dto.TodoDto;
import com.study.nudge.service.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long newTodo(@RequestBody TodoDto.New todo) {
        return todoService.newTodo(todo);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TodoDto.Details> newTodo(
            @RequestParam("date")
            @DateTimeFormat(pattern = "yy/MM/dd") LocalDate theDate) {
        return todoService.findTodo(theDate);
    }

    @PostMapping(value = "/today")
    public void sendToday() {
        todoService.sendToSlackOnToday();
    }
}
