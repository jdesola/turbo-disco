<template>
  <div class="catCard">
    <img src="../assets/png/generic-cat2.png" alt="" id="profilePicture" />
    <h2 id="name">{{ cat.name }}</h2>
    <img src="../assets/png/cake.png" alt="" id="ageIcon" class="icon" />
    <p id="age">{{ cat.age }} Years</p>
    <img class="icon" id="hairIcon" src="../assets/png/brush.png" />
    <p id="hairType">{{ cat.hairLength }}</p>
    <i class="material-icons icon" id="jobIcon">work_outline</i>
    <p id="priorJobs">{{ cat.previousJobs }}</p>
    <i class="material-icons icon" id="experienceIcon">schedule</i>
    <p id="priorExperienceMonths">{{ cat.priorExperienceMonths }} Months</p>
    <p id="description">{{ cat.description }}</p>
    <div class="catCardActions">
      <button class="deleteButton">
        <i class="material-icons icon deleteButton" v-on:click="markCatAdopted"
          >delete</i
        >
      </button>
      <button class="featureButton">
        <i 
          class="material-icons icon featureButton"
          v-text="cat.featured ? 'star' : 'star_border'"
          v-on:click="toggleFeatureCat"
        ></i>
      </button>
    </div>
  </div>
</template>

<script>
import catService from "../services/CatService";

export default {
  name: "catCard",
  props: ["cat"],
  data() {
    return {
    };
  },
  
  methods: {
    markCatAdopted() {
      if (confirm("Are you sure you want to mark this cat as adopted? It will not appear on the website anymore.")) {
        this.cat.isAdopted = true;
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
      this.cat.isFeatured = !this.cat.isFeatured;
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
  },
};
</script>

<style scoped>
.catCard {
  margin-right: 5%;
  font-family: Quicksand;
  font-weight: 500;
  justify-items: center;
  align-items: center;
  font-size: 175%;
  display: grid;
  grid-template-columns: 25% 10% 20% 25% 20%;
  grid-template-areas:
    "pic ageIcon age . ."
    "pic hairIcon hair description ."
    "pic jobIcon title description ."
    "name experienceIcon months . catCardActions";
}



.icon {
  display: inline;
  align-self: center;
  justify-self: right;
  margin-right: 15%;
  color: #33a3f5;
  font-size: max-content;
}



#profilePicture {
  padding-top: 4%;
  grid-area: pic;
  width: 60%;
  height: auto;
  border-radius: 50%;
}

#name {
  padding-top: 4%;
  grid-area: name;
  color: #161fc2;
  font-weight: 700;
  line-height: 25%;
}

#age {
  grid-area: age;
  color: #c24a15;
  justify-self: left;
}

#ageIcon {
  grid-area: ageIcon;
  margin-right: 2%;
  margin-bottom: 3%;
  height: 60%;
  filter: invert(51%) sepia(97%) saturate(1488%) hue-rotate(180deg)
    brightness(90%) contrast(93%);
}

#hairType {
  grid-area: hair;
  color: #c24a15;
  justify-self: left;
}

#hairIcon {
  grid-area: hairIcon;
  margin-bottom: 3%;
  margin-right: 5%;
  height: 60%;
  filter: invert(51%) sepia(97%) saturate(1488%) hue-rotate(180deg)
    brightness(90%) contrast(93%);
}

#jobIcon {
  grid-area: jobIcon;
  font-size: 185%;
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
  font-size: 185%;
  margin-right: 3%;
  margin-bottom: 2%;
}
#priorExperienceMonths {
  grid-area: months;
  color: #c24a15;
  justify-self: left;
}

#description {
  grid-area: description;
  color: #c24a15;
  justify-self: left;
}

.deleteButton {
  justify-self: right;
  font-size: 125%;
  color: rgb(128, 1, 1);
  background-color: #161fc200;
  border: none;
  cursor: pointer;
}

.featureButton {
  justify-self: right;
  font-size: 125%;
  color: #161fc2;
  background-color: #161fc200;
  border: none;
  cursor: pointer;
}

.catCardActions {
  grid-area: catCardActions;
}
</style>