package com.rhuan.taskmanager.service;

// Entidade (modelo de dados)
import com.rhuan.taskmanager.domain.Task;

// Repository (acesso ao banco)
import com.rhuan.taskmanager.repository.TaskRepository;

// Annotation que marca essa classe como um "Service" gerenciado pelo Spring
import org.springframework.stereotype.Service;

// API moderna de datas
import java.time.LocalDateTime;

// Lista tipada do Java
import java.util.List;

/**
 * Camada de serviço responsável pela lógica de negócio.
 * 
 * Aqui é onde decidimos COMO a aplicação funciona,
 * e NÃO apenas acessar o banco.
 */
@Service
public class TaskService {

    /**
     * Dependência do repository.
     * 
     * Usamos "final" porque essa dependência não deve mudar.
     */
    private final TaskRepository taskRepository;

    /**
     * Construtor usado pelo Spring para injeção de dependência.
     * 
     * O Spring automaticamente fornece uma instância de TaskRepository.
     */
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Cria uma nova tarefa.
     * 
     * @param title título da tarefa
     * @return tarefa salva no banco
     */
    public Task createTask(String title) {

        // Criamos uma nova instância da entidade
        Task task = new Task();

        // Definimos os valores iniciais
        task.setTitle(title);

        // Toda nova tarefa começa como não concluída
        task.setCompleted(false);

        // Define a data de criação como agora
        task.setCreatedAt(LocalDateTime.now());

        // Salva no banco e retorna a entidade persistida
        return taskRepository.save(task);
    }

    /**
     * Retorna todas as tarefas do banco.
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Deleta uma tarefa pelo ID.
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    /**
     * Alterna o status de uma tarefa (concluída ↔ não concluída).
     * 
     * @param id identificador da tarefa
     * @return tarefa atualizada
     */
    public Task toggleTask(Long id) {

        // Busca a tarefa pelo ID
        Task task = taskRepository.findById(id)

                // Se não encontrar, lança erro
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // Inverte o valor atual (true vira false, false vira true)
        task.setCompleted(!task.isCompleted());

        // Salva novamente no banco (update)
        return taskRepository.save(task);
    }
}