package com.study.nudge.repository;

import com.study.nudge.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByTargetDate(LocalDate theDate);
}
