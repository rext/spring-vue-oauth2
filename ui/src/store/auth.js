import Vue from 'vue';
import VueAuthenticate from 'vue-authenticate';
import VueAxios from 'vue-axios';
import axios from 'axios';
import config from '../config'
import router from '../router'

axios.defaults.baseURL = config.apiUrl;
axios.defaults.transformResponse = data => data ? JSON.parse(data) : data;

axios.interceptors.response.use(function (response) {
  return response;
}, function (error) {
  if(error.message === 'Network Error') {
    router.go('/login');
  }
  return Promise.reject(error);
});

Vue.use(VueAxios, axios);

const auth = VueAuthenticate.factory(Vue.prototype.$http, {
  baseUrl: config.apiUrl,
  storageType: 'cookieStorage',
  providers: {
    oauth2: {
      name: 'spring-vue-oauth',
      state: 'qwerty',
      clientId: 'webui',
      redirectUri: config.redirectUrl,
      authorizationEndpoint: '/oauth/authorize',      
      responseType: "token",
      popupOptions: { width: 500, height: 560 }
    }    
  }
});

export default auth;