<template>
  <div class="footer-container">
    <img class="big-logo" src="../assets/png/big-logo-50.png" />
      <cat-facts class="facts"/>
    </div>
</template>

<script>
import CatFacts from '@/components/CatFacts';

export default {
   components: {CatFacts},
  name: "Footer",
};
</script>

<style>
.footer-container {
  display: grid;
  grid-template-areas: "logo facts";
  left: 0;
  bottom: 0;
  width: 100%;
  position: fixed;
  height: 15%;
  width: 100%;
  /* color: white; */
}

.big-logo {
  grid-area: logo;
}

.facts {
  grid-area: facts;
  margin-top: 5%;
  width: 40%;
 margin-left: 700px;
}
</style>
