package com.thx.projecttracking.controller;

import com.thx.projecttracking.model.Task;
import com.thx.projecttracking.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task) {
        return service.saveTask(task);
    }

    @PostMapping("/addTasks")
    public List<Task> addTasks(@RequestBody List<Task> tasks) {
        return service.saveTasks(tasks);
    }

    @GetMapping("/tasks")
    public List<Task> findAllTasks(){
        return service.getTasks();
    }

    @GetMapping("/taskById/{id}")
    public Task findTaskById(@PathVariable int id) {
        return service.getTaskById(id);
    }

    @GetMapping("/task/{name}")
    public Task findTaskByName(@PathVariable String name) {
        return service.getTaskByName(name);
    }

    @PutMapping("/update")
    public Task updateProduct(@RequestBody Task task) {
        return service.updateTask(task);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        return service.deleteTask(id);
    }

    @RequestMapping("*")
    public String index(){
        return "ok";
    }
}
