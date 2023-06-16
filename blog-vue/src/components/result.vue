<template>
  <el-row :gutter="20">
    <el-col :span="6"
      ><div class="grid-content bg-purple">
        <lottie
          :options="defaultOptions1"
          :width="400"
          :height="300"
          v-on:animCreated="handleAnimation"
          style="margin:10%"
        /></div
    ></el-col>
    <el-col :span="12"
      ><div class="grid-content bg-purple">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span style="font-size:28px">来看看我们为你匹配的室友</span>
            <el-button style="float: right; padding: 3px 0" type="text"
              >换一批？</el-button
            >
          </div>
          <!-- <el-table :data="Form" style="width: 100%" v-for="o in Form" :key="o">
            <el-table-column :prop="o.name" label="日期" width="180">
            </el-table-column>
            <el-table-column :prop="o.phone" label="姓名" width="180">
            </el-table-column>
            <el-table-column :prop="o.username" label="地址"> </el-table-column>
          </el-table> -->
          <h1 v-if="Form === ''">暂时还没有找到和你匹配度高的室友哦</h1>
          <div v-for="o in Form" :key="o" class="text item" v-else>
            {{ "姓名: " + o.name }} {{ "手机号: " + o.phone }} <br />{{
              "学号: " + o.username
            }}
          </div>
        </el-card>
      </div></el-col
    >
    <el-col :span="6"
      ><div class="grid-content bg-purple">
        <lottie
          :options="defaultOptions"
          :width="600"
          :height="400"
          v-on:animCreated="handleAnimation"
          style="margin-top:0px float:left"
        /></div
    ></el-col>
  </el-row>
</template>

<script>
import * as animationData from "../assets/lottie/result1.json";
import * as animationData1 from "../assets/lottie/breath.json";
export default {
  data() {
    return {
      Form: "",
      defaultOptions: { animationData: animationData },
      defaultOptions1: { animationData: animationData1 },
      animationSpeed: 1,
      anim: {}
    };
  },
  methods: {
    query() {
      var that = this;
      this.$http
        .get("/getResult", {
          params: {
            username: sessionStorage.getItem("username")
          }
        })
        .then(function(data) {
          console.log(data);
          that.Form = data.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    handleAnimation: function(anim) {
      console.log(anim); //这里可以看到 lottie 对象的全部属性
      this.defaultAnim = anim;
    }
  },
  mounted() {
    this.query();
  }
};
</script>

<style scoped>
.text {
  font-size: 24px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}

.box-card {
  width: 800px;
  height: 600px;
  margin: 10% auto;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
</style>
