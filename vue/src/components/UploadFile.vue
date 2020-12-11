<template>
<div>
    <input type="file" @change="onFileSelected">
    <button @click.prevent="onUpload">Upload</button>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name:'UploadPhoto',
    data(){
        return{
            selectedFile: null
        }
    },

methods:{
    onFileSelected(event){
        this.selectedFile = event.target.files[0]
    },
    onUpload(){
        const fd = new FormData();
<<<<<<< HEAD
        fd.append('image', this.selectedFile, this.selectedFile.name);
            axios.post('gs://catch-file-uploader.appspot.com', fd).then(res => {
=======
        fd.append('image', this.selectedFile, this.selectedFile.name)
        axios.post('gs://catch-file-uploader.appspot.com/', fd.then(res => {
>>>>>>> 076e25128b8fcf83607cd2a62e26cebf980832b8
            console.log(res)
        })

        

    }
}
}
</script>

<style>

</style>