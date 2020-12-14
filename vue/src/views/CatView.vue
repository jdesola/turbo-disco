<template>
  <v-expansion-panels class="cat-list-container">
    <v-expansion-panel
      class="cat-card mb-3"
      v-for="cat in allCats"
      v-bind:key="cat.id"
      style="background: #c3c6f381"
    >
      <v-expansion-panel-header>
        <cat-card v-bind:cat="cat"> </cat-card>
      </v-expansion-panel-header>
      <v-expansion-panel-content>
        <div class="expansion-panel-grid">
        <p class ="cat-description">{{ cat.description }}</p>
        <p class="cat-skills">{{ cat.skills }}</p>
        <div class="ratings-container" >
          <div class="ratings-header">Cat Stats</div>
          <div class="strength">
            Strength
            <v-rating
              empty-icon="mdi-paw-outline"
              full-icon="mdi-paw"
              hover
              length="5"
              size="20"
              v-model="cat.strengthRating"
              color="#575A8F"
              background-color="#575A8F"
              v-on:input="saveRating(cat)"
            ></v-rating>
          </div>
          <div class="intelligence">
            Intelligence
            <v-rating
             v-on:input="saveRating(cat)"
              empty-icon="mdi-paw-outline"
              full-icon="mdi-paw"
              hover
              length="5"
              size="20"
              v-model="cat.intelligenceRating"
              color="#121FCA"
              background-color="#121FCA"
            ></v-rating>
          </div>
          <div class="speed">
            Speed
            <v-rating
             v-on:input="saveRating(cat)"
              empty-icon="mdi-paw-outline"
              full-icon="mdi-paw"
              hover
              length="5"
              size="20"
              v-model="cat.speedRating"
              color="#C24A15"
              background-color="#C24A15"
            ></v-rating>
          </div>
          <div class="stamina">
            Stamina
            <v-rating
            v-on:input="saveRating(cat)"
              empty-icon="mdi-paw-outline"
              full-icon="mdi-paw"
              hover
              length="5"
              size="20"
              v-model="cat.staminaRating"
              color="#33A3F5"
              background-color="#33A3F5"
            ></v-rating>
          </div>
        </div>
        </div>
      </v-expansion-panel-content>
    </v-expansion-panel>
  </v-expansion-panels>
</template>

<script>
import catService from '../services/CatService'
import CatCard from "../components/CatCard.vue";

export default {
  name: "Cats",
  components: { CatCard },
  data() {
    return {
      ratingsIcon: "<v-icon class='material-icons icon deleteButton'></v-icon>",
      map: {
        accessToken:
          "pk.eyJ1IjoibGl2dG9sbGUiLCJhIjoiY2tpbWF3NDA5MDdnMzJ0cGdpeGE0NWc2YyJ9.Iki6ohLmSdN_GzZTKtmvHg",
        lng: -73.984495,
        lat: 40.756027,
        zoom: 13,
        pitch: 20,
        bearing: 0,
      },
    };
  },
  props: [],
  computed: {
    resultListLength() {
      return this.$store.state.resultList.length;
    },
    allCats: function() {
      return this.$store.state.catList.filter(function(cat) {
        return !cat.adopted;
      });
    },
  },
  methods: {
     saveRating(cat) {
     catService
          .updateCat(cat)
          .then((response) => {
            if (response.status === 200) {
             
              this.$store.commit("UPDATE_RATINGS", cat);
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
    // retrieveCats() {
    //   catService.getCats().then(response => {
    //       this.$store.commit("SET_CAT_LIST", response.data);
    //     });
    // }
 
};
</script>

<style>
.cat-card {
  border-radius: 24px;
}

.cat-card:hover {
  box-shadow: -1px 2px 8px 1px rgba(0, 0, 0, 0.5);
}

.cat-card:nth-child(odd) {
  background-color: #c3c6f381;
}

/* #map-container {
  position: absolute;
  height: 100%;
  width: 100%;
} */
.ratings-header {
  grid-area: ratings-header;
  text-align: center;
  font-weight: 500;
  /* border-bottom: 1px solid black; */
  font-family: "subscriber";
  font-size: 30px;
  color: #c24a15;
}
.strength {
  grid-area: strength;
  text-align: center;
}
.intelligence {
  grid-area: intelligence;
  text-align: center;
}
.speed {
  grid-area: speed;
  text-align: center;
}
.stamina {
  grid-area: stamina;
  text-align: center;
}
.stamina > .v-ratings > empty-icon {
  color: #33a3f5;
}
.ratings-container {
  grid-area:ratings-card;
  display: grid;
  grid-template-areas:
    "ratings-header ratings-header"
    "strength intelligence"
    "speed stamina";

  grid-column-gap: 10%;
  justify-content: space-evenly;
  border: 1px solid #575a8f;
  border-radius: 10px;
  box-shadow: -1px 2px 8px 1px rgba(0, 0, 0, 0.5);
  width: 110%;
  background: whitesmoke; /* rgba(166, 166, 166, 0.65 */
  font-family: "subscriber";
  font-size: 15pt;
  padding-bottom: 5px;
  transition: 1s ease;
}
.ratings-container:hover{
-webkit-transform: scale(1.2);
-ms-transform: scale(1.2);
transform: scale(1.2);
transition: 1s ease;
}
.expansion-panel-grid{
  padding-top: 10px;
  padding-right:175px;
  justify-content: space-evenly;
display:grid;
grid-template-areas:
'cat-description auto auto ratings-card'
'cat-skills auto auto ratings-card'
 ;
}
.cat-skills{
  grid-area: cat-skills;
}
.cat-description{
  grid-area: cat-description;
}
</style>
