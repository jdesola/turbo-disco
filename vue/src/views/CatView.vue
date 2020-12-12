<template>
  <div class=cat-list-container>
      
      <cat-card class="cat-card" v-for="cat in allCats" v-bind:key="cat.id" 

      v-bind:cat="cat">  </cat-card>
      
  </div>
</template>

<script>
// import catService from '../services/CatService'
import CatCard from '../components/CatCard.vue'

export default {
  name: "Cats",
  components: { CatCard },
  created() {
      // this.retrieveCats();
  },
  computed: {
    resultListLength() {
      return this.$store.state.resultList.length;
    },
      allCats: function () {
      return this.$store.state.catList.filter(function (cat) {
        return !cat.adopted;
      });
    },
  },
  methods: {
    // retrieveCats() {
    //   catService.getCats().then(response => {
    //       this.$store.commit("SET_CAT_LIST", response.data);
    //     });
    // },
    
    }
}
</script>

<style>
.cat-card {
  border-radius: 24px;
}

.cat-card:hover {
  box-shadow: -1px 2px 8px 1px rgba(0, 0, 0, 0.5);
}

.cat-card:nth-child(even) {
  background-color: #c3c6f381;
  
}


</style>