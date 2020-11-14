package com.study.nudge.controller;

import com.study.nudge.dto.ProjectDto;
import com.study.nudge.dto.TodoDto;
import com.study.nudge.service.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {
    @Autowired
    private TodoService todoService;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long newProject(@RequestBody ProjectDto.New project) {
        return todoService.newProject(project);
    }

    @PostMapping(value = "/{projectId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProjectDto.Details detailsProject(@PathVariable Long projectId) {
        return todoService.projectDetails(projectId);
    }

    @PostMapping(value = "/{projectId}/todos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long newTodo(@PathVariable Long proejctId, @RequestBody TodoDto.New todo) {
        return todoService.newTodo(todo);
    }

    @GetMapping(value = "/{projectId}/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TodoDto.Details> todos(
            @PathVariable Long projectId,
            @RequestParam("date")
            @DateTimeFormat(pattern = "yy/MM/dd") LocalDate theDate) {
        return todoService.findTodo(theDate);
    }

    @PostMapping(value = "/{projectId}/todos/today")
    public void sendToday(@PathVariable Long projectId) {
        todoService.sendToSlackOnToday();
    }
}
