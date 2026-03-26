package com.rhuan.taskmanager.domain;

// Importações do JPA (mapeamento objeto-relacional)
import jakarta.persistence.*;

// Lombok - gera automaticamente getters, setters, toString, etc.
import lombok.Data;

// API moderna de datas do Java
import java.time.LocalDateTime;

/**
 * Entidade que representa uma tarefa no sistema.
 * 
 * Essa classe será mapeada para uma tabela no banco de dados.
 */
@Data // Lombok: evita boilerplate (getters, setters, etc.)
@Entity // Indica que essa classe é uma entidade JPA (vira tabela no banco)
public class Task {

    /**
     * Identificador único da tarefa (chave primária).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // IDENTITY → o banco gera automaticamente (auto incremento)
    private Long id;

    /**
     * Título ou descrição da tarefa.
     */
    private String title;

    /**
     * Indica se a tarefa foi concluída ou não.
     */
    private boolean completed;

    /**
     * Data e hora em que a tarefa foi criada.
     */
    private LocalDateTime createdAt;

    /**
     * Construtor vazio obrigatório para o JPA.
     * O framework usa isso para instanciar objetos automaticamente.
     */
    public Task() {
    }
}