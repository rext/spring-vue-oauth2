<template>
  <div class="page-container">
    <router-view/>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  computed: mapState(["user"]),

  mounted: function() {
    this.$store.dispatch("SET_CURRENT_USER");
  }
};
</script>