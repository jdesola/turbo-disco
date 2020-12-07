<template>
  <div class="header-main">
    <img :src="logoSmall" />
    <small-logo />
    <h1>This is the main-header</h1>
  </div>
</template>

<script>
import SmallLogo from '../assets/svg/small-logo.svg';
export default {
  name: "header-main",
     components: {
     SmallLogo
},
  data() {
    return {
      logoSmall: require('../assets/svg/small-logo.svg')
    }
  }
};
</script>

<style>
</style>
