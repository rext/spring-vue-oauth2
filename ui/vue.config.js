module.exports = {
  baseUrl: process.env.NODE_ENV === 'production' ? '/ui/' : '/', 
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true
      },
      '/logout': {
        target: 'http://localhost:8080',
        changeOrigin: true
      },
      '/oauth/authorize': {
        target: 'http://localhost:8080'
      }
    }
  }
};
