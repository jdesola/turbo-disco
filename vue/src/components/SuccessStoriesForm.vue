<template>

  <v-container class="successFormPage" elevation="12">
     <v-subheader > Add Success Story</v-subheader>
    <v-form ref="successForm">
         
      <v-row>
          <v-col>
            <v-select
            v-model="newSuccessStory.catId"
            :items="cats"
            item-text="name"
            item-value="value"
            label="Select Adopted Cat"
            @click="parseCats(adoptedCats)"
            color="#33a3f5"
            >
            </v-select>
          </v-col> 
            <v-col>
                <v-menu
                    ref="menu"
                    v-model="menu"
                    :close-on-content-click="false"
                    :return-value.sync="date"
                    transition="scale-transition"
                    offset-y
                    min-width="290px"
                >
                    <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                        v-model="newSuccessStory.dateAdopted"
                        label="Date Adopted"
                        prepend-icon="mdi-calendar"
                        readonly
                        v-bind="attrs"
                        v-on="on"
                    ></v-text-field>
                    </template>
                    <v-date-picker color="#c24a15" v-model="newSuccessStory.dateAdopted" no-title scrollable>
                    <v-spacer></v-spacer>
                    <v-btn text color="#c24a15" @click="menu = false"> Cancel </v-btn>
                    <v-btn text color="primary" @click="$refs.menu.save(date)">
                        OK
                    </v-btn>
                    </v-date-picker>
                </v-menu>
                 </v-col>
                </v-row>
               
        <v-row>
            <v-col>
          <v-text-field label="Adopter Name" color="#f6af71" outlined v-model="newSuccessStory.adopterName"></v-text-field>
            </v-col>
            <v-col>
          <v-textarea auto-grow outlined  color="#575a8f" counter rows="1"  :rules="rules" clearable label="Success Story"  v-model="newSuccessStory.successStory">  </v-textarea>
            </v-col>
        </v-row>
      <v-row justify="center">
          <div class="buttons">
        <v-btn x-large class="reset-button info--text" @click="reset" color="#c24a15">Reset</v-btn>
        <v-btn
        x-large
          class="submit-button secondary--text"
          type="submit"
          color="#161fc2"
          @click="submitNewStory"
        >
          Submit
        </v-btn>
      </div>
      </v-row>
     
    </v-form>
  </v-container>
</template>

<script>
import StoryService from '../services/StoryService';

export default {
  name: "SuccessStoriesForm",
  data() {
    return {
        rules: [v => v.length <= 255 || 'Max 255 characters'],
      cats: [],
      date: new Date().toISOString().substr(0, 10),
      menu: false,
      modal: false,
      menu2: false,
      newSuccessStory: {
          catId: "",
          dateAdopted: null,
          adopterName: "",
          successStory: "",
      }
    };
  },
  methods: {
    parseCats(adoptedCats) {
      adoptedCats.forEach((cat) => {
        const catId = cat.id;
        const catName = cat.name;
        this.cats.push({ value: catId, name: catName });
      });
    },
    submitNewStory() {
      StoryService.addStory(this.newSuccessStory).then((response) => {
        if (response.status === 201) {
          this.$store.state.commit('ADD_STORY', this.newSuccessStory);
          this.newSuccessStory = {
            catId: "",
          dateAdopted: null,
          adopterName: "",
          successStory: "",
          };
          this.$router.push({ name: "home" });
        } else {
          console.log(response.statusText);
        }
      });
    },
    reset () {
        this.$refs.successForm.reset()
      },
  },
  computed: {
    adoptedCats: function () {
      return this.$store.state.catList.filter(function (cat) {
        return cat.adopted;
      });
    },
  },
};
</script>

<style scoped>
.successFormPage {
  background-color: #ebebeb;
}

.v-subheader {
    font-family: 'Subscriber';
    font-size: 300%;
    color: #161fc2 !important;
}

.v-form {
    margin-left: 5%;
    margin-right: 5%;
    font-family: 'Quicksand', sans-serif;
    font-weight: 500;
}

.reset-button {
  font-family: Quicksand;
  font-size: 125% !important;
}

.submit-button {
  
  font-family: Quicksand;
  font-size: 125% !important;
}

</style>