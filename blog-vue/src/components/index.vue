<template>
  <iframe
    id="iframe"
    frameborder="0"
    border="0"
    :src="ifeData"
    scrolling="auto"
  >
    <el-backtop></el-backtop>
  </iframe>
</template>

<script>
export default {
  data() {
    return {
      ifeData: "../../static/index_0/index.html"
    };
  },
  mounted() {},
  methods: {
    queryMyInfo() {
      var that = this;
      this.$http
        .get("/queryInfo", {
          params: {
            username: sessionStorage.getItem("username")
          }
        })
        .then(function(data) {
          console.log(data.data);
          var _data = data.data;
          sessionStorage.setItem("name", _data.name);
          sessionStorage.setItem("city", _data.city);
          sessionStorage.setItem("email", _data.email);
          sessionStorage.setItem("collage", _data.collage);
          sessionStorage.setItem("major", _data.major);
          console.log(_data.sex)
          if (_data.sex === 0) {
            sessionStorage.setItem("sex", "男");
          } else {
            sessionStorage.setItem("sex", "女");
          }
          sessionStorage.setItem("introduction", _data.introduction);
          sessionStorage.setItem("phone",_data.phone)
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  },
  created(){
    this.queryMyInfo()
  }
};
</script>

<style>
#iframe {
  width: 100%;
  height: 100%;
}
</style>
