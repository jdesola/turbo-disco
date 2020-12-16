<template>
  <div class="footer-container">
    <img class="big-logo" src="../assets/png/big-logo-50.png" />
    <div class="facts">
      <button type="button" id="get-joke" @click="fetchAPIData">Test</button>
      <div v-if = "responseAvailable == true">
        <hr>
        <p>
            <i>{{result}}</i>
        </p>
        <hr>
</div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Footer",
  data() {
    return {};
  },
  methods: {
    fetchAPIData() {
      fetch("https://brianiswu-cat-facts-v1.p.rapidapi.com/facts", {
        method: "GET",
        headers: {
          "x-rapidapi-key":
            "9a1eac439fmsh40558f4c87b06c7p13e515jsn9c3b5cefc1e7",
          "x-rapidapi-host": "brianiswu-cat-facts-v1.p.rapidapi.com",
        },
      })
        .then((response) => {
          console.log(response);
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
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
  position: float;
}
</style>
