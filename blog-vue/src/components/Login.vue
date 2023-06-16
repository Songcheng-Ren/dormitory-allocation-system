<template>
  <div id="app" class="container">
    <img src="../assets/images/login_bg0.jpg" alt="" />
    <div class="panel">
      <div class="content login">
        <div class="switch">
          <span :class="{ active: active === 'login' }" @click="go('login')"
            >登录</span
          >
          <span>/</span>
          <span
            :class="{ active: active === 'register' }"
            @click="go('register')"
            >注册</span
          >
        </div>
        <div class="form" id="fromLogin">
          <!-- 如果按钮选择的是注册就展示这个里面的内容 -->
          <template v-if="active === 'register'">
            <div class="input">
              <input
                :class="{ hasValue: registerForm.email }"
                v-model="registerForm.email"
                type="text"
                name="email"
                id="email"
              />
              <label for="email">邮箱</label>
            </div>
            <div class="input">
              <input
                :class="{ hasValue: registerForm.Username }"
                v-model="registerForm.Username"
                type="text"
                name="Username"
                id="Username"
                @blur="checkRegisterUsername"
              />
              <label for="email">学号</label>
            </div>
            <div class="input">
              <input
                :class="{ hasValue: registerForm.Password }"
                v-model="registerForm.Password"
                type="password"
                name="Password"
                id="Password"
              />
              <label for="email">密码</label>
            </div>
            <div class="input">
              <input
                :class="{ hasValue: registerForm.repeat }"
                v-model="registerForm.repeat"
                type="password"
                name="Passwordrepeat"
                id="Passwordrepeat"
                @blur="checkRepeatPassword"
              />
              <label for="email">重复密码</label>
            </div>
          </template>
          <!-- 如果按钮选择的是登录就展示这个里面的内容 -->
          <div>
            <div class="input" v-if="active === 'login'">
              <input
                :class="{ hasValue: loginForm.Username }"
                v-model="loginForm.Username"
                type="text"
                name="Username"
                id="Username"
                @blur="checkLoginUsername"
                
              />
              <label for="email">学号</label>
            </div>
            
            <div class="input" v-if="active === 'login'">
              <input
                :class="{ hasValue: loginForm.Password }"
                v-model="loginForm.Password"
                type="password"
                name="Password"
                id="Password"
              />
              <label for="email">密码</label>
            </div>
          </div>
          <!-- <span>忘记密码?</span> -->
          <button type="submit" @click="submit">登录</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Message } from "element-ui";
export default {
  // el: '#app',
  data() {
    return {
      active: "login",
      registerForm: {
        email: "",
        Username: "",
        Password: "",
        repeat: ""
      },
      loginForm: {
        Username: "",
        Password: ""
      }
    };
  },
  methods: {
    go(type) {
      this.active = type;
    },
    submit() {
      
      var that = this;
      if (this.active === "login") {
        console.log("login", this.loginForm);
        // 将用户名存到session
        sessionStorage.setItem("username",this.loginForm.Username)
        
        if (this.loginForm.Username === "" || this.loginForm.Password === "") {
          Message.warning("请填写完整用户名或密码");
        } else {
          //ajax把登录数据发送到后端
          this.$http
            .post("/login", this.$qs.stringify(this.loginForm))
            .then(function(data) {
              console.log(data);
              if (data.data) {
                Message.success({
                    message:"登录成功！即将为您跳转！",
                    duration:1500
                });
                that.$router.push({
                  path: "/home"
                });
              } else{
                Message.error({
                    message:"用户名或密码错误！",
                    duration:1500
                });
                that.loginForm = ['','']
              }
            })
            .catch(function(error) {
              console.log(error);
              Message.error({
                    message:"服务器好像出了点问题~",
                    duration:1500
                });
            });
        }
      }
      if (this.active === "register") {
        console.log("register", this.registerForm);
        // 将用户名存到session
        sessionStorage.setItem("username",this.registerForm.Username)
        //ajax把注册数据发送到后端
        this.$http
          .post("/register", this.$qs.stringify(this.registerForm))
          .then(function(data) {
            console.log(data);
            if(data.data){
                Message.success({
                    message:"注册成功！即将为您跳转！",
                    duration:1500
                });
                that.$router.push({
                  path: "/home"
                });
            } else{
                Message.error({
                    message:"该学号已经注册过！",
                    duration:1500
                });
                that.registerForm = ['','','','']
            }
          })
          .catch(function(error) {
            console.log(error);
          });
      }
    },
    checkLoginUsername() {
        if (!/^\d{13}/.test(this.loginForm.Username)) {
            Message.warning("请正确输入学号！");
            this.loginForm.Username = ''
            return false;
        }
    },
    checkRegisterUsername() {
        if (!/^\d{13}/.test(this.registerForm.Username)) {
            Message.warning("请正确输入学号！");
            this.registerForm.Username = ''
            return false;
        }
    },
    checkRepeatPassword() {
        if(this.registerForm.Password!=this.registerForm.repeat){
            Message.warning("两次输入的密码不同！");
            this.registerForm.Password = ''
            this.registerForm.repeat = ''
        }
    },
  
    
  }
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
}

body {
  /* 100%的窗口高度 */
  height: 100vh;
  /* 弹性布局 水平 + 垂直居中 */
  display: flex;
  justify-content: center;
  align-items: center;
  /* 引入字体 */
  /* font-family: miaowu; */
  /* 渐变背景 */
  /* background: linear-gradient(45deg,rgb(243, 199, 223),rgb(252, 205, 228)) fixed; */
}

.container {
  /* 相对定位 */
  position: relative;
  left:80px;
  width: 70rem;
}

.container img {
  width: 70rem;
}

.switch span {
  color: #ccc;
  font-size: 1.4rem;
  /* 鼠标放上变小手 */
  cursor: pointer;
}
.switch span.active {
  color: #ff2c75;
}

.panel {
  width: 30%;
  margin: 10rem 0 0;
  position: absolute;
  right: 0;
  top: 0;
  display: flex;
  justify-content: center;
}

.form {
  width: 12rem;
  margin: 3rem 0 0;
}

.form .input {
  position: relative;
  opacity: 1;
  height: 2rem;
  width: 100%;
  margin: 2rem 0;
  transition: 0.4s;
}

.form input {
  outline: none;
  width: 100%;
  border: none;
  border-bottom: 0.1rem solid rgb(181, 154, 254);
  position: relative;
  line-height: 35px;
  background-color: transparent;
  z-index: 1;
}

.form label {
  position: absolute;
  left: 0;
  top: 20%;
  font-size: 1.2rem;
  color: rgb(129, 101, 207);
  transition: 0.3s;
}

.hasValue ~ label,
input:focus ~ label {
  top: -50%;
  font-size: 0.9rem;
}

.form span {
  display: block;
  color: #ff2c75;
  font-size: 0.8rem;
  cursor: pointer;
}

.form button {
  border: none;
  outline: none;
  margin: 2.5rem 0 0;
  width: 100%;
  height: 3rem;
  border-radius: 3rem;
  background-color: #ff2c75;
  box-shadow: 0 0 8px rgb(181, 154, 254);
  cursor: pointer;
  color: white;
}

#live2dcanvas {
  border: 0 !important;
}
</style>
