<template>
  <div class="catCard">
      <h1>This is a test</h1>
      <img src="../assets/png/generic-cat2.png" alt="" id="profilePicture" />
      <h2 id="name">{{ cat.name }}</h2>
      <p id="age">{{ cat.age }}</p>
      <p id="hairType">{{ cat.hairLength }}</p>
      <p id="priorJobs">{{ cat.previousJobs }}</p>
      <p id="priorExperienceMonths">{{ cat.priorExperienceMonths }}</p>
  </div>
</template>

<script>
export default {
    name: "catCard",
    props: ['cat'],

}
</script>

<style>

</style>