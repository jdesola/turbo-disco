<template>
  <div id="app">
    
    <div id="nav">
      <header-main v-on:searchCommitted="saveSearchResults"/>

      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view/>
  </div>
</template>

<script>
import HeaderMain from "../src/components/header.vue";

export default {
  name: "app",
  components: {
    HeaderMain,
  },
  methods: {
    saveSearchResults(results) {
      this.$store.commit('SET_SEARCH_RESULTS', results);
    }
  }
};
</script>

<style>
#app {
  margin-left: 7.5%;
  margin-right: 7.5%;
}

</style>