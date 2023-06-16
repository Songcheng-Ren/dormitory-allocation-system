// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui'                 // 引入element-ui
import 'element-ui/lib/theme-chalk/index.css'
import lottie from 'vue-lottie'
Vue.prototype.$http = axios;

axios.defaults.baseURL = 'http://localhost:9999'

import qs from 'qs'
Vue.prototype.$qs = qs

axios.defaults.withCredentials = true     // 添加代码：允许跨域携带cookie	

Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.component('lottie',lottie)



/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
Vue.filter('formatDate', function(str) {
		    if (!str) return ''
		    var date = new Date(str)
		    var time = new Date().getTime() - date.getTime() //现在的时间-传入的时间 = 相差的时间（单位 = 毫秒）
		    if (time < 0) {
		        return ''
		    } else if ((time / 1000 < 30)) {
		        return '刚刚'
		    } else if (time / 1000 < 60) {
		        return parseInt((time / 1000)) + '秒前'
		    } else if ((time / 60000) < 60) {
		        return parseInt((time / 60000)) + '分钟前'
		    } else if ((time / 3600000) < 24) {
		        return parseInt(time / 3600000) + '小时前'
		    } else if ((time / 86400000) < 31) {
		        return parseInt(time / 86400000) + '天前'
		    } else if ((time / 2592000000) < 12) {
		        return parseInt(time / 2592000000) + '月前'
		    } else {
		        return parseInt(time / 31536000000) + '年前'
		    }
		}
)