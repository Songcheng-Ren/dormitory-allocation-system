<template>
  <el-card style="width:70%; margin:5% 10%;">
    <div style="width: 70%;margin-top: 5%">
      <div>
        <h2 style="margin-left:100px">填写你的个人信息</h2>
        <el-form
          :model="ruleForm"
          :rules="rules"
          ref="ruleForm"
          label-width="100px"
          class="demo-dynamic"
        >
          <el-form-item
            style="width: 49%"
            label="用户名"
            prop="username"
            :rules="[
              {
                required: true,
                message: '请填写13位学号',
                trigger: 'blur'
              },
              {
                min: 13,
                max: 13,
                message: '长度在为13位字符',
                trigger: 'blur'
              }
            ]"
          >
            <el-input v-model="ruleForm.username" clearable></el-input>
          </el-form-item>
          <el-form-item
            style="width: 49%"
            label="姓名"
            prop="name"
            :rules="[
              {
                required: true,
                message: '请注意长度在2~5个字符',
                trigger: 'blur'
              },
              {
                min: 2,
                max: 5,
                message: '长度在 2 到 5 个字符',
                trigger: 'blur'
              }
            ]"
          >
            <el-input v-model="ruleForm.name" clearable></el-input>
          </el-form-item>
          <el-form-item label="性别" prop="region">
            <el-select
              v-model="ruleForm.sex"
              placeholder="请选择性别"
              :rules="{ required: true }"
            >
              <el-option label="男" value="0"></el-option>
              <el-option label="女" value="1"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item
            style="width: 49%"
            label="手机号"
            prop="phone"
            :rules="[
              {
                required: true,
                message: '请注意长度为11个字符',
                trigger: 'blur'
              },
              {
                min: 11,
                max: 11,
                message: '长度为11个字符',
                trigger: 'blur'
              }
            ]"
          >
            <el-input v-model="ruleForm.phone" clearable></el-input>
          </el-form-item>
          <el-form-item
            style="width: 49%"
            label="省份"
            prop="city"
            :rules="[
              {
                required: true,
                message: '请注意长度在2~10个字符',
                trigger: 'blur'
              },
              {
                min: 2,
                max: 10,
                message: '长度在 2 到 10 个字符',
                trigger: 'blur'
              }
            ]"
          >
            <el-input v-model="ruleForm.city" clearable></el-input>
          </el-form-item>
          <el-form-item
            style="width: 49%"
            label="学院"
            prop="collage"
            :rules="[
              {
                required: true,
                message: '请注意长度在2~10个字符',
                trigger: 'blur'
              },
              {
                min: 2,
                max: 10,
                message: '长度在 2 到 10 个字符',
                trigger: 'blur'
              }
            ]"
          >
            <el-input v-model="ruleForm.collage" clearable></el-input>
          </el-form-item>
          <el-form-item
            style="width: 49%"
            label="专业"
            prop="major"
            :rules="[
              {
                required: true,
                message: '请注意长度在2~10个字符',
                trigger: 'blur'
              },
              {
                min: 2,
                max: 10,
                message: '长度在 2 到 10 个字符',
                trigger: 'blur'
              }
            ]"
          >
            <el-input v-model="ruleForm.major" clearable></el-input>
          </el-form-item>
          <el-form-item
            style="width: 60%"
            prop="email"
            label="邮箱"
            :rules="[
              { required: true, message: '请输入邮箱地址', trigger: 'blur' },
              {
                type: 'email',
                message: '请输入正确的邮箱地址',
                trigger: ['blur', 'change']
              }
            ]"
          >
            <el-input v-model="ruleForm.email" clearable></el-input>
          </el-form-item>
          <el-form-item
            style="width: 80%;height: 120px"
            label="个人简介"
            prop="introduction"
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
              v-model="ruleForm.introduction"
              clearable></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm(), setDataFlag()"
              >提交</el-button
            >
          </el-form-item>
        </el-form>
        <!-- <lottie
          :options="defaultOptions1"
          :width="600"
          v-on:animCreated="handleAnimation"
          style="margin-top:0px;position:absolute;left:42%;top:0"
        /> -->
        <lottie
          :options="defaultOptions2"
          :width="500"
          v-on:animCreated="handleAnimation"
          style="margin-top:0px;position:absolute;left:42%;top:0"
        />
      </div></div
  ></el-card>
</template>

<script>
import * as myinfo1 from "../assets/lottie/myinfo1.json";
import * as myinfo2 from "../assets/lottie/planet.json"
import lottie from "vue-lottie";
export default {
  name: "infoeditor",
  data() {
    return {
      ruleForm: {
        username: sessionStorage.getItem("username"),
        name: sessionStorage.getItem("name"),
        city: sessionStorage.getItem("city"),
        email: sessionStorage.getItem("email"),
        collage: sessionStorage.getItem("collage"),
        major: sessionStorage.getItem("major"),
        sex: sessionStorage.getItem("sex"),
        introduction: sessionStorage.getItem("introduction"),
        phone:sessionStorage.getItem("phone")
      },
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
    submitForm() {
      var that = this;
      var formData = this.ruleForm;
      if (formData.sex === "男") {
        formData.sex = 0;
      } else {
        formData.sex = 1;
      }
      this.$http
        .post("/insertInfo", this.$qs.stringify(formData))
        .then(function(data) {
          console.log(data);

          that.$notify({
            title: "成功",
            message: "我们已经收到你的资料！",
            type: "success",
            offset: 100
          });
          that.$router.push({
            path: "/index"
          });
        })
        .catch(function(error) {
          console.log(error);
          that.$notify({
            title: "出错了!",
            message: "好像遇到了一些问题哦",
            type: "error",
            offset: 100
          });
        });
    },
    setDataFlag() {
      this.$http
        .get("/setDataFlag", {
          params: {
            username: sessionStorage.getItem("username")
          }
        })
        .then(function(data) {
          console.log(data);
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    handleAnimation: function(anim) {
      console.log(anim); //这里可以看到 lottie 对象的全部属性
      this.defaultAnim = anim;
    }
  }
};
</script>

<style scoped></style>
