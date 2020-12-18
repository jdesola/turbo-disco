<template>
  <fixed-header class="header-container" >
     
    <nav class="header-main" v-on:click="resetList">
     
      <router-link class="cat-logo" v-bind:to="{name: 'home'}">
        <img  class="cat-logo" src="../assets/png/small-logo.png"/>
      </router-link>
      <router-link class="button featured-link featured d-flex align-center" v-on:click="resetList" v-bind:to="{name: 'featuredCats'}">
        <v-icon class="material-icons featuredIcon icon" size="80" > star </v-icon>
        <h1>Featured</h1>
      </router-link>
      <router-link class="button cats d-flex align-center cats-link" v-bind:to="{name: 'cats'}" v-on:click="resetList">
        <v-icon class="material-icons catsIcon icon" size="80" > pets </v-icon>
        <h1>Cats</h1>
      </router-link>
       <router-link class="button stories d-flex align-center success-link" v-bind:to="{name: 'SuccessStoriesView'}" v-on:click="resetList">
        <v-icon class="material-icons storiesIcon icon" size="80" > emoji_events </v-icon>
        <h1>Stories</h1>
      </router-link>
      <router-link class="button tools d-flex align-center admin-link" v-on:click="resetList" v-bind:to="{name: 'tools'}" >
        <v-icon class="material-icons toolsIcon icon" size="80" v-text="(userLoggedIn) ? 'build' : 'login'">  </v-icon>
        <h1 v-text="(userLoggedIn) ? 'Tools' : 'Login'"></h1>
      </router-link>
      <div class="search-container">
        <input type="text" class="search-bar" v-model=searchTerm @keyup.enter="runSearch" placeholder="Search"/>
        
          <button class="d-flex align-center"> 
            <v-icon v-on:click="runSearch" class="material-icons search-icon icon" size="55" >search</v-icon>
          </button>
      </div>
       <router-link class="logoutBtn"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
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
    userLoggedIn() {
      let isLoggedIn = false;
      if(this.$store.state.token != '') {
        isLoggedIn = true;}
        return isLoggedIn;
      }
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

<style scoped>
.header-container {
  position: absolute;
  top: 0;
}

.header-main {
  display: grid;
  position: absolute;
  top: 0;

  font-family: 'Subscriber';
  font-size: 350%;
  grid-template-columns: 2% 12% 15% 15% 15% 15% 10% 16%;
  grid-template-rows: 33% 34% 33%;
  grid-template-areas:
    ". logo . . . . . ."
    ". logo feat cats success tools search logout"
    ". logo . . . . . .";
  justify-content: space-evenly;
  
  z-index: 0;
}

.logoutBtn{
  grid-area: logout;
  justify-self: right;
  margin-top: -4%; 
}

.bar {
  
  position: absolute;
  top:0;
   height:35%;
  width: 200%;
  background-color: rgb(255, 255, 255);
  z-index: -1;
  margin-top: 3%;

}

.button {
  margin-top: -6%;
  /* margin-left: 7%; */
  height: 110%;
  justify-self: left;
  align-self: center;
  border-radius: 50px;
  justify-self: center;
  box-shadow: -1px 2px 8px 1px rgba(0, 0, 0, 0.5);
  text-decoration: none;
  padding-left: 2%;
  padding-right: 5%;
}


.cat-logo {
  grid-area: logo;
  width: 95%;
  margin-top: 2%;
  margin-left: 5%;
  padding-bottom: -20%;
  justify-self: center;
}


.success {
  grid-area: success;
}


.featured, .featuredIcon {
  grid-area: feat;
  color:  #161fc2 !important;
  background-color: #33a3f5;
   
}

 .featuredIcon {
   margin-top: 4%;
   margin-right: 0.5%;
 }

.featured > h1 {
  padding-bottom: 5%;
  
}

.featured-link {
  margin-left: 35%; 
}


.icon {
  padding-right: .5%;
  padding-left: .5%;
  background-color: transparent !important;
}

.cats, .catsIcon {
  grid-area: cats;
  color:  #f6af71 !important;
  background-color: #c24a15;
  
  
}

.cats > h1 {
  padding-bottom: 5%;
  
}


.cats-link {
  margin-left: 35%;
}


.tools, .toolsIcon {
  grid-area: tools;
  color:  #575a8f !important;
  text-decoration: none;
  background-color: #c3c6f3;

  
}


.stories, .storiesIcon {
  grid-area: success;
  color:  #facf67 !important;
  background-color: #3eb0c7 ;
}

.storiesIcon {
  padding-bottom: 2%;
}

.success-link > h1{
  padding-bottom: 4%;
  margin-left: -1%;
}

.tools > h1 {
  padding-bottom: 5%;
  margin-top: 0%;
  
}

.toolsIcon {
  margin-top: 6%;
}

.success-link {

  margin-left: 30%;
}

.admin-link {
  margin-left: 25%;

}


.search-container {
  grid-area: search;
  display: flex;
  margin-top: -9%;
  margin-left: 115%;
  height: 112%;
  width: 110%;
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
  margin-bottom: 0%;
  margin-right: 3%;
  padding-top: 3.5%;
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
  margin-top: 8%;
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


