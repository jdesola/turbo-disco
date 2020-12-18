<template>
  <v-expansion-panels class="cat-list-container">
  
    <v-expansion-panel
      class="cat-card mb-3"
      v-for="cat in featuredCats"
      v-bind:key="cat.id"
      style="background: #c3c6f3"
    >
      <v-expansion-panel-header>
        <cat-card v-bind:cat="cat"> </cat-card>
      </v-expansion-panel-header>
      <v-expansion-panel-content>
        <div class="expansion-panel-grid">
          <div class="info-container">
          <div class="cat-description"> <v-subheader>Description: </v-subheader>
        <p class ="cat-description">{{ cat.description }}</p></div>
          <div class="cat-skills"> 
            <v-subheader color="#121FCA">Skills: </v-subheader>  <p class="cat-skills">{{ cat.skills }}</p></div>
           
          <div class="cat-color"> 
            <v-subheader >Color: </v-subheader>  <p class="cat-color">{{ cat.color }}</p></div>
          </div>
        <div class="ratings-container" >
          <div class="ratings-header">Cat Stats</div>
          <div class="strength">
            Strength
            <v-rating
              empty-icon="mdi-paw-outline"
              full-icon="mdi-paw"
              hover
              length="5"
              size="25"
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
              size="25"
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
              size="25"
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
              size="25"
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
import CatCard from "@/components/CatCard.vue";
export default {
  name: "FeaturedCats",
  components: { CatCard },
  data() {
    return {};
  },
  created() {
    document.title = 'Featured Cats';
  },
  computed: {
    featuredCats: function () {
      return this.$store.state.catList.filter(function (cat) {
        if (cat.featured && !cat.adopted){
        return cat;
        }
      });
    },
  },
};
</script>

<style scoped>
.sortActions {
  position: static;
  margin-top: 2%;
  width: 100%;
  height: 2%;
  font-size: 200% !important;
  font-weight: 800 !important;
  background-color: whitesmoke;
  border-radius: 5px;
  margin-bottom: 1%;
box-shadow: -1px 2px 8px 1px rgba(0, 0, 0, 0.25);
}

.sortActions > .sortBy {
  margin-right: 5%;
  margin-left: 2%;
  justify-self: flex-end;
}

.sortActions > .sortOrder {
  margin-right: 2%;
}
.cat-card {
  border-radius: 24px;
  border: none;
  
}

.cat-card:hover {
  box-shadow: -1px 2px 8px 1px rgba(0, 0, 0, 0.5);
}

.cat-list-container {
  margin-top: 10%;
  position: static;
}

.ratings-header {
  grid-area: ratings-header;
  text-align: center;
  font-weight: 500;
  font-family: "subscriber";
  font-size: 35px;
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
  width: 100%;
  background: whitesmoke; 
  font-family: "subscriber";
  font-size: 18pt;
  padding-bottom: 5px;
  transition: 1s ease;
}
.ratings-container:hover, .info-container:hover{
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
grid-template-columns: 1% 23% 7% 11% 26.5% 14.5%;
grid-template-areas:
'. info-container auto auto ratings-card .'
'. info-container auto auto ratings-card .'
 ;
}
.cat-skills, .cat-description, .cat-color{
  
  font-size: 115%;
  font-family: 'Subscriber', sans-serif;
  margin-left: 10%;
}

.cat-skills {
  grid-area: cat-skills;
  
}

.cat-skills > p, .cat-description > p, .cat-color > p{
  font-size: 100%;
  color:  rgb(65, 63, 63);
  font-family: "Quicksand";
  font-weight: 600;
  padding-top: 2% ;
}
.cat-description  {
  grid-area: cat-description;
}

.cat-color{
  padding-top: 2%;
  grid-area: cat-color;
}

.info-container {
  grid-area: info-container;
  display: grid;
  grid-column-gap: 10%;
  border: 1px solid #575a8f;
  border-radius: 10px;
  box-shadow: -1px 2px 8px 1px rgba(0, 0, 0, 0.5);
  width: 100%;
  background: whitesmoke;
  padding-bottom: 5px;
  transition: 1s ease;
   grid-template-areas:
    "cat-color"
    "cat-description"
    "cat-skills"
 ;
}
</style>