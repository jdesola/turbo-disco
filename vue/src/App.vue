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
    <footer-main />
  </v-app>
</template>

<script>
import HeaderMain from "../src/components/header.vue";
import FooterMain from "../src/components/Footer.vue";

export default {
  name: "app",
  components: {
    HeaderMain,
    FooterMain,
  },
  data() {
    return {
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
#main {
  padding-left: 7.5%;
  padding-right: 7.5%;
}

@font-face {
  font-family: 'Subscriber';
  src: local("Subscriber"),
  url(./assets/fonts/subscribe-web/subscriber-regular-webfont.woff2) format("woff2")
}

</style>
