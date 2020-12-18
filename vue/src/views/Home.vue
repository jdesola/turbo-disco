<template>
  <div class="adoptableCatGallery">
    <h1>Welcome to CATCH!</h1>
    <h2>See some of our available cats in the gallery below!</h2>
    <v-carousel
      class="images"
      cycle
      
      interval="3000"
      hide-delimiter-background

      show-arrows-on-hover
    >
      <v-carousel-item class="imageContainer" v-for="(slide, i) in slides" :key="i" :src="slide" @mouseenter="hover=true"  @mouseleave="hover=false" :aspect-ratio="2">
          <v-row class="fill-height" align="center" justify="center" >
            <div class="display-3" >
              <v-fade-transition>
                <v-overlay v-if="hover" absolute color=#036358>
                  <v-btn color=#FFFFFF background-color=#FFFFFF>
                    <router-link 
                    v-bind:to="{name: 'cats'}">
                    Catch this cat!
                    </router-link>
                  </v-btn>
                </v-overlay>
              </v-fade-transition>
            </div>
          </v-row>
      </v-carousel-item>
    </v-carousel>
    <cat-facts class="facts"/>
  </div>
</template>

<script>
import firebase from 'firebase';
import CatFacts from '@/components/CatFacts';
export default {
  components: {CatFacts},
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
h2 {
  font-family: 'Quicksand';
  text-align: center;
  font-weight: 700;
  margin-bottom: 1%;
}

h1 {
  margin-top: 7%;
  margin-bottom: 1%;

  text-align: center;
  font-size: 500%;
  font-weight: 800;
  font-family: 'Subscriber';
  color: #c24a15;
  letter-spacing: 2px;
}



.adoptableCatGallery {
  padding-top: 5%;
  width: 50%;
  align-self: center;
}


.facts{
position: relative;
font-family:"Quicksand", sans-serif;
font-weight: bold;
font-size: 150%;
z-index: 2;
text-align: center;

}

</style>