<template>
  <fixed-header class="header-container" >
     
    <nav class="header-main" v-on:click="resetList">
     
      <router-link class="cat-logo" v-bind:to="{name: 'home'}">
        <img  class="cat-logo" src="../assets/png/small-logo.png"/>
      </router-link>
      <router-link class="button featured-link featured d-flex align-center" v-on:click="resetList" v-bind:to="{name: 'featuredCats'}">
        <v-icon class="material-icons featuredIcon" size="80" > star </v-icon>
        <h1>Featured</h1>
      </router-link>
      <router-link class="button cats d-flex align-center" v-bind:to="{name: 'cats'}" v-on:click="resetList">
        <v-icon class="material-icons catsIcon" size="80" > pets </v-icon>
        <h1>Cats</h1>
      </router-link>
      <router-link class="button tools d-flex align-center" v-on:click="resetList" v-bind:to="{name: 'featuredCats'}">
        <v-icon class="material-icons toolsIcon" size="80" > build </v-icon>
        <h1>Tools</h1>
      </router-link>
      <div class="search-container">
        <input type="text" class="search-bar" v-model=searchTerm @keyup.enter="runSearch" placeholder="Search"/>
        
          <button class="d-flex align-center"> 
            <v-icon v-on:click="runSearch" class="material-icons search-icon" size="55" >search</v-icon>
          </button>
      </div>
       <div class="bar">
      </div>
      
    </nav>
   
  </fixed-header>
</template>

<script>
import FixedHeader from 'vue-fixed-header'

export default {
  name: "headerMain",
  components: { FixedHeader },
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
  methods: {
    resetList() {
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
  }

};
</script>

<style>

.header-main {
  display: grid;
  position: absolute;
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
  z-index: 2;
}

.bar {
  margin-top: 4.5%;
  position: absolute;
  border-radius: 50px;
   height:25%;
  width: 100%;
  background-color: rgb(255, 255, 255);
  z-index: -1;

}

.button {
  margin-top: -3%;
  margin-left: 7%;
  height: 110%;
  justify-self: left;
  align-self: center;
  box-shadow: -1px 2px 8px 1px rgba(0, 0, 0, 0.5);
}


.cat-logo {
  grid-area: logo;
  width: 100%;
  margin-top: 4%;
  margin-left: 8%;
  padding-bottom: -20%;
  justify-self: center;
}





.featured, .featuredIcon {
  grid-area: feat;
  color:  #161fc2 !important;
  text-decoration: none;
  background-color: #33a3f5;
  border-radius: 50px;
  justify-self: center;
  padding-left: 2%;
  padding-right: 5%;
  
}

.featured-link {
  margin-left: 20%;
}


.featured > h1 {
  padding-bottom: 5%;
  
}

.featuredIcon {
  padding-right: .5%;
  padding-left: 1%;
}

.cats, .catsIcon {
  grid-area: cats;
  color:  #f6af71 !important;
  text-decoration: none;
  background-color: #c24a15;
  border-radius: 50px;
  justify-self: center;
  padding-left: 2%;
  padding-right: 5%;
  
}

.cats > h1 {
  padding-bottom: 5%;
  
}

.catsIcon {
  padding-right: .5%;
  padding-left: 1%;
}


.tools, .toolsIcon {
  grid-area: tools;
  color:  #575a8f !important;
  text-decoration: none;
  background-color: #c3c6f3;
  border-radius: 50px;
  justify-self: center;
  padding-left: 2%;
  padding-right: 5%;
  margin-left: 0%;
  
}

.tools > h1 {
  padding-bottom: 5%;
  
}

.toolsIcon {
  padding-right: .5%;
  padding-left: 1%;
}

.search-container {
  grid-area: search;
  display: flex;
  margin-top: -3%;
  margin-left: 15%;
  height: 106%;
  width: 100%;
  border-radius: 50px;
  background-color:white;
  box-shadow: -1px 2px 8px 1px rgba(0, 0, 0, 0.5);
  float: right;
  justify-self: center;
  align-self: center;
  justify-content: center;
  
}
.search-bar {
  font-size: 75%;
  font-weight: 500;
  margin-left: 5%;
  margin-bottom: 1%;
  margin-right: 3%;
  padding-top: 5.5%;
  width: 70%;
  color: #33a3f5;
  background-color: rgba(199, 199, 199, 0);
    outline: none;
  line-height: 10% !important;
  font-family: "Quicksand", sans-serif;

}
.header-main > .search-container > button {
  grid-area: search;
  background-color: rgba(199, 199, 199, 0);
  color: #33a3f5;
  margin-top: 6%;
}

.search-icon {
  grid-area: search;
  border-left: #33a3f5 1.5px solid;
  color: #33a3f5 !important;
  align-self: flex-start;
  font-size: 100%;
  
}

input::placeholder {
  color: #33a3f5 !important;
  font-family: 'Subscriber';
  font-size: 175%;

  
}

</style>


