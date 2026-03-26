import { defineStore } from "pinia";
import { ref } from "vue";

import {
  getTasks,
  createTask,
  deleteTask,
  toggleTask,
} from "@/services/taskService";

/**
 * Store global de tarefas
 */
export const useTaskStore = defineStore("task", () => {
  // estado global
  const tasks = ref<any[]>([]);
  const isLoading = ref(false);

  /**
   * Carrega tarefas do backend
   */
  async function fetchTasks() {
    tasks.value = await getTasks();
  }

  /**
   * Cria nova tarefa
   */
  async function addTask(title: string) {
    if (!title) return;

    isLoading.value = true;

    const newTask = await createTask(title);

    // atualização otimista (sem refetch)
    tasks.value.push(newTask);

    isLoading.value = false;
  }

  /**
   * Remove tarefa
   */
  async function removeTask(id: number) {
    await deleteTask(id);

    // remove localmente
    tasks.value = tasks.value.filter(task => task.id !== id);
  }

  /**
   * Alterna status
   */
  async function toggle(id: number) {
    const updatedTask = await toggleTask(id);

    // atualiza localmente
    const index = tasks.value.findIndex(t => t.id === id);

    if (index !== -1) {
      tasks.value[index] = updatedTask;
    }
  }

  return {
    tasks,
    isLoading,
    fetchTasks,
    addTask,
    removeTask,
    toggle,
  };
});