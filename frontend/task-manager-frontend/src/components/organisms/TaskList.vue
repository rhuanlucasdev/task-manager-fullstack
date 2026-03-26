<script setup lang="ts">
import TaskItem from "@/components/molecules/TaskItem.vue";

defineProps<{
  tasks: any[];
  loadingIds: number[];
}>();

const emit = defineEmits(["toggle", "delete"]);
</script>

<template>
  <transition-group name="list" tag="ul" class="space-y-2">
    <TaskItem
      v-for="task in tasks"
      :key="task.id"
      :task="task"
      :loading="loadingIds.includes(task.id)"
      @toggle="emit('toggle', $event)"
      @delete="emit('delete', $event)"
    />
  </transition-group>
</template>