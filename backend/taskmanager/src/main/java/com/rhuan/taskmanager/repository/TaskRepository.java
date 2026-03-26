package com.rhuan.taskmanager.repository;

import com.rhuan.taskmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsável por acessar os dados da entidade Task.
 * 
 * Aqui NÃO escrevemos implementação.
 * O Spring gera tudo automaticamente.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}