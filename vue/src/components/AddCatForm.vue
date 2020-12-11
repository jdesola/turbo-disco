<template>
  <div class="catFormContainer">
    <div class="catImageContainer">
    <img v-if="this.imageData != null" class="catImage" :src="this.tempUrl" />

    <img v-else src="../assets/png/generic-cat2.png"  class="catImage" />
    </div>
    <form class="catForm">
      <input
        type="text"
        id="name"
        v-model="newCat.name"
        name="name"
        placeholder="Name"
      />

      <input
        type="text"
        id="age"
        v-model="newCat.age"
        name="age"
        placeholder="Age"
      />

      <select id="hair" name="hair" v-model="newCat.hairLength">
        <option value="" disabled selected>Hair Length</option>
        <option value="Long">Long</option>
        <option value="Short">Short</option>
        <option value="Hairless">Hairless</option>
      </select>

      <input
        type="text"
        id="color"
        name="color"
        placeholder="Color"
        v-model="newCat.color"
      />
      <input
        type="text"
        id="skills"
        name="skills"
        placeholder="Skills"
        v-model="newCat.skills"
      />

      <input
        type="text"
        id="experience"
        name="experience"
        placeholder="Previous Job Title"
        v-model="newCat.previousJobs"
      />

      <input
        type="text"
        id="experience_months"
        name="experience_months"
        placeholder="Time at Previous Job"
        v-model="newCat.priorExperienceMonths"
      />

      <input
        type="text"
        id="description"
        name="description"
        placeholder="Description"
        v-model="newCat.description"
      />

      <v-btn v-on:click="click1">Choose a Photo</v-btn>
      <input
        type="file"
        ref="input1"
        style="display: none"
        @change="previewImage"
        accept="image/*"
      />

      

      <div class="buttons">
        <button class="reset-button" type="reset" value="reset">Reset</button>
        <button
          class="submit-button"
          type="submit"
          value="submit"
          v-on:click.prevent="saveNewCat" @click.prevent="onUpload"
        >
          Submit
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import catService from "../services/CatService";
import firebase from 'firebase';

export default {
  components: {
  },
  data() {
    return {
      newCat: {
        name: "",
        age: "",
        hairLength: "",
        priorExperienceMonths: "",
        previousJobs: "",
        description: "",
        color: "",
        skills: "",
        imageUrl: "",
      },
      imageData: null,
      img1: null,
      tempUrl: "",

    };
  },
  methods: {
    saveNewCat() {
      catService.addCat(this.newCat).then((response) => {
        if (response.status === 201) {
          this.newCat = {
            name: "",
            age: "",
            hairLength: "",
            priorExperienceMonths: "",
            previousJobs: "",
            description: "",
            color: "",
            skills: "",
            imageUrl: "",
          };
          this.$router.push({ name: "home" });
        } else {
          console.log(response.statusText);
        }
      });
    },
    click1() {
        this.$refs.input1.click()
    },
    previewImage(event) {
        this.uploadValue=0;
        this.img1=null;
        this.imageData = event.target.files[0];
        this.tempUrl = URL.createObjectURL(this.imageData);
    },
    onUpload(){
        this.img1=null;

        const storageRef=firebase.storage().ref(`${this.imageData.name}`).put(this.imageData);
        storageRef.on(`state_changed`, snapshot =>{
            this.uploadValue = (snapshot.bytesTransferred/snapshot.totalBytes)*100;
        }, error=>{console.log(error.message)},
        ()=>{this.uploadValue=100;

        
        });
        this.afterComplete(this.imageData);
        },
        async afterComplete(imageData) {
            try {
                const imageName = imageData.name;
                const storageRef = firebase.storage().ref();
                const imageRef = storageRef.child(`${imageName}`);

                this.newCat.imageUrl = await imageRef.getDownloadURL();
            } catch (error) {
                console.log(error);
            }
        }
  },
  
  
};
</script>

<style>
.catFormContainer {
  display: flex;
  margin: 0px auto;
  box-shadow: -2px 3px 15px 3px #575a8f;
  border-radius: 14px;
}

.catImageContainer {
  display: flex;
  align-self: center;
  justify-self: center;
  align-content: center;
  justify-content: center;
  
  max-height: 100%;
  border-radius: 14px;
  margin-top: 1%;
  margin-bottom: 1%;
  margin-left: .5%;
}

.catImageContainer > img {
  max-width: 100%;
flex-shrink: 10;
}

.catForm {
  padding-top: 2%;
  display: flex;
  flex-direction: column;
  width: 50%;
  justify-content: space-around;
  color: #575a8f;
  text-align: center;
  padding-right: 2%;
  padding-left: 2%;
}

.catForm > select {
  color: #575a8f;
  text-align: center;
  text-align-last: center;
}

.catForm > input,
select {
  justify-self: center;
  background-color: #d8d8d8;
  border-radius: 14px;
  color: #575a8f;
  font-size: 150%;
  font-weight: 500;
  font-family: Quicksand, sans-serif;
  border: none;
}

.buttons > button {
  border-radius: 18px;
  width: 45%;
  height: auto;
  margin-bottom: 2%;
  cursor: pointer;
}
input {
  text-align: center;
  overflow: hidden;
}

.reset-button {
  background-color: #c24a15;
  color: #f6af71;
  border: 1px solid #f6af71;
  height: 1.95%;
  width: 5.28%;
  font-family: Quicksand;
  font-size: 150%;
  font-weight: 500;
  letter-spacing: 0;
  line-height: 150%;
  padding-right: 2%;
}

.submit-button {
  border: 1px solid #33a3f5;
  background-color: #161fc2;
  margin-left: 10px;
  height: 1.95%;
  width: 5.28%;
  color: #33a3f5;
  font-family: Quicksand;
  font-size: 150%;
  font-weight: 500;
  letter-spacing: 0;
  line-height: 150%;
}
input::placeholder {
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
