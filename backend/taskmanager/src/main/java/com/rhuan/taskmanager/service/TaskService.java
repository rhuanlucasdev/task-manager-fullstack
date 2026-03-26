package com.rhuan.taskmanager.service;

import com.rhuan.taskmanager.dto.TaskDTO;
import com.rhuan.taskmanager.domain.Task;
import com.rhuan.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Camada de negócio (Service)
 */
@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    /**
     * Converte Entity → DTO
     */
    private TaskDTO toDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.isCompleted());
    }

    /**
     * Busca todas tarefas
     */
    public List<TaskDTO> getAllTasks() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    /**
     * Cria tarefa
     */
    public TaskDTO createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);

        Task saved = repository.save(task);

        return toDTO(saved);
    }

    /**
     * Remove tarefa
     */
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    /**
     * Alterna status
     */
    public TaskDTO toggleTask(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        task.setCompleted(!task.isCompleted());

        return toDTO(repository.save(task));
    }
}