<template>
  <div>
    <v-card class="successStoriesCard" elevation="2" >
      <v-card-title id="name">{{ this.story.catName }}</v-card-title>
        <v-avatar class="catPicture" size="250" >
      <v-img aspect-ratio="1.5"  v-bind:src="(this.imageUrl === null) ? `${this.genericPath}` : `${this.imageUrl}`"></v-img>

    </v-avatar>
      <v-card-text class="cardText"
        >Adopted By: {{ this.story.adopterName }}</v-card-text
      >
      <v-card-text class="cardText"
        >Date Adopted: {{ this.story.dateAdopted }}</v-card-text
      >
      <v-card-actions>
        <v-btn id="readStoryBtn" v-on:click="show = !show" text>
          Click to Read Story
        </v-btn>

        <v-spacer></v-spacer>

        <v-btn icon @click="show = !show">
          <v-icon>{{ show ? "mdi-chevron-up" : "mdi-chevron-down" }}</v-icon>
        </v-btn>
      </v-card-actions>

      <v-expand-transition>
        <div v-show="show">
          <v-divider></v-divider>

          <v-card-text class="cardText">{{
            this.story.successStory
          }}</v-card-text>
        </div>
      </v-expand-transition>
    </v-card>
  </div>
</template>

<script>
import firebase from 'firebase'
export default {
  

  name: "successStories",
  props: ["story"],
  data() {
    return {
      show: false,
      imageUrl: null,
      genericPath: require('../assets/png/generic-cat2.png'),
    };
  },
  methods: {
    // getCatImageName() {
    //   const catForPic = this.$store.state.catList.find( cat => {cat.id == this.story.catId});
    //   this.imageName = catForPic.imageName;
    // },
    async setImageUrl() {
      if (this.catImageName != null){
        try {
                const imageName = this.catImageName;
                const storageRef = firebase.storage().ref();
                const imageRef = storageRef.child(`${imageName}`);

                this.imageUrl = await imageRef.getDownloadURL();
            } catch (error) {
                console.log(error);
            }
      }
  }
  },
   computed: {

    catImageName() {
      const storyCat = this.$store.state.catList.find( c => c.id === this.story.catId);
     
      return storyCat.imageName;
      

    },
   },
  created() {
 
    this.setImageUrl();

  }

  };
</script>

<style>
.successStoriesCard {
  margin-left: 10%;
  margin-right: 10%;
  margin-bottom: 0.77%;
  text-decoration-color: black;
  font-family: Quicksand;
}
#name {
  font-family: "subscriber";
  font-size: 300%;
  color: #161fc2;
  margin-bottom: 1%;
}
#readStoryBtn {
  color: #33a3f5;
}
.cardText {
  font-size: 140%;
}

.catPicture {
  margin-left: 5%;

}


.catPicture > v-img {
  height: auto;
  width: 100%;
}
</style>