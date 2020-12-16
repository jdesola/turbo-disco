<template>
  <v-container>
    <v-row>
      <v-col col="12">
        <v-carousel>
          <v-carousel-item
            v-for="(item,i) in items"
            :key="i"
            :src="item.src"
            reverse-transition="fade-transition"
            transition="fade-transition"
          ></v-carousel-item>
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
export default {
  name: "galleryPage",
  methods: {
    onClick(i) {
      this.index = i;
    },
  },
  data: function () {
    return {
      items: [
        {
          src: "https://placekitten.com/801/800",
        },
        {
          src: "https://placekitten.com/802/800",
        },
        {
          src: 'https://placekitten.com/803/800',
        },
        {
          src: "https://placekitten.com/804/800",
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
      images: [
        "https://placekitten.com/801/800",
        "https://placekitten.com/802/800",
        "https://placekitten.com/803/800",
        "https://placekitten.com/804/800",
        "https://placekitten.com/805/800",
        "https://placekitten.com/806/800",
        "https://placekitten.com/807/800",
        "https://placekitten.com/808/800",
        "https://placekitten.com/809/800",
        "https://placekitten.com/810/800",
      ],
      index: null,
    };
  },
};
</script>

<style scoped>
body {
  font-family: sans-serif;
}

.image {
  width: 100px;
  height: 100px;
  background-size: contain;
  cursor: pointer;
  margin: 10px;
  border-radius: 3px;
}
</style>
<!-- -->