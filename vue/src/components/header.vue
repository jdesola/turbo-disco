<template>
  <div class="header-container">
    
    <nav class="header-main" v-on:click="resetList">
      <router-link class="cat-logo" v-bind:to="{name: 'home'}">
        <img  class="cat-logo" src="../assets/png/small-logo.png"/>
      </router-link>
      <a href="#" class="button fav" v-on:click="resetList">
        <img class="button fav" src="../assets/webp/favorites-button.webp"
      /></a>
      <router-link class="button cats" v-bind:to="{name: 'cats'}">
        <img class="button cats" src="../assets/webp/cats-button.webp" />
      </router-link>
      <a href="#" class="button profile " v-on:click="resetList"
        ><img class="button profile" src="../assets/webp/profile-button.webp"
      /></a>
      <div class="search-container"  >
        <input type="text" class="search-bar" v-model=searchTerm @keyup.enter="runSearch"/>
         <!-- <vue-fuse :keys="this.keys" :list="catList" :defaultAll=true class="search-bar" event-name="searchCommitted" 
         :tokenize=true :distance=10 :threshold=0.1 :findAllMatches=true > </vue-fuse> -->
          <button v-on:click="runSearch" >
            <i class="material-icons search-icon">search</i>
          </button>
      </div>
      
    </nav>
    
  </div>
</template>

<script>
import catService from '../services/CatService'
export default {
  components: {},
  computed: {
      catList() {
        
        return this.$store.state.catList;
      }
    },
  data() {
    return {
      searchTerm: "",
      results: [],
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
      // this.$on('searchCommitted', results => {
      //   this.results = results;
      //   this.$store.commit('SET_SEARCH_RESULTS', results);
      // })
      
    },
  methods: {
    resetList() {
      this.$store.commit('SET_SEARCH_RESULTS', this.catList);
      this.searchTerm = "";
    },
    runSearch() {
      if (this.searchTerm == 0) {
        this.$store.commit("SET_SEARCH_RESULTS", this.catList);
      } else {
        this.$search(this.searchTerm, this.catList, this.fuseOptions).then(results => {
        this.$store.commit('SET_SEARCH_RESULTS', results)
        });
      }
    },
      
    retrieveCats() {
      catService.getCats().then(response => {
          this.$store.commit("SET_CAT_LIST", response.data);
          this.$store.commit("SET_SEARCH_RESULTS", response.data);
        });
    },
 
  
    
  }

};
</script>

<style>


.header-main {
  /*grid container*/
  display: grid;
  grid-template-columns: 2% 12% 15% 15% 15% 15% 10%;
  grid-template-rows: 33% 34% 33%;
  grid-template-areas:
    ". logo . . . . ."
    ". logo fav cats profile search . "
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

.fav {
  grid-area: fav;
}

.cats {
  grid-area: cats;
  justify-self: center;
}

.profile {
  grid-area: profile;
  margin-left: 3%;
}

.search-container {
  grid-area: search;
  height: 76%;
  width: 100%;
  border-radius: 30px;
  background-color: rgba(199, 199, 199, 0.35);
  box-shadow: -2px 3px 15px 3px rgba(0, 0, 0, 0.5);
  float: right;
  justify-self: center;
  align-self: center;
  margin-left: 20%;
  margin-top: 2%;
}
.header-main .search-bar {
  grid-area: search;
  width: 68%;
  margin-left: 7%;
  margin-top: 7%;
  font-size: 17px;
  border: none;
  color: #33a3f5;
  background-color: rgba(199, 199, 199, 0);
  outline: none;
  font-family: "Quicksand", sans-serif;
}
.header-main .search-container button {
  grid-area: search;
  padding: 0.3% 0.5%;
  margin-top: 0.1%;
  margin-right: 1%;
  border: none;
  cursor: pointer;
  /* position: absolute; */
  background-color: rgba(199, 199, 199, 0);
  color: #33a3f5;
  
}

.search-icon {
  grid-area: search;
  border-left: #33a3f5 1.5px solid;
  padding-left: 5%;
  padding-bottom: 7%;
  padding-top: 1%;
  margin-top: 1%;
  font-size: 275%;
  margin-left: 10%;
  justify-self: center;
  align-self: center;
  margin-bottom: 5%;
}


</style>


