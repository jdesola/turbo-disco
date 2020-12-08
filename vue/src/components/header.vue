<template>
  <div class="header-main">
      <a href="#" class="cat-logo"><img  class="cat-logo" src="../assets/jpg/small-logo.jpg" /></a>
      <a href="#" class="button fav" > <img class="button fav" src="../assets/webp/favorites-button.webp"/></a>
      <a href ="#" class ="button cats"><img class="button cats" src="../assets/webp/cats-button.webp"/> </a>
      <a href ="#" class ="button profile"><img class="button profile" src="../assets/webp/profile-button.webp"/></a>
      <form class="search"  > <input type="text" ><button type="submit" ><i class="material-icons" > search</i> </button> </form>
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
  "logo fav cats profile search"
  "logo . . . . ";
  justify-content: center;
  justify-items: center;

 
}
.button {
  /*align-self: center;*/
  margin-left: 7%;
  height: 80px;
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
  margin-left: 9%;
}

.profile { 
  grid-area: profile;
  margin-left: 3%;

}

.search{
  grid-area: search;
}

input, [type="button"], [type="reset"], [type="submit"] {
    -webkit-appearance: button;
    background-color: #EF2B76;
    padding-left: 2rem;
    padding-right: 2rem;
    cursor: pointer;
    color: white;
}
input, [type="text"] {
    background-color: white;
    padding-left: 2rem;
    padding-right: 2rem;
    cursor: pointer;
    color: grey;
}

</style>


