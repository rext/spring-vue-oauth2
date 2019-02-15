import { Server } from '../api';
import auth from './auth';
import jwtDecode from 'jwt-decode';
import router from '../router'

export default {
  LOGIN() {
    auth.authenticate('oauth2').then(() => {
      router.replace('/');
    })
  },

  LOGOUT({ commit }) {
    Server.logout().then(() => {
      auth.logout().then(() => {
        commit('SET_USER', null);
        router.push('/login');
      })
    })
    .catch(() => {
      auth.logout().then(() => {
        commit('SET_USER', null);
        router.push('/login');
      });      
    });
  },

  SET_CURRENT_USER({ commit }) {
    const token = auth.getToken();
    if (token) {
      const jwt = jwtDecode(token);
      commit('SET_USER', jwt.user_name);
    }
  }
}

