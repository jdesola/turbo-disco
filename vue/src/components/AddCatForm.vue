<template>
  <div class ="catForm"> 
      <img src="../assets/png/generic-cat2.png">
      <form action="#" method="post">
        
        <input type="text" id="name" name="name" placeholder="Name"/>
        <input type="text" id="age" name="age" placeholder="Age"/>
        <input type="text" id="skills" name="skills" placeholder="Skills"/>
        <input type="text" id="color" name="color" placeholder="Color"/>
        <select id="hair" name="hair" placeholder="Hair Length">
          <option value="Long">Long</option>
           <option value="Short">Short</option>
            <option value="Hairless">Hairless</option>
        </select>
        <input type="text" id="experience" name="experience" placeholder="Prior Experience"/>
        <input type="text" id="description" name="description" placeholder="Description"/>
        <button type="reset" value="reset">Reset</button>
        <button type="submit" value="submit">Submit</button>



      </form>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>