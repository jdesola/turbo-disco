<template>
  <div class="footer-container">
    <img class="big-logo" src="../assets/png/big-logo-50.png" />
    <!-- <cat-facts class="facts"/> -->
    </div>
</template>

<script>
//import CatFacts from '@/components/CatFacts';

export default {
  // components: {CatFacts},
  name: "Footer",
};
</script>

<style scoped>
.footer-container {
  left: 0;
  bottom: 0;
  width: 100%;
  position: fixed;
  height: 35%;
  width: 100%;
  background-color: #adcff0;
  /* color: white; */
}

.big-logo {
  margin-top: 14%;
  width: 7.5%;
  height: auto;
}

/* .facts {
  grid-area: facts;
  margin-top: 5%;
  width: 40%;
 margin-left: 700px;
} */
</style>
