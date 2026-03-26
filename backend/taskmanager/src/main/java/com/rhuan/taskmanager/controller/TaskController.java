package com.rhuan.taskmanager.controller;

import com.rhuan.taskmanager.domain.Task;
import com.rhuan.taskmanager.service.TaskService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por expor a API REST de tarefas.
 * 
 * Aqui lidamos com requisições HTTP (entrada/saída),
 * NÃO com regra de negócio.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    /**
     * Dependência do service (regra de negócio).
     */
    private final TaskService taskService;

    /**
     * Injeção de dependência via construtor.
     */
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * GET /tasks
     * Retorna todas as tarefas.
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * POST /tasks
     * Cria uma nova tarefa.
     * 
     * @RequestBody → converte JSON em objeto Java
     */
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task.getTitle());
    }

    /**
     * DELETE /tasks/{id}
     * Remove uma tarefa pelo ID.
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    /**
     * PATCH /tasks/{id}
     * Alterna o status da tarefa.
     */
    @PatchMapping("/{id}")
    public Task toggleTask(@PathVariable Long id) {
        return taskService.toggleTask(id);
    }
}