<template>
  <v-container class="adminTools">
    <h1>Admin Tools</h1>
    <v-dialog
      v-model="catDialog"
      max-width="50%"
      persistent
    >
    <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="#c24a15"
          dark
          class="addCatBtn"
          v-bind="attrs"
          v-on="on"
        >
          Add a New Cat
        </v-btn>
        
    </template>
     <v-btn
            color="blue darken-1"
            text
            class="closeBtn"
            @click="catDialog = false"
          >
            Close
          </v-btn>
    <add-cat-form/>
   
    </v-dialog>

    <v-dialog
      v-model="storyDialog"
      max-width="50%"
      persistent
    >
    <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="#161fc2"
          dark
          class="addStoryBtn"
          v-bind="attrs"
          v-on="on"
        >
          Add a New Story
        </v-btn>
        
    </template>
     <v-btn
            color="blue darken-1"
            text
            class="closeBtn"
            @click="storyDialog = false"
          >
            Close
          </v-btn>
   <success-stories-form/>
   
    </v-dialog>
  </v-container>

  
</template>

<script>
import AddCatForm from '../components/AddCatForm.vue'
import SuccessStoriesForm from '../components/SuccessStoriesForm.vue'
export default {
  components: { AddCatForm, SuccessStoriesForm },
   name: 'CatFacts',
    data()
    {
      return {
      catDialog: false,
      storyDialog: false,
      }
    },
}
</script>

<style>
.adminTools {
  margin-top: 13%;
  height: 100%;
  width: 15%;

  background-color: whitesmoke;
}

.adminTools > h1 {
  text-align: center;
  font-family: 'Subscriber';
  font-size: 400%;
  color: #575a8f;
}

.addCatBtn{
  margin-left: 25.5%;
  margin-top: 3%;
  margin-bottom: 10%;
}

.addStoryBtn {
  margin-left: 22%;
  margin-top: 3%;
  margin-bottom: 10%;
}


.closeBtn {
  position: relative;
  
  background-color: #ebebeb;
  width: 100%;
}
</style>