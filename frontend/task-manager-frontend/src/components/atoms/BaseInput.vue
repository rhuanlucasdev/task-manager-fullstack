<script setup lang="ts">
defineProps<{
  modelValue: string;
  placeholder?: string;
}>();

const emit = defineEmits(["update:modelValue"]);
</script>

<template>
  <input
    :value="modelValue"
    :placeholder="placeholder"
    @input="emit('update:modelValue', ($event.target as HTMLInputElement).value)"
    class="border rounded-lg px-3 py-2 w-full focus:outline-none focus:ring-2 focus:ring-green-400"
  />
</template>