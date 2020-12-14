import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    catList: [],
    storyList: [""],
    cat: {
      id: "",
      name: "",
      age: "",
      hairLength: "",
      priorExperienceMonths: "",
      previousJobs: "",
      description: "",
      color: "",
      skills: "",
      featured: "",
      adopted: "",
      imageName: "",
      strengthRating: "",
      intelligenceRating: "",
      speedRating: "",
      staminaRating: "",
    },
    SuccessStory: {
      storyId: "",
      catId: "",
      catName: "",
      adopterName: "",
      dateAdopted: "",
      successStory: "",
    }
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_CAT_LIST(state, data) {
      state.catList = data;
    },
    ADOPT_CAT(state, payload) {
      const { id, adopted } = payload;
      const cat = state.catList.find(c => c.id === id);
      cat.adopted = adopted;
    },
    TOGGLE_FEATURE_CAT(state, payload) {
      const { id, featured } = payload;
      const cat = state.catList.find(c => c.id === id);
      cat.featured = featured;
    },
    ADD_CAT(state, payload) {
      const newCat = {
        id: payload.id,
        name: payload.name,
        age: payload.age,
        hairLength: payload.hairLength,
        priorExperienceMonths: payload.priorExperienceMonths,
        previousJobs: payload.previousJobs,
        description: payload.description,
        color: payload.color,
        skills: payload.skills,
        featured: payload.featured,
        adopted: payload.adopted,
        imageName: payload.imageName,
        strengthRating: payload.strengthRating,
        intelligenceRating: payload.intelligenceRating,
        speedRating: payload.speedRating,
        staminaRating: payload.staminaRating
      }
      state.catList.push(newCat);

    },
    ADD_STORY(state, payload) {
      const newStory ={
        catId: payload.catId,
      catName: payload.catName,
      adopterName: payload.adopterName,
      dateAdopted: payload.dateAdopted,
      successStory: payload.successStory,
      }
      state.storyList.push(newStory);
    },

    SET_STORY_LIST(state, data) {
      state.storyList = data;
    },
    
    UPDATE_RATINGS(state, payload){
     
          const { id, strengthRating,staminaRating,speedRating,intelligenceRating } = payload;
          const cat = state.catList.find(c => c.id === id);
          cat.strengthRating = strengthRating;
          cat.staminaRating=staminaRating;
          cat.speedRating=speedRating;
          cat.intelligenceRating=intelligenceRating;
      

    },
   

  }
})