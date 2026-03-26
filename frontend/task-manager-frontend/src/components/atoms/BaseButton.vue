<script setup lang="ts">
defineProps<{
  variant?: "primary" | "danger";
}>();
</script>

<template>
  <button
    class="px-4 py-2 rounded-lg text-white transition"
    :class="{
      'bg-green-500 hover:bg-green-600': variant === 'primary',
      'bg-red-500 hover:bg-red-600': variant === 'danger'
    }"
  >
    <slot />
  </button>
</template>