<template>

  <v-container>
     <v-subheader> Add Success Story</v-subheader>
    <v-form>
         
      <v-row>
          <v-col>
            <v-select
            v-model="selectedCatId"
            :items="cats"
            item-text="name"
            item-value="id"
            label="Select Adopted Cat"
            @click="parseCats(adoptedCats)"
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
                        v-model="date"
                        label="Date Adopted"
                        prepend-icon="mdi-calendar"
                        readonly
                        v-bind="attrs"
                        v-on="on"
                    ></v-text-field>
                    </template>
                    <v-date-picker color="#c24a15" v-model="date" no-title scrollable>
                    <v-spacer></v-spacer>
                    <v-btn text color="primary" @click="menu = false"> Cancel </v-btn>
                    <v-btn text color="primary" @click="$refs.menu.save(date)">
                        OK
                    </v-btn>
                    </v-date-picker>
                </v-menu>
                 </v-col>
                </v-row>
               
        <v-row>
          <v-text-field label="Adopter Name" outlined></v-text-field>
        </v-row>
        <v-row>
          <v-textarea outlined label="Success Story"> </v-textarea>
        </v-row>
      <v-row justify="center">
        <v-btn class="ma-2" color="secondary" depressed> Reset Form </v-btn>

        <v-btn class="ma-2" :loading="loading" color="secondary" depressed>
          Submit Story
        </v-btn>
      </v-row>
     
    </v-form>
  </v-container>
</template>

<script>
export default {
  name: "SuccessStoriesForm",
  data() {
    return {
      cats: [],
      selectedCatId: null,
      date: new Date().toISOString().substr(0, 10),
      menu: false,
      modal: false,
      menu2: false,
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

<style>
</style>