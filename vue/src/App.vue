<template>
  <div id="app">
    <div class="left-block"> </div>
    
    <div id="nav">
      <header-main />

      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view class="body-content"/>
    <div class="right-block"></div>
  </div>
</template>

<script>
import HeaderMain from "../src/components/header.vue";

export default {
  components: {
    HeaderMain,
  },
};
</script>

<style>

</style>