package com.rhuan.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para criação de tarefa
 */
public class CreateTaskDTO {

    @NotBlank(message = "Título é obrigatório")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}