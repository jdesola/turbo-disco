<template>
  <div class="header-main">
     <!-- <svg src="/assets/small-logo.svg" />  -->
    <img src="/assets/small-logo.jpg"/>
    <smallLogo/>
  </div>
</template>

<script>
import smallLogo from './assets/small-logo.svg';

export default {
  name: "header-main",
  components: {
    smallLogo,

  },
};
</script>

<style>
svg {
  width: 100%;
  height: auto;

}
</style>
