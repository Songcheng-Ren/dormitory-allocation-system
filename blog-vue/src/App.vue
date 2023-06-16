<template>
  <div id="app">
    <cn-header v-if="this.$route.path!='/home' && this.$route.path!='/'" ></cn-header>
    <router-view name="sidebar"></router-view>
    <transition name="fade" mode="in-out">
      <router-view name="main" ></router-view>
    </transition>
    <el-backtop></el-backtop>
  </div>
</template>

<script>
import cnHeader from "./components/Header";
export default {
  name: "app",

  components: {
    cnHeader
  },
  
};
</script>

<style>
@import url(./font-style/font.css);
html {
  background: linear-gradient(
    90deg,
    rgba(247, 149, 51, 0.1),
    rgba(243, 112, 85, 0.1) 15%,
    rgba(239, 78, 123, 0.1) 30%,
    rgba(161, 102, 171, 0.1) 44%,
    rgba(80, 115, 184, 0.1) 58%,
    rgba(16, 152, 173, 0.1) 72%,
    rgba(7, 179, 155, 0.1) 86%,
    rgba(109, 186, 130, 0.1)
  );
}
#app {
  /* font-family: 'Avenir', Helvetica, Arial, sans-serif; */
  font-family: "PingFang";
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  font-size: 20px;
}
body,
div,
span,
a,
p,
ul,
li {
  margin: 0;
  padding: 0;
}

.fade-enter {
  opacity: 0;
}

.fade-leave {
  opacity: 1;
}

.fade-enter-active {
  transition: opacity 0.5s;
}

.fade-leave-active {
  opacity: 0;

  transition: opacity 0.5s;
}

</style>
