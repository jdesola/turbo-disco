import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';
import colors from 'vuetify/lib/util/colors'

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        themes: {
          light: {
            primary: '#000',
            secondary: '#33a3f5',
            accent: colors.shades.white,
            error: colors.red.accent3,
            info: colors.shades.white,
            background: '#EEEEEE'// Not automatically applied
        
          },
          dark: {
            primary: colors.blue.lighten3, 
            background: colors.indigo.base, // If not using lighten/darken, use base to return hex
        
          },
        },
      },
    });