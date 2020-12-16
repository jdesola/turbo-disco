<template>
  <v-expansion-panels class="cat-list-container">
    <v-select label="Sort By" v-on:input="sortCats(sortBy)" v-model="sortBy" :items="sortOptions" ></v-select>
    <v-select label="Sort Order" v-on:input="sortCats(sortBy)" v-model="sortDirection" :items="sortDirections" ></v-select>
    <v-expansion-panel
      class="cat-card mb-3"
      v-for="cat in allCats"
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
import catService from '../services/CatService'
import CatCard from "../components/CatCard.vue";

export default {
  name: "Cats",
  components: { CatCard },
  data() {
    return {
      sortOptions: [{text: "Name", value: 'name'}, {text: "Age", value: 'age'}, {text: "Hair Type", value: 'hairLength'}, 
      {text: "Time at Last Job", value: 'priorExperienceMonths'}, {text: 'Prior Job Title', value: 'previousJobs'}, {text: 'Description', value: 'description'},
      {text: "Color", value: "color"}, {text: "Skills", value: "skills"}, {text: "Strength", value: "strengthRating"}, {text: "Intelligence", value: "intelligenceRating"}, {text: "Speed", value:"speedRating"}, {text: "Stamina", value: "staminaRating"}],
      sortBy: '',
      sortDirection: 'ASC',
       sortDirections: [{text: "Ascending", value: "ASC"}, {text: "Descending", value: 'DESC'}],
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
      },

      sortCats( ) {
      

        switch( this.sortBy ){
          case 'name' :
            this.sortCatsByName();
            break;
            case 'age':
              this.sortCatsByAge();
              break;
            case 'hairLength':
              this.sortCatsByHairLength();
              break;
            case 'priorExperienceMonths':
              this.sortCatsByExperienceMonths();
              break;
            case 'previousJobs':
              this.sortCatsByPreviousJobTitle();
              break;
            case 'description':
              this.sortCatsByDescription();
              break;
            case 'color':
              this.sortCatsByColor();
              break;
            case 'skills':
              this.sortCatsBySkills();
              break;
            case 'strengthRating':
              this.sortCatsByStrengthRating();
              break;
            case 'intelligenceRating':
              this.sortCatsByIntelligenceRating();
              break;
            case 'speedRating':
              this.sortCatsBySpeedRating();
              break;
            case 'staminaRating':
              this.sortCatsByStaminaRating();
              break;
        }
      },
      sortCatsByName(){
        this.allCats.sort( function(a, b ){
          if(this.sortDirection == 'ASC') {
            return ( ( a.name.toLowerCase() == b.name.toLowerCase() ) ? 0 : ( ( a.name.toLowerCase() > b.name.toLowerCase() ) ? 1 : -1 ) );
          }

          if( this.sortDirection == 'DESC' ){
             return ( ( a.name.toLowerCase() == b.name.toLowerCase() )) ? 0 : ( ( a.name.toLowerCase() < b.name.toLowerCase() ) ? 1 : -1);
          }
        }.bind(this));
      },
      sortCatsByAge(){
        this.allCats.sort( function( a, b){
          if( this.sortDirection == 'ASC' ){
            return parseInt( a.age ) > parseInt( b.age ) ? 1 : -1;
          }

          if( this.sortDirection == 'DESC' ){
            return parseInt( a.age ) < parseInt( b.age ) ? 1 : -1;
          }
        }.bind(this));
      },
      sortCatsByHairLength(){
        this.allCats.sort( function(a, b ){
          if(this.sortDirection == 'ASC') {
            return ( ( a.hairLength.toLowerCase() == b.hairLength.toLowerCase() ) ? 0 : ( ( a.hairLength.toLowerCase() > b.hairLength.toLowerCase() ) ? 1 : -1 ) );
          }

          if( this.sortDirection == 'DESC' ){
             return ( ( a.hairLength.toLowerCase() == b.hairLength.toLowerCase() )) ? 0 : ( ( a.hairLength.toLowerCase() < b.hairLength.toLowerCase() ) ? 1 : -1);
          }
        }.bind(this));
      },
      sortCatsByExperienceMonths(){
        this.allCats.sort( function( a, b){
          if( this.sortDirection == 'ASC' ){
            return parseInt( a.priorExperienceMonths ) > parseInt( b.priorExperienceMonths ) ? 1 : -1;
          }

          if( this.sortDirection == 'DESC' ){
            return parseInt( a.priorExperienceMonths ) < parseInt( b.priorExperienceMonths ) ? 1 : -1;
          }
        }.bind(this));
      },
      sortCatsByPreviousJobTitle(){
        this.allCats.sort( function(a, b ){
          if(this.sortDirection == 'ASC') {
            return ( ( a.previousJobs.toLowerCase() == b.previousJobs.toLowerCase() ) ? 0 : ( ( a.previousJobs.toLowerCase() > b.previousJobs.toLowerCase() ) ? 1 : -1 ) );
          }

          if( this.sortDirection == 'DESC' ){
             return ( ( a.previousJobs.toLowerCase() == b.previousJobs.toLowerCase() )) ? 0 : ( ( a.previousJobs.toLowerCase() < b.previousJobs.toLowerCase() ) ? 1 : -1);
          }
        }.bind(this));
      },
      sortCatsByDescription(){
        this.allCats.sort( function(a, b ){
          if(this.sortDirection == 'ASC') {
            return ( ( a.description.toLowerCase() == b.description.toLowerCase() ) ? 0 : ( ( a.description.toLowerCase() > b.description.toLowerCase() ) ? 1 : -1 ) );
          }

          if( this.sortDirection == 'DESC' ){
             return ( ( a.description.toLowerCase() == b.description.toLowerCase() )) ? 0 : ( ( a.description.toLowerCase() < b.description.toLowerCase() ) ? 1 : -1);
          }
        }.bind(this));
      },
      sortCatsByColor(){
        this.allCats.sort( function(a, b ){
          if(this.sortDirection == 'ASC') {
            return ( ( a.color.toLowerCase() == b.color.toLowerCase() ) ? 0 : ( ( a.color.toLowerCase() > b.color.toLowerCase() ) ? 1 : -1 ) );
          }

          if( this.sortDirection == 'DESC' ){
             return ( ( a.color.toLowerCase() == b.color.toLowerCase() )) ? 0 : ( ( a.color.toLowerCase() < b.color.toLowerCase() ) ? 1 : -1);
          }
        }.bind(this));
      },
      sortCatsBySkills(){
        this.allCats.sort( function(a, b ){
          if(this.sortDirection == 'ASC') {
            return ( ( a.skills.toLowerCase() == b.skills.toLowerCase() ) ? 0 : ( ( a.skills.toLowerCase() > b.skills.toLowerCase() ) ? 1 : -1 ) );
          }

          if( this.sortDirection == 'DESC' ){
             return ( ( a.skills.toLowerCase() == b.skills.toLowerCase() )) ? 0 : ( ( a.skills.toLowerCase() < b.skills.toLowerCase() ) ? 1 : -1);
          }
        }.bind(this));
      },
      sortCatsByStrengthRating(){
        this.allCats.sort( function( a, b){
          if( this.sortDirection == 'ASC' ){
            return parseInt( a.strengthRating ) > parseInt( b.strengthRating ) ? 1 : -1;
          }

          if( this.sortDirection == 'DESC' ){
            return parseInt( a.strengthRating ) < parseInt( b.strengthRating ) ? 1 : -1;
          }
        }.bind(this));
      },
       sortCatsByIntelligenceRating(){
        this.allCats.sort( function( a, b){
          if( this.sortDirection == 'ASC' ){
            return parseInt( a.intelligenceRating ) > parseInt( b.intelligenceRating ) ? 1 : -1;
          }

          if( this.sortDirection == 'DESC' ){
            return parseInt( a.intelligenceRating ) < parseInt( b.intelligenceRating ) ? 1 : -1;
          }
        }.bind(this));
      },
       sortCatsBySpeedRating(){
        this.allCats.sort( function( a, b){
          if( this.sortDirection == 'ASC' ){
            return parseInt( a.speedRating ) > parseInt( b.speedRating ) ? 1 : -1;
          }

          if( this.sortDirection == 'DESC' ){
            return parseInt( a.speedRating ) < parseInt( b.speedRating ) ? 1 : -1;
          }
        }.bind(this));
      },
      
       sortCatsByStaminaRating(){
        this.allCats.sort( function( a, b){
          if( this.sortDirection == 'ASC' ){
            return parseInt( a.staminaRating ) > parseInt( b.staminaRating ) ? 1 : -1;
          }

          if( this.sortDirection == 'DESC' ){
            return parseInt( a.staminaRating ) < parseInt( b.staminaRating ) ? 1 : -1;
          }
        }.bind(this));
      },
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
  border: none;
}

.cat-card:hover {
  box-shadow: -1px 2px 8px 1px rgba(0, 0, 0, 0.5);
}

.cat-list-container {
  margin-top: 8%;
  position: static;
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
  background: whitesmoke; /* rgba(166, 166, 166, 0.65 */
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
grid-template-columns: 2% 23% 6% 29% 26.5% 14.5%;
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
