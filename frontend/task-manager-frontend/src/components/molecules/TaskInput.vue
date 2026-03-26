<script setup lang="ts">
import { ref } from "vue";

const emit = defineEmits(["add"]);

const newTask = ref("");

function handleAdd() {
  if (!newTask.value) return;

  emit("add", newTask.value);
  newTask.value = "";
}
</script>

<template>
  <div class="flex gap-2 mb-4">
    <input
      v-model="newTask"
      placeholder="Nova tarefa"
      class="flex-1 border rounded-lg px-3 py-2"
    />
    <button
      @click="handleAdd"
      class="bg-green-500 text-white px-4 py-2 rounded-lg"
    >
      +
    </button>
  </div>
</template>