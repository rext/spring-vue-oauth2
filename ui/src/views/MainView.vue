<template>
  <div>
    <md-app>
      <md-app-toolbar class="md-primary">
          <md-avatar>
            <router-link to="/">
            </router-link>
          </md-avatar>        
        <h3 class="md-title" style="flex: 1">{{ title }}</h3>

        <md-menu md-direction="bottom-start">
          <md-button class="md-icon-button" md-menu-trigger>
            <md-icon>account_circle</md-icon>
          </md-button>        

          <md-menu-content>
            <md-menu-item>
              <md-avatar class="md-avatar-icon">
                <md-icon>home</md-icon>
              </md-avatar>              
              <span>{{user.name}}</span>              
            </md-menu-item>
            <md-menu-item>              
              <md-button class="md-primary" @click="logout">Logout</md-button>               
            </md-menu-item>
          </md-menu-content>
        </md-menu>

      </md-app-toolbar>

      <md-app-drawer md-permanent="full">
        <md-toolbar class="md-transparent" md-elevation="0">
          Navigation
        </md-toolbar>

        <md-list>
          <md-list-item>
            <md-icon>move_to_inbox</md-icon>
            <span class="md-list-item-text">Inbox</span>
          </md-list-item>

          <md-list-item>
            <md-icon>send</md-icon>
            <span class="md-list-item-text">Sent Mail</span>
          </md-list-item>

        </md-list>
      </md-app-drawer>

      <md-app-content>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
      </md-app-content>
    </md-app>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  computed: mapState(["title", "user"]),

  mounted: function() {
    this.$store.dispatch("SET_CURRENT_USER");
  },

  methods: {
    logout: function() {
      this.$store.dispatch('LOGOUT');
    }
  }
};
</script>

<style scoped>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;  
}
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

.md-app {
  min-height: 100vh;
  border: 1px solid rgba(#000, 0.12);
}

.md-drawer {
  width: 200px;
  max-width: calc(100vw - 125px);
}
</style>
