
const app = new Vue({
    el: '#main',
   
    data: {
        result: "",
        responseAvailable: false,
        apiKey: '<9a1eac439fmsh40558f4c87b06c7p13e515jsn9c3b5cefc1e7>'
    },
    methods: {
        fetchAPIData( ) { 
            this.responseAvailable = false;
            fetch("https://brianiswu-cat-facts-v1.p.rapidapi.com/facts", {
	"method": "GET",
	"headers": {
		"x-rapidapi-key": "9a1eac439fmsh40558f4c87b06c7p13e515jsn9c3b5cefc1e7",
		"x-rapidapi-host": "brianiswu-cat-facts-v1.p.rapidapi.com"
	}
})
.then(response => {
	console.log(response);
})
.catch(err => {
	console.error(err);
});
        }
    }
})
