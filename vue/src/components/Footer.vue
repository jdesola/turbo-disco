<template>
  <div class ="footer-container">
       <img  class="big-logo" src="../assets/png/big-logo-50.png"/>
      <div class ="links">
          <ul>
              <li></li>
              <li></li>
              </ul>
      </div>
  </div>
</template>

<script>
import axios from "axios";

const options = {
  method: 'GET',
  url: 'https://brianiswu-cat-facts-v1.p.rapidapi.com/facts',
  headers: {
    'x-rapidapi-key': '9a1eac439fmsh40558f4c87b06c7p13e515jsn9c3b5cefc1e7',
    'x-rapidapi-host': 'brianiswu-cat-facts-v1.p.rapidapi.com'
  }
};

axios.request(options).then(function (response) {
	console.log(response.data);
}).catch(function (error) {
	console.error(error);
});
export default {

}
</script>

<style>
.footer-container{
    display:grid;
    grid-template-areas: 'logo links' ;
    left: 0;
  bottom: 0;
  width: 100%;
    position: fixed;
    height: 15%;
    width: 100%;
    /* background-color: #575A8F; */
    /* color: white; */
    }

    .big-logo{
        grid-area:logo;
    }

    .links{
        grid-area: links;
        position: float;
    }
</style>