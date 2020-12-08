<template>
  <div class="header-main">
      <a href="#" class="cat-logo"><img  class="cat-logo" src="../assets/jpg/small-logo.jpg" /></a>
      <a href="#" class="button fav" > <img class="button fav" src="../assets/webp/favorites-button.webp"/></a>
      <a href ="#" class ="button cats"><img class="button cats" src="../assets/webp/cats-button.webp"/> </a>
      <a href ="#" class ="button profile"><img class="button profile" src="../assets/webp/profile-button.webp"/></a>
      <div class="search-container">
    <form action="/action_page.php">
      <input type="text" name="search">
      <button type="submit"><i class="material-icons"> search</i></button>
    </form>
  </div>
      <!-- <form class="search"  > <input class="rectangle" type="text" ><button type="submit" ><i class="material-icons" > search</i> </button> </form> -->
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
   grid-template-rows: 22% 56% 22%;
   grid-template-areas: 
   "logo . . . . "
  "logo fav cats profile search "
  "logo . . . . ";
  justify-items: center;
  overflow: hidden;
  border-bottom: 8px #575a8f solid;
  border-radius: 7%;

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

.search-container{
  grid-area: search;
  height: 76%;
  width: 100%;
  border-radius: 30px;
  background-color: rgba(199,199,199,0.35);
  box-shadow: -2px 3px 15px 3px rgba(0,0,0,0.5);
}

.header-main .search-container {
  float: right;
  justify-self: center;
  align-self: center;
  margin-left: 20%;
  margin-top: 2%;
  
}
.header-main input[type=text] {
  width: 68%;
  margin-left: 7%;
  margin-top: 7%;
  font-size: 17px;
  border: none;
  color: #33a3f5;
  background-color: rgba(199, 199, 199, 0);
  outline: none;
  font-family: 'Quicksand', sans-serif;

}
.header-main .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  font-size: 17px;
  border: none;
  cursor: pointer;
  position: absolute;
  align-self: center;
  right: 5.2%;
  background-color: rgba(199, 199, 199, 0);
  color: #33a3f5;
  border-left: #33a3f5 1.5px solid;

}
i{
  height: 110%;
  width: auto;
}
/* .header-main .search-container button:hover {
  background: #ccc;
} */

/* input, [type="button"], [type="reset"], [type="submit"] {
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
} */

</style>


