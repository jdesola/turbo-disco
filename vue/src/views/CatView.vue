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
        <p>{{ cat.description }}</p>
        <p>{{ cat.skills }}</p>
        <div class="ratings-container">
          <div class="ratings-header">Cat Stats</div>
          <div class="strength">
            Strength
            <v-rating
              empty-icon="mdi-paw-outline"
              full-icon="mdi-paw"
              hover
              length="5"
              size="20"
              value="3"
              color=#575A8F
              
            ></v-rating>
          </div>
          <div class="intelligence">
            Intelligence
            <v-rating
              empty-icon="mdi-paw-outline"
              full-icon="mdi-paw"
              hover
              length="5"
              size="20"
              value="3"
              color=#F8B06B
            ></v-rating>
          </div>
          <div class="speed">
            Speed
            <v-rating
              empty-icon="mdi-paw-outline"
              full-icon="mdi-paw"
              hover
              length="5"
              size="20"
              value="3"
              color=#C24A15 
            ></v-rating>
          </div>
          <div class="stamina">
            Stamina
            <v-rating
              empty-icon="mdi-paw-outline"
              full-icon="mdi-paw"
              hover
              length="5"
              size="20"
              value="3"
              color=#33A3F5
            ></v-rating>
          </div>
        </div>
      </v-expansion-panel-content>
    </v-expansion-panel>
  </v-expansion-panels>
</template>

<script>
// import catService from '../services/CatService'
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
    // retrieveCats() {
    //   catService.getCats().then(response => {
    //       this.$store.commit("SET_CAT_LIST", response.data);
    //     });
    // }
  },
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
.ratings-header{
  grid-area: ratings-header;
  text-align: center;
  font-weight: 500;
  border-bottom: 1px solid black;
  font-family: 'subscriber';
  font-size: 30px;
}
.strength{
  grid-area: strength;
   text-align: center;
}
.intelligence{
  grid-area: intelligence;
   text-align: center;
}
.speed{
  grid-area: speed;
   text-align: center;
}
.stamina{
  grid-area:stamina;
   text-align: center;
}
.stamina > .v-ratings > empty-icon{
  color:#33A3F5
}
.ratings-container {
  display: grid;
  grid-template-areas:
   'ratings-header ratings-header'
   'strength intelligence'
   'speed stamina';
  grid-row-gap:
   5px;
   justify-content: space-evenly;
   border: 1px solid #575A8F;
   border-radius: 10px;
   box-shadow: -1px 2px 8px 1px rgba(0, 0, 0, 0.5);
   width:35%;
  background: rgba(166,166,166,0.65);
   
}
</style>
