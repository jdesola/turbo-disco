<template >
  <div class="catCard" >
    <v-avatar class="profilePicture" size="300">
      <img contain v-bind:src="(this.imageUrl === null) ? `${this.genericPath}` : `${this.imageUrl}`" />

    </v-avatar>
    
    <h2 id="name">{{ cat.name }}</h2>
    <i class="material-icons-outlined icon" id="ageIcon">cake</i>
    <p id="age">{{ cat.age }} Years</p>
    <i class="material-icons icon" id="hairIcon">straighten</i>
    <p id="hairType">{{ cat.hairLength }}</p>
    <i class="material-icons icon" id="jobIcon">work_outline</i>
    <p id="priorJobs">{{ cat.previousJobs }}</p>
    <i class="material-icons icon" id="experienceIcon">schedule</i>
    <p id="priorExperienceMonths">{{ cat.priorExperienceMonths }} Months</p>
  
     <vue-mapbox-map 
          id="map-container"
          access-token="pk.eyJ1IjoibGl2dG9sbGUiLCJhIjoiY2tpbWF3NDA5MDdnMzJ0cGdpeGE0NWc2YyJ9.Iki6ohLmSdN_GzZTKtmvHg"
          layers='cat-locations'
          :interactive="true"
          :lat='scene.lat'
          :lng='scene.lng'
           pitch="5"
           bearing="0"
          zoom="13"
          mapStyle="mapbox://styles/livtolle/ckimct6b505dc18k62mdbx7i8"
          @click.stop
        ></vue-mapbox-map>
    <div class="catCardActions" @click.stop v-if="userLoggedIn">
      
      <button class="deleteButton" >
        <v-icon class="material-icons icon deleteButton"  v-on:click="markCatAdopted "
          >delete</v-icon
        >
      </button>
      <button class="featureButton" >
        <v-icon 
          class="material-icons icon featureButton"
          v-text="this.cat.featured ? 'star' : 'star_border'"
          v-on:click="toggleFeatureCat"
        ></v-icon>
      </button>
    </div>
  </div>
</template>

<script>
import firebase from 'firebase'
import catService from "../services/CatService";
import VueMapboxMap from "vue-mapbox-map";

export default {
  name: "catCard",
  props: ["cat"],
  data() {
    return {
      // scene: {
      //   lat: "",
      // lng: "",
      // },
      imageUrl: null,
      
      genericPath: require('../assets/png/generic-cat2.png'),
      
    };
  },
  components: { VueMapboxMap },
  computed: {

    scene() {
      const findLocation = this.$store.state.locationList.find( l => l.id === this.cat.locationId);
     
      return {lat: findLocation.latitude, lng: findLocation.longitude};
      

    },
    userLoggedIn() {
      let isLoggedIn = false;
      if(this.$store.state.token != '') {
        isLoggedIn = true;}
        return isLoggedIn;
      }
    },
    
    //  latitude() {
    //   return this.cat.catLocation.latitude;
    //  },
    //  longitude() {
    //    return this.cat.catLocation.longitude;
    //  }
  methods: {
    markCatAdopted() {
          
       
      if (confirm("Are you sure you want to mark this cat as adopted? It will not appear on the website anymore.")) {
        this.cat.adopted = true;
        catService
          .updateCat(this.cat)
          .then((response) => {
            if (response.status === 200) {
              alert("Cat adopted successfully");
              this.$store.commit("ADOPT_CAT", this.cat);
            }
          })
          .catch((error) => {
            if (error.response) {
              this.errorMsg = `Error deleting cat.  ${error.response.status} - ${error.response.statusText}`;
            } else if (error.request) {
              this.errorMsg = "Could not connect to server";
            } else {
              this.errorMsg = "Unexpected error";
              console.error(error);
            }
          });
      }
    },
    toggleFeatureCat() {
      this.cat.featured = !this.cat.featured;
      catService
        .updateCat(this.cat)
        .then((response) => {
          if (response.status === 200) {
            this.$store.commit("TOGGLE_FEATURE_CAT", this.cat);
          }
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg = `Error featuring cat.  ${error.response.status} - ${error.response.statusText}`;
          } else if (error.request) {
            this.errorMsg = "Could not connect to server";
          } else {
            this.errorMsg = "Unexpected error";
            console.error(error);
          }
        });
    },
    async setImageUrl() {
      if (this.cat.imageName != null){
        try {
                const imageName = this.cat.imageName;
                const storageRef = firebase.storage().ref();
                const imageRef = storageRef.child(`${imageName}`);

                this.imageUrl = await imageRef.getDownloadURL();
            } catch (error) {
                console.log(error);
            }
      }
    },
    setAdmin() {
      this.$store.state.user.authorities.forEach(role => {
        if(role.name == 'ROLE_ADMIN') {
          this.isAdmin = true;
        }
      });
    },
    
  },
    created() {
      this.setImageUrl();
      this.setAdmin();
    }
};
</script>

<style scoped>
.catCard {
  
  font-family: Quicksand;
  font-weight: 500;
  justify-items: center;
  align-items: center;
  font-size: 175%;
  display: grid;
  grid-template-columns: 25% 10% 20% 25% 20%;
  grid-template-rows: 25% 25% 25% 25%;
  grid-template-areas:
    "pic ageIcon age description  ."
    "pic hairIcon hair description ."
    "pic jobIcon title description ."
    "name experienceIcon months description  catCardActions";
}



.icon {
  font-size: 185%;
  display: inline;
  align-self: center;
  justify-self: right;
  margin-right: 15%;
  color: #33a3f5;
  margin-right: 3%;
  padding-bottom: 6%;
}



.profilePicture {
  margin-top: 10%;
  grid-area: pic;
  /* width: 60%;
  height: auto; */
}

.profilePicture > img {
  height: 100%;
  width: auto;
}

#name {
  padding-top: 4%;
  grid-area: name;
  color: #161fc2;
  font-weight: 700;
  line-height: 25%;
  margin-bottom: 5%;
}

#age {
  grid-area: age;
  color: #c24a15;
  justify-self: left;
}

#ageIcon {
  grid-area: ageIcon;
  /* margin-right: 2%;
  margin-bottom: 3%;
  height: 60%;
  filter: invert(51%) sepia(97%) saturate(1488%) hue-rotate(180deg)
    brightness(90%) contrast(93%); */
}

#hairType {
  grid-area: hair;
  color: #c24a15;
  justify-self: left;
}

#hairIcon {
  grid-area: hairIcon;
  /* margin-bottom: 3%;
  margin-right: 5%;
  height: 60%;
  filter: invert(51%) sepia(97%) saturate(1488%) hue-rotate(180deg)
    brightness(90%) contrast(93%); */
}

#jobIcon {
  grid-area: jobIcon;
  
  margin-right: 4%;
  margin-bottom: 1%;
}

#priorJobs {
  grid-area: title;
  color: #c24a15;
  justify-self: left;
}

#experienceIcon {
  grid-area: experienceIcon;
  
}
#priorExperienceMonths {
  grid-area: months;
  color: #c24a15;
  justify-self: left;
}

/* .map {
  position: relative;
  grid-area: description;
  color: #c24a15;
 
  
} */

#map-container {
  grid-area: description;
  position: relative;
   /* position: absolute; */
  height: 100%;
  width: 100%;
  border-radius: 14px;
}

.deleteButton {
  justify-self: right;
  font-size: 125%;
  color: rgb(128, 1, 1);
 
  border: none;
  cursor: pointer;
}

.featureButton {
  justify-self: right;
  font-size: 125%;
  color: #161fc2;

  border: none;
  cursor: pointer;
}

.catCardActions {
  grid-area: catCardActions;
  justify-self: right;
}
</style>