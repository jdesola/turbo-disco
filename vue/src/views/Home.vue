<template>
  <v-carousel
    cycle
    height="400"
    hide-delimiter-background
    show-arrows-on-hover
  >
    <v-carousel-item
      v-for="(slide, i) in slides"
      :key="i"
    >
      <v-sheet
        :color="colors[i]"
        height="100%"
      >
        <v-row
          class="fill-height"
          align="center"
          justify="center"
        >
          <div class="display-3">
            {{ slide }} Slide
          </div>
        </v-row>
      </v-sheet>
    </v-carousel-item>
  </v-carousel>
</template>

    <!-- <img class="image" v-bind:key ='image' v-for="(image, i) in images" :src="image" @click="onClick(i)"  @mouseover="hover = true"
      @mouseleave="hover = false">
    <span v-if="hover"> <br>This kitty is just so darn adorable! </span>
    <gallery :images="images"  @close="index = null"></gallery> -->


<script>
//  import StoryService from '@/services/StoryService';
  import Gallery from '@/components/Gallery';

  export default {
    components: Gallery,
    data () {
      return {
        colors: [
          'indigo',
          'warning',
          'pink darken-2',
          'red lighten-1',
          'deep-purple accent-4',
        ],
        slides: [
          'First',
          'Second',
          'Third',
          'Fourth',
          'Fifth',
        ],
      }
    },
  }
</script>
<style>

@import url('https://fonts.googleapis.com/css2?family=Quicksand&display=swap');

body {
  font-family: 'Quicksand', sans-serif;
}

p {
    font-family: 'Quicksand', sans-serif;
    font-weight: bold;
}

.subheading{
  font-family: 'Quicksand', sans-serif;
  font-style: initial;
}

.caption{
  font-family: 'Quicksand', sans-serif;
    font-style: initial;
}


.image {
  width: 100px;
  height: 100px;
  background-size: contain;
  cursor: pointer;
  margin: 10px;
  border-radius: 3px;
  color: pink;
}
.v-application{
  font-family: 'Quicksand', sans-serif;;
}
.v-card {
  font-family: 'Quicksand', sans-serif;
  transition: opacity .4s ease-in-out;
}

.v-card-title{
    font-family: 'Quicksand', sans-serif;
}

.v-card:not(.on-hover) {
  opacity: 0.0;
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