<script setup lang="ts">
import { ref, onMounted } from "vue";

import TaskInput from "@/components/molecules/TaskInput.vue";
import TaskList from "@/components/organisms/TaskList.vue";

import {
  getTasks,
  createTask,
  deleteTask,
  toggleTask,
} from "@/services/taskService";

const tasks = ref<any[]>([]);
const isLoading = ref(false);

async function loadTasks() {
  tasks.value = await getTasks();
}

async function addTask(title: string) {
  if(!title) return;

  isLoading.value = true;

  await createTask(title);
  await loadTasks();

  isLoading.value = false;
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
  <div class="min-h-screen bg-gray-100 flex items-center justify-center">
    <div class="bg-white shadow-lg rounded-2xl p-6 w-full max-w-md">

      <h1 class="text-2xl font-bold mb-4 text-center">
        Task Manager
      </h1>

      <TaskInput @add="addTask" :loading="isLoading" />
      <p v-if="tasks.length === 0" class="text-center text-gray-400">
  Nenhuma tarefa ainda 
</p>
      <TaskList
        :tasks="tasks"
        @toggle="toggle"
        @delete="removeTask"
      />

    </div>
  </div>
</template>