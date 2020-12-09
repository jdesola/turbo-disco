<template>
  <div id="app">
    <reactive-base
    app="catch-app"
    credentials="jlsddcdIX:8bbd03ef-c708-424c-bb13-82bb53669153"
    >
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
    <search-results/>
    </reactive-base>
  </div>
</template>

<script>
import HeaderMain from "../src/components/header.vue";
import SearchResults from './components/SearchResults.vue';

export default {
  components: {
    HeaderMain,
    SearchResults,
  },
};
</script>

<style>
#app {
  margin-left: 7.5%;
  margin-right: 7.5%;
}

</style>