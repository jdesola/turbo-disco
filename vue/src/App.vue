<template>
  <div id="app">
    <div id="nav">
       <header-main></header-main>
    
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
   
  </div>
</template>

<script>
import HeaderMain from '../src/components/header.vue';

export default{
components: {
  HeaderMain
}
};
</script>
