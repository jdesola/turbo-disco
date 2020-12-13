<template>
  <v-form>
      <v-select
        v-model="selectedCatId"
        :items=cats
        item-text="name"
        item-value="id"
        label="Select Adopted Cat">
        </v-select>
  </v-form>
</template>

<script>
export default {
    name: "SuccessStoriesForm",
    data() {
        return {
            cats: [],
            selectedCatId: ""
        }
    },
    created() {
        this.parseCats(this.allCats);
    },
    methods: {
        parseCats(allCats) {
            allCats.forEach( cat => {
                const catId = cat.id;
                const catName = cat.name;
                this.cats.push({value: catId, name: catName});
                
            });
        }
    },
    computed: {
        allCats: function () {
      return this.$store.state.catList.filter(function (cat) {
        return !cat.adopted;
      });
    },
    }

}
</script>

<style>

</style>