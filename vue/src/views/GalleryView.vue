<template>
  <div class="GalleryPage">

    <img class="image" v-bind:key ='image' v-for="(image, i) in images" :src="image" @click="onClick(i)"  @mouseover="hover = true"
      @mouseleave="hover = false">
    <span v-if="hover"> <br>A Kitty! </span>
    <gallery :images="images" :index="index" @close="index = null"></gallery>

 </div>
</template>

<script>
import Gallery from '../components/Gallery'

export default {
    name: 'galleryPage',
    components:{
        Gallery
    },
    methods: {
      onClick(i) {
        this.index = i;
      }
    },
      data: function() {
        return {
            hover:false,
            images: [
                'https://placekitten.com/801/800',
                'https://placekitten.com/802/800',
                'https://placekitten.com/803/800',
                'https://placekitten.com/804/800',
                'https://placekitten.com/805/800',
                'https://placekitten.com/806/800',
                'https://placekitten.com/807/800',
                'https://placekitten.com/808/800',
                'https://placekitten.com/809/800',
                'https://placekitten.com/810/800',
            ],
            index: 0
        };
    }

}

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