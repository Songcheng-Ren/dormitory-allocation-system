<template>
  <el-row :gutter="20" id="el-row">
    <el-col :span="16"
      ><div class="col-left">
        <el-card shadow="hover" class="box-card">
          <el-form ref="form" :model="form" label-width="auto">
            <h3>一、基础信息</h3>
            <el-form-item label="姓名">
              <el-input v-model="form.name" clearable></el-input>
            </el-form-item>
            <el-form-item label="学院">
              <el-input v-model="form.college" clearable></el-input>
            </el-form-item>
            <el-form-item label="专业">
              <el-input v-model="form.major" clearable></el-input>
            </el-form-item>
            <el-form-item label="省份">
              <el-input v-model="form.city" clearable></el-input>
            </el-form-item>
            <el-form-item label="手机号">
              <el-input v-model="form.phone" clearable></el-input>
            </el-form-item>
            <el-form-item label="性别">
              <el-radio-group v-model="form.sex" @change="status">
                <el-radio label="0">男</el-radio>
                <el-radio label="1">女</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
        </el-card>
        <el-card shadow="hover" class="box-card">
          <el-form
            ref="form"
            :model="form"
            label-width="auto"
            label-position="top"
          >
            <h3>二、生活习惯</h3>
            <el-form-item label="您是否有抽烟习惯？">
              <el-radio-group v-model="form.smoke">
                <el-radio label="-1">抽烟</el-radio>
                <el-radio label="1">不抽烟</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="您是否有洁癖？">
              <el-radio-group v-model="form.clean">
                <el-radio label="-1">有洁癖</el-radio>
                <el-radio label="0">程度适中</el-radio>
                <el-radio label="1">无洁癖</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="您睡觉时是否打呼噜？">
              <el-radio-group v-model="form.hulu">
                <el-radio label="-1">有打呼噜</el-radio>
                <el-radio label="1">不打呼噜</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="您是否玩网络游戏？">
              <el-radio-group v-model="form.game">
                <el-radio label="-1">玩游戏</el-radio>
                <el-radio label="1">不玩游戏</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="具体玩什么游戏呢？" v-show="form.game == -1">
              <el-input
                clearable
                v-model="form.gameName"
                placeholder="游戏名称"
              ></el-input>
            </el-form-item>
            <el-form-item label="您的社交状态？">
              <el-radio-group v-model="form.social">
                <el-radio label="-1">社牛型</el-radio>
                <el-radio label="1">社恐型</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="您是否接受榴莲、螺狮粉等异味食物？">
              <el-radio-group v-model="form.smell">
                <el-radio label="-1">能接受</el-radio>
                <el-radio label="1">不能接受</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="您的兴趣爱好偏向？">
              <el-radio-group v-model="form.interest">
                <el-radio label="-1">偏静型（类似读书、画画等）</el-radio>
                <el-radio label="0">动静结合型</el-radio>
                <el-radio label="1">偏动型（类似体育运动等）</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item label="说说你的爱好">
              <el-input
                clearable
                v-model="form.interestName"
                placeholder="爱好举例"
              ></el-input>
            </el-form-item>
            <el-form-item label="您的作息习惯？">
              <el-radio-group v-model="form.sleep">
                <el-radio label="-1">早睡早起</el-radio>
                <el-radio label="0">熬夜大户</el-radio>
                <el-radio label="1">正常作息</el-radio>
              </el-radio-group>
            </el-form-item>
            <el-form-item
              style="width: 80%;height: 120px"
              label="关于你的一段话(越详细匹配程度越高哦)"
              prop="form.introduction"
              :rules="[
                { required: false, message: '请输入个人简介', trigger: 'blur' },
                {
                  min: 0,
                  max: 150,
                  message: '请注意长度不能超过150个字符',
                  trigger: 'blur'
                }
              ]"
            >
              <el-input
                type="textarea"
                style="height: 100px;resize: none"
                v-model="form.introduction"
                @change="status"
              ></el-input>
            </el-form-item>
            <div style="text-align:center">
              <el-form-item>
                <el-button
                  type="primary"
                  @click="
                    onSubmit();
                    status();
                  "
                  >寻找我的室友</el-button
                >
                <el-button>取消</el-button>
              </el-form-item>
            </div>
          </el-form>
        </el-card>
      </div></el-col
    >
    <el-col :span="8">
      <div class="grid-content bg-purple">
        <el-card shadow="hover" class="box-card-s-top">
          <h5 style="margin:0">填写你的个人信息</h5>
          <h6 style="margin:0">我们将为你匹配最适合你的室友！</h6>
          <lottie
            :options="defaultOptions"
            :width="150"
            :height="150"
            v-on:animCreated="handleAnimation"
            style="margin-top:0px"
          />
        </el-card>
        <div style="height:150px"></div>
        <el-card shadow="hover" class="box-card-s-down">
          <el-steps
            direction="vertical"
            space="50px"
            finish-status="success"
            :active="active"
          >
            <el-step
              title="步骤 1"
              icon="el-icon-edit"
              description="基础信息"
            ></el-step>
            <el-step
              title="步骤 2"
              icon="el-icon-edit"
              description="生活习惯"
            ></el-step>
            <el-step
              title="步骤 3"
              description="提交"
              icon="el-icon-upload"
            ></el-step>
          </el-steps>
        </el-card>
      </div>
    </el-col>
    <!-- <el-backtop></el-backtop> -->
  </el-row>
</template>

<script>
import axios from "axios";
import * as animationData from "../assets/lottie/form.json";
import lottie from "vue-lottie";
export default {
  name: "form",
  components: {
    lottie
  },
  data() {
    return {
      form: {
        username: sessionStorage.getItem("username"),
        name: sessionStorage.getItem("name"),
        college: sessionStorage.getItem("collage"),
        phone: sessionStorage.getItem("phone"),
        sex: "",
        major: sessionStorage.getItem("major"),
        city: sessionStorage.getItem("city"),
        smoke: "",
        clean: "",
        hulu: "",
        game: "",
        social: "",
        smell: "",
        interest: "",
        sleep: "",
        introduction: "",
        gameName: "",
        interestName: ""
      },
      active: 0,
      defaultOptions: { animationData: animationData },
      animationSpeed: 1,
      anim: {}
    };
  },
  methods: {
    onSubmit() {
      var that = this;
      let formData = {
        username: this.form.username,
        name: this.form.name,
        college: this.form.college,
        major: this.form.major,
        phone: this.form.phone,
        city: this.form.city,
        sex: this.form.sex,
        smoke: this.form.smoke,
        hulu: this.form.hulu,
        game: this.form.game,
        clean: this.form.clean,
        social: this.form.social,
        smell: this.form.smell,
        interest: this.form.interest,
        sleep: this.form.sleep,
        introduction: this.form.introduction,
        gameName: this.form.gameName,
        interestName: this.form.interestName
      };
      console.log(formData);
      this.$http
        .post("/form", this.$qs.stringify(formData))
        .then((data) => {
          console.log(data);
          if (!data.data) {
            that.$notify({
              title: "不可重复填写哦!",
              message: "已经填写过，请转到匹配结果页面查看推荐！",
              offset: 100,
              type: "error"
            });
          } else {
            that.$notify({
              title: "提交成功!",
              message: "系统即将给你匹配适合的室友！",
              offset: 100,
              type: "success"
            });
            that.$router.push({
              path: "/result"
            });
          }
        })
        .catch(function(error) {
          console.log(error);
          that.$notify({
            title: "抱歉!",
            message: "好像出了一些错误",
            offset: 100,
            type: "error"
          });
        });
    },
    status() {
      if (this.active++ > 2) this.active = 0;
    },
    handleAnimation: function(anim) {
      console.log(anim); //这里可以看到 lottie 对象的全部属性
      this.defaultAnim = anim;
    }
  }
};
</script>

<style>
.el-row {
  margin-top: 10px;
}
.box-card {
  width: 500px;
  height: auto;
  margin: 20px auto;
}
.box-card-s-down {
  width: 200px;
  height: auto;
  margin: 30px auto;
  margin-top: 120px;
  margin-left: 0px;
  position: fixed;
}
.box-card-s-top {
  width: 200px;
  height: 220px;
  margin: 30px auto;
  margin-left: 0px;
  position: fixed;
}
</style>
