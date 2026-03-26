<script setup lang="ts">
defineProps<{
  task: {
    id: number;
    title: string;
    completed: boolean;
  };
  loading?: boolean;
}>();

const emit = defineEmits(["toggle", "delete"]);
</script>

<template>
  <li
    class="flex justify-between items-center bg-gray-50 p-3 rounded-lg transition hover:shadow-md"
  >
    <span
      @click="!loading && emit('toggle', task.id)"
      class="cursor-pointer transition"
      :class="{
        'line-through text-gray-400': task.completed,
        'opacity-50': loading
      }"
    >
      {{ task.title }}
    </span>

    <button
      @click="emit('delete', task.id)"
      :disabled="loading"
      class="text-red-500 transition hover:scale-110 disabled:opacity-30"
    >
      {{ loading ? "..." : "✕" }}
    </button>
  </li>
</template>