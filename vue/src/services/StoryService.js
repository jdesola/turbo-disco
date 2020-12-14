import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });

export default {

    getStories() {
        return http.get('/successStories');
    },

    addStory(newStory) {
        return http.post('/tools/successStoryForm', newStory);
    },
}