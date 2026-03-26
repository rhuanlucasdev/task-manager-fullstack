package com.rhuan.taskmanager.controller;

import com.rhuan.taskmanager.dto.CreateTaskDTO;
import com.rhuan.taskmanager.dto.TaskDTO;
import com.rhuan.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    /**
     * GET /tasks
     */
    @GetMapping
    public List<TaskDTO> getAll() {
        return service.getAllTasks();
    }

    /**
     * POST /tasks
     */
    @PostMapping
    public TaskDTO create(@Valid @RequestBody CreateTaskDTO dto) {
        return service.createTask(dto.getTitle());
    }

    /**
     * DELETE /tasks/{id}
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTask(id);
    }

    /**
     * PATCH /tasks/{id}
     */
    @PatchMapping("/{id}")
    public TaskDTO toggle(@PathVariable Long id) {
        return service.toggleTask(id);
    }
}