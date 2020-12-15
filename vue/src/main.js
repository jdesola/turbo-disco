import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import VueFuse from 'vue-fuse'
import firebase from 'firebase'
import vuetify from './plugins/vuetify'
import isotope from 'isotope-layout'


Vue.use(VueFuse)

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  isotope,
  router,
  store,
  render: h => h(App),
  vuetify,

  created () {
    var firebaseConfig = {
      apiKey: "AIzaSyBDArk4REPhi-gKiixOp6eHcrlPryYoyho",
      authDomain: "catch-file-uploader.firebaseapp.com",
      projectId: "catch-file-uploader",
      storageBucket: "catch-file-uploader.appspot.com",
      messagingSenderId: "434300650384",
      appId: "1:434300650384:web:ed92d0b3293fc841c8a915",
      measurementId: "G-ZZ5ED38NZZ"
    };
    firebase.initializeApp(firebaseConfig);
    firebase.analytics();
  }
}).$mount('#app')
