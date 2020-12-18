<template>
  <div data-app class="catFormContainer d-flex">
    <v-img
      contain
      aspect-ratio="1"
      v-if="this.imageData != null"
      class="catImage"
      :src="this.tempUrl"
    />

    <v-img
      v-else
      contain
      aspect-ratio="1"
      src="../assets/png/generic-cat2.png"
      class="catImage"
    />

    <v-form class="catForm d-flex flex-column  ">
      <v-text-field
        type="text"
        id="name"
        v-model="newCat.name"
        name="name"
        placeholder="Name"
        clearable
        outlined
      />

      <v-slider
        dense
        label="Age (in Years)"
        id="age"
        v-model="newCat.age"
        name="age"
        thumb-label="always"
        :min="1"
        :max="20"
        :thumb-size="24"
        :thumb-color="ageSliderThumbColor.color"
        :color="ageSliderThumbColor.color"
      ></v-slider>

      <v-select
        :items="hairSelection"
        id="hair"
        name="hair"
        v-model="newCat.hairLength"
        label="Hair Type"
      ></v-select>

      <v-text-field
        type="text"
        id="color"
        name="color"
        placeholder="Color"
        v-model="newCat.color"
        clearable
        outlined
      />

      <v-select
        :items="locations"
        id="location"
        name="location"
        v-model="newCat.locationId"
        label="Cat's Location"
      ></v-select>

      <v-text-field
        type="text"
        id="skills"
        name="skills"
        placeholder="Skills"
        v-model="newCat.skills"
        clearable
        outlined
      />

      <v-text-field
        type="text"
        id="experience"
        name="experience"
        placeholder="Previous Job Title"
        v-model="newCat.previousJobs"
        clearable
        outlined
      />

      <v-slider
        dense
        label="Months at Last Job"
        id="experience_months"
        v-model="newCat.priorExperienceMonths"
        name="experience_months"
        thumb-label="always"
        :min="1"
        :thumb-size="24"
        :thumb-color="ageSliderThumbColor.color"
        :color="ageSliderThumbColor.color"
      ></v-slider>

      <v-text-field
        type="text"
        id="description"
        name="description"
        placeholder="Description"
        v-model="newCat.description"
        clearable
        outlined
      />

      <v-btn class="mb-6" v-on:click="click1">Choose a Photo</v-btn>
      <input
        type="file"
        ref="input1"
        style="display: none"
        @change="previewImage"
        accept="image/*"
      />

      <div class="buttons">
        <v-btn class="reset-button" type="reset" value="reset">Reset</v-btn>
        <v-btn
          class="submit-button secondary--text"
          type="submit"
          color="#161fc2"
          depressed
          v-on:click.prevent="saveNewCat"
          @click.prevent="onUpload"
        >
          Submit
        </v-btn>
      </div>
    </v-form>
  </div>
</template>

<script>
import catService from "../services/CatService";
import firebase from "firebase";

export default {
  name: "AddCatForm",
  components: {},
  data() {
    return {
      ageSliderThumbColor: { label: "thumb-color", color: "#F6AE71" },
      hairSelection: ["Short", "Long", "Hairless"],
      newCat: {
        name: "",
        age: 1,
        hairLength: "",
        priorExperienceMonths: "",
        previousJobs: "",
        description: "",
        color: "",
        skills: "",
        imageName: "",
        locationId: "",
        catLocation:"",
      },
      imageData: null,
      img1: null,
      tempUrl: "",
    };
  },
  computed: {
    locations() {
      const locationOptions = [];
      this.$store.state.locationList.forEach(location => {
        const locationSelector = {text: location.name, value: location.id}
        locationOptions.push(locationSelector);
      });
      return locationOptions;
    },
  },
  methods: {
    
    saveNewCat() {
      catService.addCat(this.newCat).then((response) => {
        if (response.status === 201) {
          const findlocation = this.$store.state.locationList.find( l => l.id === this.newCat.locationId);
          this.newCat.catLocation = findlocation;
          this.$store.commit('ADD_CAT', this.newCat);
          this.newCat = {
            name: "",
            age: 1,
            hairLength: "",
            priorExperienceMonths: 1,
            previousJobs: "",
            description: "",
            color: "",
            skills: "",
            imageName: "",
            locationId:"",
            catLocation: "",
          };
          this.$router.push({ name: "home" });
        } else {
          console.log(response.statusText);
        }
      });
    },
    click1() {
      this.$refs.input1.click();
    },
    previewImage(event) {
      this.uploadValue = 0;
      this.img1 = null;
      this.imageData = event.target.files[0];
      this.newCat.imageName = this.imageData.name;
      this.tempUrl = URL.createObjectURL(this.imageData);
    },
    onUpload() {
      if (this.imageData != null) {
      this.img1 = null;
      const storageRef = firebase
        .storage()
        .ref(`${this.imageData.name}`)
        .put(this.imageData);
      storageRef.on(
        `state_changed`,
        (snapshot) => {
          this.uploadValue =
            (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
        },
        (error) => {
          console.log(error.message);
        },
        () => {
          this.uploadValue = 100;
        }
      );
    }
    },
  },
};
</script>

<style>
.catFormContainer {

    padding: 1%;
    background-color: #ebebeb;
}

.catImage {
  align-self: center;
  width: 55%;
  height: auto;
  max-height: 100%;
}

.catForm {
  display: flex;
  flex-direction: column;
  width: 50%;
  justify-content: space-around;
  color: #575a8f;
  text-align: center;
  padding-right: 2%;
  padding-left: 2%;

}

.catForm > v-select {
  color: #575a8f;
  text-align: center;
  text-align-last: center;
}

.catForm > v-text-field,
v-select {
  justify-self: center;
  background-color: #d8d8d8;
  border-radius: 14px;
  color: #575a8f;
  font-size: 150%;
  font-weight: 500;
  font-family: Quicksand, sans-serif;
  border: none;
}




.reset-button {
  background-color: #c24a15;
  color: #f6af71;
  border: 1px solid #f6af71; 
  font-family: Quicksand;
  font-size: 150%;
  letter-spacing: 0;
  line-height: 150%;
  
}

.submit-button {
  border: 1px solid #33a3f5;
  margin-left: 10px;
  color: #33a3f5;
  font-family: Quicksand;
  font-size: 150%;
  letter-spacing: 0;
  line-height: 150%;
}

v-text-field::placeholder {
  color: #575a8f;
}

::-webkit-input-placeholder {
  text-align: center;
}
:-moz-placeholder {
  /* Firefox 18- */
  text-align: center;
}
::-moz-placeholder {
  /* Firefox 19+ */
  text-align: center;
}
:-ms-input-placeholder {
  text-align: center;
}
</style>
