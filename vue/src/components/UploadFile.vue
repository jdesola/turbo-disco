<template>
<div>
    <input type="file" @change="onFileSelected">
    <button @click="onUpload">Upload</button>
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
        fd.append('image', this.selectedFile, this.selectedFile.name)
        axios.post('CLOUD URL PLACEHOLDER', fd.then(res => {
            console.log(res)
        }))

    }
}
}
</script>

<style>

</style>