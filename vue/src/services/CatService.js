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

    deleteCat(catId) {
        return http.delete(`/cats/${catId}`);
    },

    featureCat(featuredCat){
        return http.put("/cats", featuredCat);
    }
}