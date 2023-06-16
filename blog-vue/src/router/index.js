import Vue from 'vue'
import Router from 'vue-router'
import Form from '@/components/Form'
import model3D from '@/components/3D'
import Home from '@/components/Home'
import Login from '@/components/Login'
import MyInfo from '@/components/MyInfo'
import myinfoModify from '@/components/myinfoModify'
import index from '@/components/index'
import result from '@/components/result'
import communityactivuty from '@/components/communityactivity'
Vue.use(Router)

export default new Router({
	mode: 'history',
  routes: [
	// 默认 / 显示登录页面
	{
		path:"/",
		name:'login',
		components:{
			main:Login
		}
	},
    {
      path: '/index',
      name: 'root',
      components: {
      	main:index
      }
    },
	{
		path:'/form',
    	name:'表单填写',
    	components:{
    		main:Form,
    	}
	},{
		path:'/model3D',
    	name:'3D建模',
    	components:{
    		main:model3D,
    	}
	},
	{
		path:'/home',
    	name:'home',
    	components:{
    		main:Home,
    	}
	},{
		path:'/myinfo',
		name:'MyInfo',
		components:{
    		main:MyInfo,
    	}
	},{
		path:'/myinfoModify',
		name:'MyInfoModify',
		components:{
			main:myinfoModify
		}
	},{
		path:'/result',
		name:'Result',
		components:{
			main:result
		}
	},{
		path:'/ca',
		name:'Ca',
		components:{
			main:communityactivuty
		}
	}
  ]
})
