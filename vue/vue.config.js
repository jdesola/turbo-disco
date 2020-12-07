module.exports = {
    configureWebpack: {
        module: {
      rules: [
        {
          test: /\.svg$/,
          use: [
            'vue-loader',
            'vue-svg-loader',
          ],
        },
      ],
    },
},
  };