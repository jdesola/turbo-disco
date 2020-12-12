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
  computed: {
    featuredCats: function () {
      return this.$store.state.catList.filter(function (cat) {
        return cat.featured;
      });
    },
  },
};
</script>

<style>
</style>