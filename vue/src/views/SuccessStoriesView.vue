<template>
  
  <v-container fluid class ="successStoriesPage">
    <v-row dense>
      <v-col
      v-for="story in this.$store.state.storyList"
     v-bind:key="story.storyId"
     cols=5>
     <success-stories 
     class="success-stories "
     
     v-bind:story="story"
     >
     </success-stories>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import SuccessStories from "@/components/SuccessStories";
// import StoryService from '@/services/StoryService';

export default {
    name: "SuccessStoriesView",
    components: {
        SuccessStories,
    },
    methods: {
      // retrieveStories() {
      //   StoryService.getStories().then(response => {
      //   this.$store.commit('SET_STORY_LIST', response.data);
      //   })
      // }
    },
    created() {
      document.title = 'Success Stories';
      // this.retrieveStories();
    },
    data() {
      return {};
    },

};
</script>


<style scoped>
.successStoriesPage {
  position: absolute;
  z-index: 1;
  margin-top: 12%;
  height: 100%;
  width: 100%;
  margin-left: 8%;
  background-color: #adcff0;
}

.success-stories {
  z-index:2;

}
</style>
