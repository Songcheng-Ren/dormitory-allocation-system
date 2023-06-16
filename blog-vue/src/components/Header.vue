<template>
  <div class="Header">
    <!-- <router-link :to="{name:'root'}">
			<img src="../assets/cnodejs_light.svg"/>
		</router-link> -->

    <el-menu
      :default-active="this.$route.path"
      :collapse="isCollapse"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      :collapse-transition="true"
      :router="true"
    >
      <el-menu-item :index="navHome.name">
        <i class="el-icon-ship"></i>
        <span>{{ navHome.navItem }}</span>
      </el-menu-item>
      <el-menu-item
        v-for="(item, i) in navList"
        :key="i"
        :index="item.name"
        style="float:right"
      >
        <i v-bind:class="item.icon"></i>
        <span>{{ item.navItem }}</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      activeIndex2: "1",
      navHome: { name: "/index", navItem: "The Choosen", icon: "el-icon-ship" },
      navList: [
        { name: "/myinfo", navItem: "个人中心", icon: "el-icon-user" },
        {
          name: "/ca",
          navItem: "论坛中心",
          icon: "el-icon-chat-dot-round"
        },
        {
          name: "/result",
          navItem: "匹配结果",
          icon: "el-icon-postcard"
        },
        { name: "/form", navItem: "我的表单", icon: "el-icon-document" },
        { name: "/model3D", navItem: "3D建模", icon: "el-icon-suitcase" }
      ],
      isCollapse: false //导航栏默认为展开
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.Header {
  background: #545c64;
  height: 61px;
  /* opacity:0.6 */
}
a {
  text-decoration: none;
  color: #cbc9c9;
}
img {
  max-width: 120px;
  margin-left: 50px;
  margin-top: 10px;
}
/* span {
	float: right;
	margin-right: 50px;
	margin-top: 10px;
  } */
  .el-menu.el-menu--horizontal {
    border-bottom: 0;
}
</style>
