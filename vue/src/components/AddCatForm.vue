<template>
  <div class="catFormContainer">
    <img class="catImage" src="../assets/png/generic-cat2.png" />
    <form class="catForm" action="#" method="post">
      <input type="text" id="name" name="name" placeholder="Name" />

      <input type="text" id="age" name="age" placeholder="Age" />

      <select id="hair" name="hair">
        <option value="" disabled selected>Hair Length</option>
        <option value="Long">Long</option>
        <option value="Short">Short</option>
        <option value="Hairless">Hairless</option>
      </select>
      <input type="text" id="color" name="color" placeholder="Color" />
      <input
        
        type="text"
        id="skills"
        name="skills"
        placeholder="Skills"
      />

      <input
        type="text"
        id="experience"
        name="experience"
        placeholder="Previous Job Title"
      />

      <input
       
        type="text"
        id="description"
        name="description"
        placeholder="Description"
      />
      <div class="buttons">
        <button class="reset-button" type="reset" value="reset">Reset</button>
        <button class="submit-button" type="submit" value="submit">
          Submit
        </button>
      </div>
    </form>
  </div>
</template>

<script>
export default {};
</script>

<style>
.catFormContainer {
  display: flex;
  /*align-content: center; */
  width: 50%;
  margin: 0px auto;
  box-shadow: -2px 3px 15px 3px #575a8f;
  border-radius: 14px;
}

.catImage {
  width: 50%;
  height: auto;
  display: inline-block;
  border-radius: 14px;
}

.catForm {
  display: flex;
  flex-direction: column;
  height: max-content;
  width: 50%;
  align-content: space-evenly;
  line-height: 24px;
  color: #575a8f;
  text-align: center;
  padding-right: 10px;
  padding-left: 10px;
}
.catForm input:first-child {
  margin-top: 25px;
}

.catForm > select {
  color: #575a8f80;
  text-align: center;
}

.catForm > input,
select {
  height: 4%;
  background-color: #d8d8d8;
  border-radius: 14px;
  color: #575a8f;
  font-size: 24px;
  font-weight: 500;
  line-height: 30px;
  font-family: Quicksand, sans-serif;
  margin-bottom: 25px;
  border: none;
}

.buttons > button {
  border-radius: 18px;
  width: 45%;
  height: 40px;
  margin-bottom: 10px;
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
