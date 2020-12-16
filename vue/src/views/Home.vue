<template>
  <v-container>
    <v-row>
      <v-col col="12">
        <v-carousel>
          <v-carousel-item
            v-for="(item, i) in items"
            :key="i"
            :src="item.src"
            reverse-transition="fade-transition"
            transition="fade-transition"
            @click='this.retrieveStories()'
          >
            <v-hover v-slot="{ hover }">
              <v-card
                :elevation="hover ? 12 : 2"
                :class="{ 'on-hover': hover }"
              >
                <v-img :src="item.img" height="225px">
                  <v-card-title class="title white--text">
                    <v-row
                      class="fill-height flex-column"
                      justify="space-between"
                    >
                      <p class="mt-4 subheading text-left">
                        {{ item.title }}
                      </p>

                      <div>
                        <p
                          class="subheading"
                        >
                          {{ item.text }}
                        </p>
                        <p
                          class="caption"
                        >
                          {{ item.subtext }}
                        </p>
                      </div>    
                    </v-row>
                  </v-card-title>
                </v-img>
              </v-card>
            </v-hover>
          </v-carousel-item>
        </v-carousel>
      </v-col>
    </v-row>
  </v-container>
</template>

    <!-- <img class="image" v-bind:key ='image' v-for="(image, i) in images" :src="image" @click="onClick(i)"  @mouseover="hover = true"
      @mouseleave="hover = false">
    <span v-if="hover"> <br>This kitty is just so darn adorable! </span>
    <gallery :images="images"  @close="index = null"></gallery> -->


<script>
 import StoryService from '@/services/StoryService';
 import Gallery from '@/components/Gallery';

export default {
  name: "home",
  components: StoryService, Gallery,
  methods: {
    retrieveStories() {
        StoryService.getStories().then(response => {
        this.$store.commit('SET_STORY_LIST', response.data);
        })
      }
    },
    onClick(i) {
      this.index = i;
  },
  data: function () {
    return {
      items: [
        {
          src: "https://placekitten.com/801/800",
          title: 'Gary',   
          text: 'A New Start',
          subtext: 'Gary loves his new home. Ever since Nancy picked him up at the shelter, he has been rocking it at his new job!'    
        },
        {
          src: "https://placekitten.com/802/800",
        },
        {
          src: "https://placekitten.com/805/800",
        },
        {
          src: "https://placekitten.com/806/800",
        },
        {
          src: "https://placekitten.com/807/800",
        },
      ],
      // images: [
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
      // ],
      index: null,
    };
  },
};
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
<!-- -->