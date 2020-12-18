<template>
   <div class="facts">
      <button type="button" id="get-fact" @click="getFact">Get New Cat Fact</button>
      <div v-if="this.responseAvailable ==true">
        <hr />
        <p>
        {{ this.result }}
        </p>
        <hr />
      </div>
      </div>
</template>

<script>
import CatFactService from '../services/CatFactService'

export default {
    name: 'CatFacts',
    data()
    {
      return {
      result: '',
      responseAvailable: false,
      }
    },
    methods: {
    getFact() {
      CatFactService
        .getCatFacts()
        .then((response) => {
          if (response.status === 200) {
            response.data.data.forEach(text => 
            this.result = text.fact)
            this.responseAvailable = true;
          }
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg = `Error getting cat fact.  ${error.response.status} - ${error.response.statusText}`;
          } else if (error.request) {
            this.errorMsg = "Could not connect to server";
          } else {
            this.errorMsg = "Unexpected error";
            console.error(error);
          }
        });
    }
    },
    mounted()
    {
      
      this.getFact()
    }

}
</script>

<style scoped>
 #get-fact {
  margin-top: 7%
  
} 
button {
  text-decoration: underline;
}

button:hover {
  color: #161fc2;
}
</style>