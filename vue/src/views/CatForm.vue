<template>
  <div class="addCatPage">
    <img class="addCatHeader" src="../assets/png/Add-Cat.png" />
    <add-cat-form class="addCatForm" ></add-cat-form>
  </div>
</template>

<script>
import addCatForm from "../components/AddCatForm";

export default {
  name: "catForm",
  components: {
    addCatForm,
  },
};
</script>

<style>
.addCatPage {
  display: grid;
  grid-template-columns:  10% 60% 10%;
  grid-template-rows: 10% 90%;
  grid-template-areas: 
  " . catHeader ."
  " . form form";
}

.addCatForm {
  grid-area: form;
  width:  70%;
  justify-self: left;
  margin-top: 2%;
}

.addCatHeader {
  grid-area: catHeader;
  justify-self: left;
  
}
</style>
