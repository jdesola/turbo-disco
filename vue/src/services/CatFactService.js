import axios from "axios";


export default {
    getCatFacts() {
        return axios.get('https://catfact.ninja/facts?limit=1&max_length=140');
    }
}

