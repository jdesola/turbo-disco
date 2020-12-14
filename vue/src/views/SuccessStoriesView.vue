<template>
  <div class ="successStoriesPage">
     <success-stories 
     class="success-stories"
     v-for="story in this.$store.state.storyList"
     v-bind:key="story.storyId"
     v-bind:story="story"
     >
     </success-stories>
    
  </div>
</template>

<script>
import SuccessStories from "@/components/SuccessStories";
import StoryService from '@/services/StoryService';
export default {
    name: "successStories",
    components: {
        SuccessStories,
    },
    methods: {
      retrieveStories() {
        StoryService.getStories().then(response => {
        this.$store.commit('SET_STORY_LIST', response.data);
        })
      }
    },
    created() {
      this.retrieveStories();
    },
    data() {
      return {};
    },

};
</script>


<style>

</style>
