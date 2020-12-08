<template>
  <div id="app">
    <header-main/>
    <div id="nav">
       
    
      
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
