package com.thx.projecttracking.service;

import com.thx.projecttracking.model.Task;
import com.thx.projecttracking.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task saveTask(Task task){
        return repository.save(task);
    }

    public List<Task> saveTasks(List<Task> tasks) {
        return repository.saveAll(tasks);
    }

    public List<Task> getTasks(){
        return repository.findAll();
    }

    public Task getTaskById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Task getTaskByName(String name) {
        return repository.findByName(name);
    }

    public String deleteTask(int id) {
        repository.deleteById(id);
        return "task removed !! " + id;
    }

    public Task updateTask(Task task) {
        Task existingTask = repository.findById(task.getId()).orElse(null);
        existingTask.setName(task.getName());
        existingTask.setPerson_responsible(task.getPerson_responsible());
        existingTask.setStatus(task.getStatus());
        existingTask.setDate_due(task.getDate_due());
        existingTask.setPriority(task.getPriority());
        return repository.save(existingTask);
    }
}
