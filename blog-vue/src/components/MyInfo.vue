<template>
  <el-row :gutter="20">
    <el-col :span="4">
      <div class="grid-content bg-purple">
        <lottie
          :options="defaultOptions1"
          :width="600"
          v-on:animCreated="handleAnimation"
          style="margin-top:0px"
        />
      </div>
    </el-col>
    <el-col :span="15">
      <div class="grid-content bg-purple">
        <el-card class="box-card-center" shadow="hover">
          <div style="width:80%;height: 20%;border-radius: 100px;">
            <img
              style="width:20%;height: 20%;border-radius: 100px; display: table-cell; vertical-align: center; margin-left: 370px ;margin-bottom:30px"
              src="../assets/images/login_bg.jpg"
              class="image"
            />

            <el-descriptions
              :column="1"
              border
              title="基本信息"
              :content-style="{ 'text-align': 'center' }"
            >
              <el-descriptions-item label="用户名/学号" v-model="username"
                ><p class="message">{{ username }}</p></el-descriptions-item
              >
              <el-descriptions-item label="姓名" v-model="name" class="message"
                ><p class="message">{{ name }}</p></el-descriptions-item
              >
              <el-descriptions-item label="性别" v-model="sex" class="message"
                ><p class="message">{{ sex }}</p></el-descriptions-item
              >
              <el-descriptions-item label="性别" v-model="phone" class="message"
                ><p class="message">{{ phone }}</p></el-descriptions-item
              >
              <el-descriptions-item label="城市" v-model="city" class="message"
                ><p class="message">{{ city }}</p></el-descriptions-item
              >
              <el-descriptions-item
                label="学院"
                v-model="collage"
                class="message"
                ><p class="message">{{ collage }}</p></el-descriptions-item
              >
              <el-descriptions-item label="专业" v-model="major" class="message"
                ><p class="message">{{ major }}</p></el-descriptions-item
              >
              <el-descriptions-item
                label="邮箱号"
                v-model="email"
                class="message"
                ><p class="message">{{ email }}</p></el-descriptions-item
              >
              <el-descriptions-item
                label="个人简介"
                v-model="introduction"
                class="message"
                ><p class="message">{{ introduction }}</p></el-descriptions-item
              >
            </el-descriptions>
          </div>
        </el-card>
      </div>
    </el-col>
    <el-col :span="5">
      <div class="grid-content bg-purple">
        <el-card class="box-card-right">
          <el-menu :default-openeds="['1']">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-postcard"></i>账号信息</template
              >
              <el-menu-item-group>
                <router-link class="alink" to="/myinfo">
                  <el-menu-item index="1-1">
                    基本信息
                  </el-menu-item>
                </router-link>

                <router-link class="alink" to="/myinfoModify">
                  <el-menu-item index="1-2">
                    信息修改
                  </el-menu-item>
                </router-link>

                <router-link class="alink" to="/myinfoPic">
                  <el-menu-item index="1-3">
                    头像修改
                  </el-menu-item>
                </router-link>

                <router-link class="alink" to="/">
                  <el-menu-item index="1-4">
                    退出登陆
                  </el-menu-item>
                </router-link>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-card>
      </div>
      <lottie
        :options="defaultOptions2"
        :width="400"
        v-on:animCreated="handleAnimation"
        style="margin-top:0px"
      />
    </el-col>
  </el-row>
  <!-- <div>
  
    
  
  </div> -->
</template>

<script>
import * as myinfo1 from "../assets/lottie/myinfo1.json";
import * as myinfo2 from "../assets/lottie/myinfo2.json";
import lottie from "vue-lottie";
export default {
  name: "showinfo",
  components: {
    lottie
  },
  data() {
    return {
      username: sessionStorage.getItem("username"),
      name: sessionStorage.getItem("name"),
      city: sessionStorage.getItem("city"),
      email: sessionStorage.getItem("email"),
      collage: sessionStorage.getItem("collage"),
      major: sessionStorage.getItem("major"),
      sex: sessionStorage.getItem("sex"),
      introduction: sessionStorage.getItem("introduction"),
      phone:sessionStorage.getItem("phone"),
      defaultOptions1: {
        animationData: myinfo1
      },
      defaultOptions2: {
        animationData: myinfo2
      },
      animationSpeed: 1,
      anim: {}
    };
  },
  methods: {
    handleAnimation: function(anim) {
      console.log(anim); //这里可以看到 lottie 对象的全部属性
      this.defaultAnim = anim;
    }
  },
  
};
</script>

<style scoped>
.message {
  width: 20em;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.el-descriptions {
  margin-left: 30%;
}
.el-descriptions-item label {
  text-align: center;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.box-card-center {
  height: 700px;
  width: 900px;
  margin: 5% auto;
  padding-top: 5%;
}
.box-card-right {
  margin-top: 50px;
  width: 300px;
  height: 300px;
}

.alink {
  text-decoration: none;
}
</style>
