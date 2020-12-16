
import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';
import colors from 'vuetify/lib/util/colors'

Vue.use(Vuetify);

export default new Vuetify({
  icons: {
    iconfont: 'mdiSvg', // 'mdi' || 'mdiSvg' || 'md' || 'fa' || 'fa4' || 'faSvg'
  },
  theme: {
    themes: {
      light: {
        primary: '#000',
        secondary: '#33a3f5',
        accent: "#c24a15",
        error: colors.red.accent3,
        info: "#f6af71",
        background: '#adcff0'// Not automatically applied
    
      },
      dark: {
        
       
        background: colors.indigo.base, // If not using lighten/darken, use base to return hex
    
      },
    },
  },
});
  
