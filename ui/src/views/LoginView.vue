<template>
    <div>
      <div class="md-layout md-gutter md-alignment-center-center" style="min-height: 60vh">
        <div  class="md-layout-item  md-alignment-center-center">

          <div class="md-layout-item md-layout md-gutter" style="margin-bottom: 20px">
            <div class="md-layout-item"></div>
            <div class="md-layout-item md-alignment-center-center md-size-20">
              <span>
                <md-avatar>
                  logo
                </md-avatar>
              </span>
              <span class="md-title">Spring Boot Vue Oauth</span>
            </div>
            <div class="md-layout-item"></div>
          </div>  

          <div class="md-layout-item md-layout md-gutter">
            <div class="md-layout-item"></div>
            <div class="md-layout-item md-size-20"><md-button @click="authenticate" class="md-raised md-primary">Войти</md-button></div>
            <div class="md-layout-item"></div>
          </div>          
          
        </div>
      </div>
    </div>
</template>

<script>
export default {
  methods: {
    authenticate: function() {
      this.$store.dispatch("LOGIN");
    }
  }
};
</script>


