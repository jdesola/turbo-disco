<template>
  <div id="app">
    <SmallLogo />
    <header-main/>
    <div id="nav">
       
    
      
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
   
  </div>
</template>

<script>
import HeaderMain from '../src/components/header.vue';
import SmallLogo from './assets/svg/small-logo.svg';

export default{
components: {
  HeaderMain,
  SmallLogo
}
};
</script>
