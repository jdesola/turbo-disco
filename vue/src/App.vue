<template>
  <v-app id="main" :style="{background: $vuetify.theme.themes[theme].background}">
    
    <div id="nav">
      <header-main />

      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view/>
  </v-app>
</template>

<script>
import HeaderMain from "../src/components/header.vue";

export default {
  name: "app",
  components: {
    HeaderMain,
  },
  data() {
    return {
    color: "rgb(113, 116, 116)",
  }
  },
  computed: {
    theme() {
      return (this.$vuetify.theme.dark) ? 'dark' : 'light'
      }
    }
  };
  // methods: {
  //   saveSearchResults(results) {
  //     this.$store.commit('SET_SEARCH_RESULTS', results);
  //   }
  // }
</script>

<style>
#app {
  padding-left: 7.5%;
  padding-right: 7.5%;
}

</style>
