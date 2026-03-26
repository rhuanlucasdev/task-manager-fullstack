import { defineStore } from 'pinia'
import { ref } from 'vue'

import { getTasks, createTask, deleteTask, toggleTask } from '@/services/taskService'

export const useTaskStore = defineStore('task', () => {
  const tasks = ref<any[]>([])
  const isLoading = ref(false)
  const loadingIds = ref<number[]>([])

  async function fetchTasks() {
    tasks.value = await getTasks()
  }

  async function addTask(title: string) {
    if (!title) return

    isLoading.value = true

    const newTask = await createTask(title)
    tasks.value.push(newTask)

    isLoading.value = false
  }

  async function removeTask(id: number) {
    loadingIds.value.push(id)

    await deleteTask(id)

    tasks.value = tasks.value.filter((task) => task.id !== id)

    loadingIds.value = loadingIds.value.filter((i) => i !== id)
  }

  async function toggle(id: number) {
    loadingIds.value.push(id)

    const updatedTask = await toggleTask(id)

    const index = tasks.value.findIndex((t) => t.id === id)

    if (index !== -1) {
      tasks.value[index] = updatedTask
    }

    loadingIds.value = loadingIds.value.filter((i) => i !== id)
  }

  return {
    tasks,
    isLoading,
    loadingIds,
    fetchTasks,
    addTask,
    removeTask,
    toggle,
  }
})
