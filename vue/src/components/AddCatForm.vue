<template>

  <div class="catFormContainer">
      <img class="catImage" src="../assets/png/generic-cat2.png">
      <form class="catForm" action="#" method="post">
        
        <input type="text" id="name" name="name" placeholder="Name"/>
    
        <input type="text" id="age" name="age" placeholder="Age"/>
   
        <input class="large-box" type="text" id="skills" name="skills" placeholder="Skills"/>
     
        <input type="text" id="color" name="color" placeholder="Color"/>
 
        <select id="hair" name="hair">
          <option value="" disabled selected>Hair Length</option>
          <option value="Long">Long</option>
           <option value="Short">Short</option>
            <option value="Hairless">Hairless</option>
        </select>
     
        <input type="text" id="experience" name="experience" placeholder="Prior Experience"/>
      
        <input class="large-box" type="text" id="description" name="description" placeholder="Description"/>
        <div class="buttons">
        <button type="reset" value="reset">Reset</button>
        <button type="submit" value="submit">Submit</button>
        </div>



      </form>
  </div>
  
</template>

<script>
export default {

}
</script>

<style>
.catFormContainer {
  display: flex;
 /*align-content: center; */
 width:50%;
 margin: 0px auto;
box-shadow: -2px 3px 15px 3px #575A8F;
}

.catImage {
  width:50%;
  height: auto;
  display: inline-block;
}

.catForm {
  display: flex;
  flex-direction: column;
  height: max-content;
  width: 50%;
  align-content: space-evenly;
  line-height: 24px;
    color: #575A8F;
    text-align: center;

}
.catForm input:first-child {
margin-top: 25px;

}

.catForm > select{
    color: #575a8f80;
}

.catForm > input, select{
  height: 4%;
   background-color: #D8D8D8;
  border-radius: 14px;
  color: #575A8F;
  font-size: 24px;
  font-weight: 500;
  line-height: 30px;
  font-family: Quicksand, sans-serif;
  margin-bottom: 25px;
}

/* .large-box{
  
  padding:10px;
  border-radius:10px;

} */

::-webkit-input-placeholder {
   text-align: center;
}
:-moz-placeholder { /* Firefox 18- */
   text-align: center;  
}
::-moz-placeholder {  /* Firefox 19+ */
   text-align: center;  
}
:-ms-input-placeholder {  
   text-align: center; 
}
</style>