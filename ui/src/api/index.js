import Vue from 'vue';

export const Server = {
  logout: () => Vue.axios.post('/logout', null, {withCredentials: true, baseURL: '/', transformResponse: null})
};