<script setup lang="ts">
import TaskItem from "@/components/molecules/TaskItem.vue";

defineProps<{
  tasks: any[];
}>();

const emit = defineEmits(["toggle", "delete"]);
</script>

<template>
  <ul class="space-y-2">
    <TaskItem
      v-for="task in tasks"
      :key="task.id"
      :task="task"
      @toggle="emit('toggle', $event)"
      @delete="emit('delete', $event)"
    />
  </ul>
</template>