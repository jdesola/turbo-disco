<template>
  <div class=cat-list-container>  
      <cat-card v-for="cat in this.$store.state.catList" v-bind:key="cat.id" 
      v-bind:cat="cat"></cat-card>
  </div>
</template>

<script>
import catService from '../services/CatService'
import CatCard from '../components/CatCard.vue'

export default {
  name: "Cats",
  components: { CatCard },
  created() {
      this.retrieveCats();
  },
  methods: {
    retrieveCats() {
      catService.getCats().then(response => {
          this.$store.commit("SET_CAT_LIST", response.data);
        });
    },
    
    }
}
</script>

<style>

</style>