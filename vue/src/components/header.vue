<template>
  <div class="header-container">
    
    <nav class="header-main">
      <a href="#" class="cat-logo"
        ><img class="cat-logo" src="../assets/png/small-logo.png"
      /></a>
      <a href="#" class="button fav">
        <img class="button fav" src="../assets/webp/favorites-button.webp"
      /></a>
      <a href="#" class="button cats"
        ><img class="button cats" src="../assets/webp/cats-button.webp" />
      </a>
      <a href="#" class="button profile"
        ><img class="button profile" src="../assets/webp/profile-button.webp"
      /></a>
      <search class="search-container"/>
    </nav>
    
  </div>
</template>

<script>
import Search from './Search.vue';
export default {
  name: "header-main",
  components: {Search},
  data() {
    return {};
  },
};
</script>

<style>


.header-main {
  /*grid container*/
  display: grid;
  grid-template-columns: 2% 12% 15% 15% 15% 15% 10%;
  grid-template-rows: 33% 34% 33%;
  grid-template-areas:
    ". logo . . . . ."
    ". logo fav cats profile search . "
    ". logo . . . . .";
  justify-content: space-evenly;
  overflow: hidden;
}
.button {
  margin-left: 7%;
  height: 110%;
  justify-self: left;
  align-self: center;
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
  justify-self: center;
}

.profile {
  grid-area: profile;
  margin-left: 3%;
}

.search-container {
  grid-area: search;
  height: 76%;
  width: 100%;
  border-radius: 30px;
  background-color: rgba(199, 199, 199, 0.35);
  box-shadow: -2px 3px 15px 3px rgba(0, 0, 0, 0.5);
  float: right;
  justify-self: center;
  align-self: center;
  margin-left: 20%;
  margin-top: 2%;
}
.header-main input[type="text"] {
  grid-area: search;
  width: 68%;
  margin-left: 7%;
  margin-top: 7%;
  font-size: 17px;
  border: none;
  color: #33a3f5;
  background-color: rgba(199, 199, 199, 0);
  outline: none;
  font-family: "Quicksand", sans-serif;
}
.header-main .search-container button {
  grid-area: search;
  padding: 0.3% 0.5%;
  margin-top: 0.3%;
  margin-right: 2%;

  border: none;
  cursor: pointer;
  position: absolute;
  align-self: center;
  justify-self: right;
  background-color: rgba(199, 199, 199, 0);
  color: #33a3f5;
  border-left: #33a3f5 1.5px solid;
}

.search-icon {
  grid-area: search;
  font-size: 275%;
  margin-left: 10%;
  justify-self: center;
  align-self: center;
  margin-bottom: 5%;
}


</style>


