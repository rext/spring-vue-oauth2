import { Param, Dictionary, Server, Job } from '../api';
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

function command(commit, type, cmd, name) {
  return new Promise((resolve, reject) => {
    cmd().then(resp => {
      commit(type, resp);
      resolve();
    })
      .catch(e => fail(e, name, reject))
  })
}

function fail(e, msg, reject) {
  reject({ error: e, msg: msg });
}