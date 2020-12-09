import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });

export default {

    list() {
        return http.get('/cats');
    },

    addCat(newCat) {
        return http.post('/cats/addCat', newCat);
    }
}