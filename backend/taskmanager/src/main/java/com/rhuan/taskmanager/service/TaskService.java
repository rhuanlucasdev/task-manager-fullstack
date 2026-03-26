package com.rhuan.taskmanager.service;

import com.rhuan.taskmanager.domain.Task;
import com.rhuan.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        task.setCreatedAt(LocalDateTime.now());

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setCompleted(!task.isCompleted());

        return taskRepository.save(task);
    }
}