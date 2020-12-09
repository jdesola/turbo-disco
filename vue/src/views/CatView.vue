<template>
  <div class=cat-list-container>  
      <cat-card v-for="cat in allCats" v-bind:key="cat.id" v-bind:cat="cat"></cat-card>
  </div>
</template>

<script>
import catsService from '../services/CatService'
import CatCard from '../components/CatCard.vue'
export default {
  name: "Cats",
  components: { CatCard },
  methods: {
    retrieveCats() {
      catsService
        .list()
        .then(response => {
          this.$store.commit("SET_CAT_LIST", response.data);
        });
    },
    created() {
      this.retrieveCats();
  },
    computed: {
      allCats() {
        return this.$store.state.catList;
      }
    }
}
}
</script>

<style>

</style>