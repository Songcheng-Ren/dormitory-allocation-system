项目介绍

“The Choosen”——个性化室友匹配系统

1.匹配功能：用户填写表单，基于表单结果匹配相似人群；
2.论坛功能：用户可以在论坛发布说说，同时可以浏览，评论，点赞，其他用户发布的信息。
3.登录注册功能:提供用户注册登录功能
4.资料功能：展示个人信息并可以修改；
5.预览功能：用户可以查看学校寝室的3D模型，提供桌床具体参数。


技术介绍

前端： vue + vue-router + axios + elementui 

后端： SpringBoot + MyBatis+ Mysql + GRPC + paddlepaddle



运行环境需求

Windows10/Windows11平台 jdk1.8 idea2019及以上 node.js6.0及以上 vue2.0
python>=3.7 numpy==1.23.4 grpcio==1.50.0 grpcio-tools==1.50.0（python环境具体参考TextSimilarity/requirements.txt）


项目部署

	前端运行：打开blog-vue目录，在终端中输入 npm install
		      依赖安装完成后输入npm run dev（默认运行在8080端口）
	后端运行：打开blog.sql 创建数据表
		       打开blog-springboot\src\main\resources\application.properties 		       修改数据库配置信息（默认运行在9999端口）
	python端运行：打开TextSimilarity文件夹，输入指令 pip install -r       			               requirements.txt 安装python第三方模块，然后在终端输入          			    python server.py运行python服务器（默认运行在50052端口）



目录结构

前端项目位于blog-vue下。

后端项目位于blog-springboot下。

SQL文件位于根目录下的blog.sql，需要MYSQL8以上版本。

python服务器在TextSimilarity文件夹下



