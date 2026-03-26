<script setup lang="ts">
import { onMounted } from "vue";
import { useTaskStore } from "@/stores/taskStore";

import TaskInput from "@/components/molecules/TaskInput.vue";
import TaskList from "@/components/organisms/TaskList.vue";

const store = useTaskStore();

onMounted(store.fetchTasks);
</script>

<template>
  <div class="min-h-screen bg-gray-100 flex items-center justify-center">
    <div class="bg-white shadow-lg rounded-2xl p-6 w-full max-w-md">

      <h1 class="text-2xl font-bold mb-4 text-center">
        Task Manager
      </h1>

      <TaskInput
        @add="store.addTask"
        :loading="store.isLoading"
      />

      <TaskList
        :tasks="store.tasks"
        :loadingIds="store.loadingIds"
        @toggle="store.toggle"
        @delete="store.removeTask"
      />

      <div
        v-if="store.tasks.length === 0"
        class="text-center text-gray-400 mt-6"
      >
        <p class="text-lg">Nada por aqui ainda 👀</p>
        <p class="text-sm">Adicione sua primeira tarefa</p>
      </div>

    </div>
  </div>
</template>