<template>
  <div class="featuredCat">
    <cat-card
      class="cat-card"
      v-for="cat in featuredCats"
      v-bind:key="cat.id"
      v-bind:cat="cat"
    >
    </cat-card>

   
  </div>
</template>

<script>
import CatCard from "@/components/CatCard.vue";
export default {
  name: "FeaturedCats",
  components: { CatCard },
  data() {
    return {};
  },
  created() {
    document.title = 'Featured Cats';
  },
  computed: {
    featuredCats: function () {
      return this.$store.state.catList.filter(function (cat) {
        if (cat.featured && !cat.adopted){
        return cat;
        }
      });
    },
  },
};
</script>

<style>
</style>