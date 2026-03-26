<script setup lang="ts">
defineProps<{
  variant?: "primary" | "danger";
  disabled?: boolean;
}>();
</script>

<template>
  <button
    :disabled="disabled"
    class="px-4 py-2 rounded-lg text-white transition disabled:opacity-50 disabled:cursor-not-allowed"
    :class="{
      'bg-green-500 hover:bg-green-600': variant === 'primary',
      'bg-red-500 hover:bg-red-600': variant === 'danger'
    }"
  >
    <slot />
  </button>
</template>