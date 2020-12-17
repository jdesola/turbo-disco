<template>
  <div class="dumb-fucking-bitch">
    <v-carousel
      class="images"
      cycle
      height="400"
      hide-delimiter-background
      show-arrows-on-hover
    >
      <v-carousel-item v-for="(slide, i) in slides" :key="i" @mouseenter="hover=true" @mouseleave="hover=false">
        <v-sheet :color="colors[i]" height="100%">
          <v-row class="fill-height" align="center" justify="center">
            <div class="display-3" >
              {{ slide }} boobs
              <v-fade-transition>
                <v-overlay v-if="hover" absolute color=#036358>
                  <v-btn color=#FFFFFF> 
                    <a href="http://localhost:8081/cats">CATCH a cat now! 
                    </a>
                  </v-btn>
                </v-overlay>
              </v-fade-transition>
            </div>
          </v-row>
        </v-sheet>
      </v-carousel-item>
    </v-carousel>
  </div>
</template>

    <!-- <img class="image" v-bind:key ='image' v-for="(image, i) in images" :src="image" @click="onClick(i)"  @mouseover="hover = true"
      @mouseleave="hover = false">
    <span v-if="hover"> <br>This kitty is just so darn adorable! </span>
    <gallery :images="images"  @close="index = null"></gallery> -->


<script>

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
      slides: ["Penguin", "Ass", "Titty", "big", "chile anyways"],
    };
  },
  created() {
    document.title = 'Home';
  },
};
</script>
<style>
@import url("https://fonts.googleapis.com/css2?family=Quicksand&display=swap");

body {
  font-family: "Quicksand", sans-serif;
}
template > v-carousel {
  padding-top: 25%;
}
p {
  font-family: "Quicksand", sans-serif;
  font-weight: bold;
}

.dumb-fucking-bitch {
  margin-top: 15%;
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
<!--// images: [
      //   "https://placekitten.com/801/800",
      //   "https://placekitten.com/802/800",
      //   "https://placekitten.com/803/800",
      //   "https://placekitten.com/804/800",
      //   "https://placekitten.com/805/800",
      //   "https://placekitten.com/806/800",
      //   "https://placekitten.com/807/800",
      //   "https://placekitten.com/808/800",
      //   "https://placekitten.com/809/800",
      //   "https://placekitten.com/810/800",
      // ], -->