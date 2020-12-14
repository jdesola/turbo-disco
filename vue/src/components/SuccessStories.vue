<template>
<div>
      <v-card class="successStoriesCard"
      elevation="2">
        <v-card-title id="name">{{this.story.catName}}</v-card-title>
        <v-card-text class ="cardText">Adopted By: {{this.story.adopterName}}</v-card-text>
        <v-card-text class ="cardText">Date Adopted: {{this.story.dateAdopted}}</v-card-text>
            <v-card-actions>
              <v-btn id="readStoryBtn" v-on:click="show= !show" text>
                Click to Read Story
              </v-btn>

              <v-spacer></v-spacer>

              <v-btn
                icon
                @click="show = !show"
              >
                <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
              </v-btn>
            </v-card-actions>

            <v-expand-transition>
              <div v-show="show">
                <v-divider></v-divider>

                <v-card-text class="cardText">{{this.story.successStory}}</v-card-text>
              </div>
            </v-expand-transition>
</v-card>
</div>


    
</template>

<script>
export default {
name: "successStories",
props:["story"],
data() {
  return {
    show:false}
}

}
</script>

<style>
.successStoriesCard {
  margin-bottom: .77%;
  text-decoration-color: black;
  font-family: Quicksand;
  
  
}
#name{
font-family: "subscriber";
font-size: 275%;
color:#161fc2;
margin-bottom:1%;
}
#readStoryBtn{
color: #33a3f5
}
.cardText{
  font-size: 140%;
}

</style>