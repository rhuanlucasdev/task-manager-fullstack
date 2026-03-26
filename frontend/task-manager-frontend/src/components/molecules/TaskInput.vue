<script setup lang="ts">
import { ref } from "vue";
import BaseInput from "@/components/atoms/BaseInput.vue";
import BaseButton from "@/components/atoms/BaseButton.vue";

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
    <BaseInput
      v-model="newTask"
      placeholder="Nova tarefa"
    />

    <BaseButton variant="primary" @click="handleAdd">
      +
    </BaseButton>
  </div>
</template>