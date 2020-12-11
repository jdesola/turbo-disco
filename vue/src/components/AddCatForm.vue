<template>
  <div class="catFormContainer">
    <img class="catImage" src="../assets/png/generic-cat2.png" />
    
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

      <upload-file/>
      <div class="buttons">
        <button class="reset-button" type="reset" value="reset">Reset</button>
        <button class="submit-button" type="submit" value="submit" v-on:click.prevent="saveNewCat">
          Submit
        </button>
      </div>
      
    </form>
    
  </div>
</template>

<script>
import catService from "../services/CatService";
import UploadFile from './UploadFile.vue';

export default {
  components:{

    UploadFile
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
      },
    };
  },
  methods: {
    saveNewCat() {
      catService
        .addCat(this.newCat)
        .then((response) => {
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
            };
            this.$router.push({name: 'home'});
            //{ name: 'Cats', params: { userId: 123 }
          }
          else {
            console.log(response.statusText);
          }
        })
        
    },

   
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

.catImage {
  align-self: center;
  width: 55%;
  border-radius: 14px;
}

.catForm {
  padding-top: 2%;
  display: flex;
  flex-direction: column;
  width: 50%;
  justify-content: space-around;
  color: #575a8f;
  text-align: center;
  padding-right: 10px;
  padding-left: 10px;
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
  font-size: 24px;
  font-weight: 500;
  font-family: Quicksand, sans-serif;
  border: none;
}

.buttons > button {
  border-radius: 18px;
  width: 45%;
  height: 40px;
  margin-bottom: 10px;
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
  font-size: 24px;
  font-weight: 500;
  letter-spacing: 0;
  line-height: 30px;
  padding-right: 10px;
}

.submit-button {
  border: 1px solid #33a3f5;
  background-color: #161fc2;
  margin-left: 10px;
  height: 1.95%;
  width: 5.28%;
  color: #33a3f5;
  font-family: Quicksand;
  font-size: 24px;
  font-weight: 500;
  letter-spacing: 0;
  line-height: 30px;
}
input::placeholder {
  color: #575a8f
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
