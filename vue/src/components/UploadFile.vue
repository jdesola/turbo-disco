<template>
<div>
    <v-btn @click="click1">Choose a Photo</v-btn>
    <input type="file" ref="input1"  style="display: none" @change="previewImage" accept="image/*">
    <button @click.prevent="onUpload">Upload</button>

    <div v-if="imageData!=null">
        <img class="preview" height="268" width="356" :src="img1">
    </div>

    </div>
</template>

<script>
import firebase from 'firebase';


export default {
    name:'UploadPhoto',
    data(){
        return{
            imageData: null,
            img1: null,
            imgUrl: null,
        }
    },

methods:{
    click1() {
        this.$refs.input1.click()
    },
    previewImage(event) {
        this.uploadValue=0;
        this.img1=null;
        this.imageData = event.target.files[0];
        this.onUpload();
    },
    onUpload(){
        this.img1=null;

        const storageRef=firebase.storage().ref(`${this.imageData.name}`).put(this.imageData);
        storageRef.on(`state_changed`, snapshot =>{
            this.uploadValue = (snapshot.bytesTransferred/snapshot.totalBytes)*100;
        }, error=>{console.log(error.message)},
        ()=>{this.uploadValue=100;

        
        });
        this.afterComplete(this.imageData);
        },
        async afterComplete(imageData) {
            try {
                const imageName = imageData.name;
                const storageRef = firebase.storage().ref();
                const imageRef = storageRef.child(`${imageName}`);

                const downloadUrl = await imageRef.getDownloadURL();
                this.$emit(downloadUrl);
            } catch (error) {
                console.log(error);
            }
        }
    },
}

</script>

<style>

</style>