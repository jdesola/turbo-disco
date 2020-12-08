<template>
  <div class="header-main">
      <a href="#" class="cat-logo"><img  class="cat-logo" src="../assets/jpg/small-logo.jpg" /></a>
      <img class="button fav" src="../assets/webp/favorites-button.webp"/>
      <img class="button cats" src="../assets/webp/cats-button.webp"/>
      <img class="button profile" src="../assets/webp/profile-button.webp"/>

  </div>
</template>

<script>
export default {
  name: "header-main",
     components: {
},
  data() {
    return {
      
    }
  }
};
</script>

<style>
.header-main {
  /*grid container*/
  display: grid;
   grid-template-columns: 12% 20% 20% 20% 20% 8%;
   grid-template-areas: 
   "logo . . . . "
  "logo fav cats profile test"
  "logo . . . . ";

 
}

.cat-logo {
  grid-area: logo;
  width: 100%;
}

.fav {
  grid-area: fav;
}

.cats {
  grid-area: cats;
}

.profile { 
  grid-area: profile;
}

.button {
  /*align-self: center;*/
  padding-left: 7%;
}


.place {
  grid-area: test;
}
</style>


