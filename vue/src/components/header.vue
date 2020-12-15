<template>
  <div class="header-container" >
    
    <nav class="header-main" v-on:click="resetList">
      <router-link class="cat-logo" v-bind:to="{name: 'home'}">
        <img  class="cat-logo" src="../assets/png/small-logo.png"/>
      </router-link>
      <router-link class="button featured d-flex align-center" v-on:click="resetList" v-bind:to="{name: 'featuredCats'}">
        <v-icon class="material-icons featuredIcon" size="80" > star </v-icon>
        <h1>Featured</h1>
      </router-link>
      <router-link class="button cats" v-bind:to="{name: 'cats'}" v-on:click="resetList">
        <h1>Cats</h1>
      </router-link>
      <router-link class="button tools" v-on:click="resetList" v-bind:to="{name: 'featuredCats'}">
        <h1>Tools</h1>
      </router-link>
      <div class="search-container">
        <input type="text" class="search-bar" v-model=searchTerm @keyup.enter="runSearch"/>
          <button>
            <i v-on:click="runSearch" class="material-icons search-icon">search</i>
          </button>
      </div>
      
    </nav>
    
  </div>
</template>

<script>
import catService from '../services/CatService'
import locationService from '../services/LocationService'
export default {
  components: {},
  computed: {
    },
  data() {
    return {
      searchTerm: "",
      fuseOptions: {
        keys: ["name", "age", "hairLength", "color", "skills", "previousJobs", "priorExperienceMonths", "description" ],
        defaultAll: true, 
         tokenize: true,
         distance: 10,
         threshold: 0.1,
         findAllMatches: true

      }
      }
    },
   created() {
     this.retrieveCats();
     this.retrieveLocations(); 
      
      
    },
  methods: {
    resetList() {
      this.retrieveCats();
      this.searchTerm = "";
    },
    runSearch() {
      if (this.searchTerm == 0) {
        this.retrieveCats();
      } else {
        this.$search(this.searchTerm, this.$store.state.catList, this.fuseOptions).then(results => {
        this.$store.commit('SET_CAT_LIST', results)
        });
      }
    },
      
    retrieveCats() {
      catService.getCats().then(response => {
          this.$store.commit("SET_CAT_LIST", response.data);
        });
    },
    retrieveLocations() {
      locationService.getLocations().then(response => {
        this.$store.commit("SET_LOCATION_LIST", response.data);
      });
    }
 
  
    
  }

};
</script>

<style>


.header-main {
  display: grid;
  font-family: 'Subscriber';
  font-size: 350%;
  grid-template-columns: 2% 12% 15% 15% 15% 15% 10%;
  grid-template-rows: 33% 34% 33%;
  grid-template-areas:
    ". logo . . . . ."
    ". logo feat cats tools search . "
    ". logo . . . . .";
  justify-content: space-evenly;
  overflow: hidden;
}
.button {
  margin-left: 7%;
  height: 110%;
  justify-self: left;
  align-self: center;
}

.cat-logo {
  grid-area: logo;
  width: 100%;
}

.featured, .featuredIcon {
  grid-area: feat;
  color:  #161fc2 !important;
  text-decoration: none;
  
}


.cats {
  grid-area: cats;
  justify-self: center;
  text-decoration: none;
  color: #f6af71 !important;
}

.tools {
  grid-area: tools;
  margin-left: 3%;
  text-decoration: none;
  color: #575a8f !important;
}

.search-container {
  grid-area: search;
  display: flex;
  height: 76%;
  width: 100%;
  border-radius: 30px;
  background-color: rgba(199, 199, 199, 0.35);
  box-shadow: -2px 3px 15px 3px rgba(0, 0, 0, 0.5);
  float: right;
  justify-self: center;
  align-self: center;
  justify-content: center;
}
.search-bar {
    border: none;
  color: #33a3f5;
  background-color: rgba(199, 199, 199, 0);
  outline: none;
  font-family: "Quicksand", sans-serif;

}
.header-main > .search-container > button {
  grid-area: search;
  background-color: rgba(199, 199, 199, 0);
  color: #33a3f5;
  
}

.search-icon {
  grid-area: search;
  border-left: #33a3f5 1.5px solid;
  justify-self: flex-end;
}


</style>


