<template>
   <div class="facts">
      <button type="button" id="get-joke" @click="fetchAPIData">Test</button>
      <div v-if="responseAvailable ==true">
        <hr />
        <p>
          <i>{{ result }}</i>
        </p>
        <hr />
      </div>
      </div>
</template>

<script>
import Vue from 'vue';
import axios from 'axios';
import VueAxios from 'vue-axios'
Vue.use(VueAxios, axios)

export default {
    name: 'CatList',
    data()
    {
        return {button: undefined}
    },
    mounted()
    {
        Vue.axios.get('https://brianiswu-cat-facts-v1.p.rapidapi.com/facts')
        .then((resp)=>{
            this.button=resp.data.data;
            console.warn(resp.data.data);
        })
    }

}
</script>

<style>

</style>