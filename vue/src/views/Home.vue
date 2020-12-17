<template>
  <div class="adoptableCatGallery">
    <v-carousel
      class="images"
      cycle
      height="800"
      hide-delimiter-background
      show-arrows-on-hover
    >
      <v-carousel-item v-for="(slide, i) in slides" :key="i" :src="slide" @mouseenter="hover=true" aspect-ratio="16/9" :height="max-content" @mouseleave="hover=false" >
        <!-- <v-sheet :color="colors[i]" height="100%"> -->
          <v-row class="fill-height" align="center" justify="center" >
            <div class="display-3" >
              <v-fade-transition>
                <v-overlay v-if="hover" absolute color=#036358>
                  <v-btn color=#FFFFFF>
                    <router-link 
                    v-bind:to="{name: 'cats'}">
                    Catch this cat!
                    </router-link>
                  </v-btn>
                </v-overlay>
              </v-fade-transition>
            </div>
          </v-row>
        <!-- </v-sheet> -->
      </v-carousel-item>
    </v-carousel>
  </div>
</template>

    <!-- <img class="image" v-bind:key ='image' v-for="(image, i) in images" :src="image" @click="onClick(i)"  @mouseover="hover = true"
      @mouseleave="hover = false">
    <span v-if="hover"> <br>This kitty is just so darn adorable! </span>
    <gallery :images="images"  @close="index = null"></gallery> -->


<script>
import firebase from 'firebase';

export default {
  name: "Home",
  
  data() {
    return {
      overlay: false,
      hover: false,
      colors: [
        "indigo",
        "warning",
        "pink darken-2",
        "red lighten-1",
        "deep-purple accent-4",
      ],
      slides: [],
    };
  },
  methods: {
  getImages() {
    
     this.$store.state.catList.forEach(cat => { 
       this.setImageUrl(cat.imageName);
  })
  },
  async setImageUrl(catImageName) {
      if (catImageName != null){
        try {
                const imageName = catImageName;
                const storageRef = firebase.storage().ref();
                const imageRef = storageRef.child(`${imageName}`);

                let imageUrl = await imageRef.getDownloadURL();
                this.slides.push(imageUrl);
            } catch (error) {
                console.log(error);
            }
  }
  }
  },
  created() {
    document.title = 'Home';
    this.getImages();
  },
};
</script>
<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Quicksand&display=swap");

body {
  font-family: "Quicksand", sans-serif;
}

p {
  font-family: "Quicksand", sans-serif;
  font-weight: bold;
}

.adoptableCatGallery {
  margin-top: 12%;
  /* padding-left: 77%; */
  width: 50%;
  align-self: center;
}

v-btn{
  margin-right: 50px;
}
a{
  color: white;
}
</style>