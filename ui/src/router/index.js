import Vue from 'vue'
import Router from 'vue-router'
import MainView from '../views/MainView.vue'
import LoginView from '../views/LoginView.vue'
import config from '../../vue.config'
import auth from '../store/auth'
import store from '../store'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: config.baseUrl,
  routes: [
    {
      path: '/',
      component: MainView,
      meta: {title: "Main page"}
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView,
      meta: {title: "Login"},
    }
  ]
});

router.beforeEach((to, from, next) => {
  const title = to.meta.title;
  document.title = title;
  store.commit('SET_TITLE', title);

  const authenticated = auth.isAuthenticated();
  if (to.name === 'login' && authenticated) {
    next('/');
  }
  else if (to.path === '/login' ||
    to.path === '/token' ||
    authenticated) {
    next();
  }
  else {
    next('/login');
  }
});

export default router;
