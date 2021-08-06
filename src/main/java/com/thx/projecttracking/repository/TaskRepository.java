package com.thx.projecttracking.repository;

import com.thx.projecttracking.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findByName(String name);
}
