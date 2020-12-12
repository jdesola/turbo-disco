import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });

export default {

    getCats() {
        return http.get('/cats');
    },

    addCat(newCat) {
        return http.post('/cats/addCat', newCat);
    },

    updateCat(updatedCat) {
        return http.put(`/cats`, updatedCat);
    },

    // featureCat(featuredCat){
    //     return http.put("/cats", featuredCat);
    // }
}