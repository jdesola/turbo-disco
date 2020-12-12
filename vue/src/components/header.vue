<template>
  <div class="header-container" >
    
    <nav class="header-main" v-on:click="resetList">
      <router-link class="cat-logo" v-bind:to="{name: 'home'}">
        <img  class="cat-logo" src="../assets/png/small-logo.png"/>
      </router-link>
      <router-link class="button featured" v-on:click="resetList" v-bind:to="{name: 'featuredCats'}">
        <img class="button fav" src="../assets/webp/Featured-Button.webp"/>
      </router-link>
      <router-link class="button cats" v-bind:to="{name: 'cats'}" v-on:click="resetList">
        <img class="button cats" src="../assets/webp/cats-button.webp" />
      </router-link>
      <a href="" class="button tools" v-on:click="resetList"
        ><img class="button tools" src="../assets/webp/admin-tools-button.webp"
      /></a>
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
 
  
    
  }

};
</script>

<style>


.header-main {
  display: grid;
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

.featured {
  grid-area: feat;
}

.cats {
  grid-area: cats;
  justify-self: center;
}

.tools {
  grid-area: tools;
  margin-left: 3%;
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


