<script setup lang="ts">
defineProps<{
  task: {
    id: number;
    title: string;
    completed: boolean;
  };
}>();

const emit = defineEmits(["toggle", "delete"]);
</script>

<template>
  <li
    class="flex justify-between items-center bg-gray-50 p-2 rounded-lg"
  >
    <span
      @click="emit('toggle', task.id)"
      class="cursor-pointer"
      :class="{ 'line-through text-gray-400': task.completed }"
    >
      {{ task.title }}
    </span>

    <button
      @click="emit('delete', task.id)"
      class="text-red-500"
    >
      ✕
    </button>
  </li>
</template>