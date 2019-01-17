import Vue from 'vue';
import Vuex from 'vuex';
import actions from './actions';
import mutations from './mutations';
import vueAuth from './auth'
import auth from './auth';

Vue.use(Vuex);

export default new Vuex.Store({
  strict: true,
  state: {
    title: null,
    user: {
      name: null
    }
  },
  getters: {
    isAuthenticated: () => vueAuth.isAuthenticated(),

    accessToken: () => auth.getToken()
  },  
  actions,
  mutations
})
