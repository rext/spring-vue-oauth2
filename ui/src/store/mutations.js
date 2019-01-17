// import Vue from "vue";

export default {
  SET_USER: (state, user) => {
    state.user.name = user;
  },

  SET_TITLE: (state, title) => {
    state.title = title;
  }
}