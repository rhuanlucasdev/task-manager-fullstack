<script setup lang="ts">
import { ref, onMounted } from "vue";

import {
  getTasks,
  createTask,
  deleteTask,
  toggleTask,
} from "@/services/taskService";

const tasks = ref<any[]>([]);
const newTask = ref("");

async function loadTasks() {
  tasks.value = await getTasks();
}

async function addTask() {
  if (!newTask.value) return;

  await createTask(newTask.value);
  newTask.value = "";

  await loadTasks();
}

async function removeTask(id: number) {
  await deleteTask(id);
  await loadTasks();
}

async function toggle(id: number) {
  await toggleTask(id);
  await loadTasks();
}

onMounted(loadTasks);
</script>

<template>
  <div>
    <h1>Task Manager</h1>

    <input v-model="newTask" placeholder="Nova tarefa" />
    <button @click="addTask">Adicionar</button>

    <ul>
      <li v-for="task in tasks" :key="task.id">
        <span
          @click="toggle(task.id)"
          :style="{ textDecoration: task.completed ? 'line-through' : 'none' }"
        >
          {{ task.title }}
        </span>

        <button @click="removeTask(task.id)">X</button>
      </li>
    </ul>
  </div>
</template>