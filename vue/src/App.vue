<template>
  <v-app id="main-style" :style="{background: $vuetify.theme.themes[theme].background}">
    
    <div id="nav-bar">
      <header-main />

     
    </div>
    
    <router-view/>
    <footer-main />
  </v-app>
</template>

<script>
import HeaderMain from "../src/components/header.vue";
import FooterMain from "../src/components/Footer.vue";
import catService from "../src/services/CatService"
import locationService from "../src/services/LocationService"
import storyService from "../src/services/StoryService"

export default {
  name: "app",
  components: {
    HeaderMain,
    FooterMain,
  },
 
  computed: {
    theme() {
      return (this.$vuetify.theme.dark) ? 'dark' : 'light'
      }
    },
    methods: {
    // saveSearchResults(results) {
    //   this.$store.commit('SET_SEARCH_RESULTS', results);
    // }
    retrieveCats() {
      catService.getCats().then(response => {
          this.$store.commit("SET_CAT_LIST", response.data);
        });
    },
    retrieveLocations() {
      locationService.getLocations().then(response => {
        this.$store.commit("SET_LOCATION_LIST", response.data);
      });
    },
    retrieveStories() {
      storyService.getStories().then(response => {
        this.$store.commit("SET_STORY_LIST", response.data);
      });
    }
  },
  created() {
    this.retrieveCats();
    this.retrieveLocations();
    this.retrieveStories();
  }
  };
  
</script>

<style>

#main-style {
  padding-left: 7.5%;
  padding-right: 7.5%;
}


#nav-bar {
  margin-left: -8.75% !important;
  margin-right: -8.75% !important;
  width: 200% !important; 
}

@font-face {
  font-family: 'Subscriber';
  src: local("Subscriber"),
  url(./assets/fonts/subscribe-web/subscriber-regular-webfont.woff2) format("woff2")
}

</style>
