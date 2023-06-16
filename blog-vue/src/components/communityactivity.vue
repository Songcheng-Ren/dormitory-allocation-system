<template>
  <div>
    <div>
      <h2 style="font:bolder; float:center; margin-left: 45%;">论坛中心</h2>
    </div>
    <lottie
    :options="defaultOptions"
    :width="300"
    :height="300"
    v-on:animCreated="handleAnimation"
    style="margin-top:0px; float:right"
  />
    <el-card style="margin:2% 5%">
      <div style="margin-left: 10%;">
        <div v-clickoutside="hideReplyBtn" @click="inputFocus" class="my-reply">
          <el-avatar class="header-img" :size="40" :src="myHeader"></el-avatar>
          <div class="reply-info">
            <div
              tabindex="0"
              contenteditable="true"
              id="replyInput"
              spellcheck="false"
              placeholder="输入评论..."
              class="reply-input"
              @focus="showReplyBtn"
              @input="onDivInput($event)"
            ></div>
          </div>
          <div class="reply-btn-box" v-show="btnShow">
            <el-button
              class="reply-btn"
              size="medium"
              @click="sendComment"
              type="primary"
              >发表评论</el-button
            >
          </div>
        </div>
        <el-divider></el-divider>
        <div
          v-for="(item, i) in comments"
          :key="i"
          class="author-title reply-father"
        >
          <el-avatar
            class="header-img"
            :size="40"
            :src="item.headImg"
          ></el-avatar>
          <div class="author-info">
            <span class="author-name">{{ item.name }}</span>
            <span class="author-time">{{ item.time }}</span>
          </div>
          <div class="icon-btn">
            <span @click="showReplyInput(i, item.name, item.id)"
              ><i class="iconfont el-icon-s-comment"></i
              >{{ item.commentNum }}</span
            >
            <i class="iconfont el-icon-caret-top"></i>{{ item.like }}
          </div>
          <div class="talk-box">
            <p>
              <span class="reply">{{ item.comment }}</span>
            </p>
          </div>
          <div class="reply-box">
            <div v-for="(reply, j) in item.reply" :key="j" class="author-title">
              <el-avatar
                class="header-img"
                :size="40"
                :src="reply.fromHeadImg"
              ></el-avatar>
              <div class="author-info">
                <span class="author-name">{{ reply.from }}</span>
                <span class="author-time">{{ reply.time }}</span>
              </div>
              <div class="icon-btn">
                <span @click="showReplyInput(i, reply.from, reply.id)"
                  ><i class="iconfont el-icon-s-comment"></i
                  >{{ reply.commentNum }}</span
                >
                <i class="iconfont el-icon-caret-top"></i>{{ reply.like }}
              </div>
              <div class="talk-box">
                <p>
                  <span>回复 {{ reply.to }}:</span>
                  <span class="reply">{{ reply.comment }}</span>
                </p>
              </div>
              <div class="reply-box"></div>
              <el-divider></el-divider>
            </div>
          </div>
          <div v-show="_inputShow(i)" class="my-reply my-comment-reply">
            <el-avatar
              class="header-img"
              :size="40"
              :src="myHeader"
            ></el-avatar>
            <div class="reply-info">
              <div
                tabindex="0"
                contenteditable="true"
                spellcheck="false"
                placeholder="输入评论..."
                @input="onDivInput($event)"
                class="reply-input reply-comment-input"
              ></div>
            </div>
            <div class=" reply-btn-box">
              <el-button
                class="reply-btn"
                size="medium"
                @click="sendCommentReply(i, j)"
                type="primary"
                >发表评论</el-button
              >
            </div>
          </div>
        </div>
      </div>
    </el-card>
  </div>
</template>
<script>
import * as animationData from "../assets/lottie/comments.json";
const clickoutside = {
  // 初始化指令
  bind(el, binding, vnode) {
    function documentHandler(e) {
      // 这里判断点击的元素是否是本身，是本身，则返回
      if (el.contains(e.target)) {
        return false;
      }
      // 判断指令中是否绑定了函数
      if (binding.expression) {
        // 如果绑定了函数 则调用那个函数，此处binding.value就是handleClose方法
        binding.value(e);
      }
    }
    // 给当前元素绑定个私有变量，方便在unbind中可以解除事件监听
    el.vueClickOutside = documentHandler;
    document.addEventListener("click", documentHandler);
  },
  update() {},
  unbind(el, binding) {
    // 解除事件监听
    document.removeEventListener("click", el.vueClickOutside);
    delete el.vueClickOutside;
  }
};
export default {
  name: "ArticleComment",
  data() {
    return {
      btnShow: false,
      index: "0",
      replyComment: "",
      myName: "Lana Del Rey",
      myHeader:
        "https://ae01.alicdn.com/kf/Hd60a3f7c06fd47ae85624badd32ce54dv.jpg",
      myId: 19870621,
      to: "",
      toId: -1,
      defaultOptions: { animationData: animationData },
      animationSpeed: 1,
      anim: {},
      comments: [
        {
          name: "大一软件学院某女生",
          id: 2020141461000,
          headImg:
            "https://ae01.alicdn.com/kf/Hd60a3f7c06fd47ae85624badd32ce54dv.jpg",
          comment:
            "性格善良，熟了之后会很活泼，刚开始可能害羞。；喜欢美食；不抽烟，不喝酒；熬夜，但十分安静，十分爱熬夜赶DDL更吸引有作息规律的室友能够带我早睡早起哈哈哈。关于室友：互相尊重，互相帮助；一起打扫卫生；",
          time: "2019年9月16日 18:43",
          commentNum: 2,
          like: 15,
          inputShow: false,
          reply: [
            {
              from: "大一软件学院某女生某某",
              fromId: 19891221,
              fromHeadImg:
                "https://ae01.alicdn.com/kf/H94c78935ffa64e7e977544d19ecebf06L.jpg",
              to: "大一软件学院某女生某某",
              toId: 19870621,
              comment:
                "同学你好，我的性格和你相似，想和你一个宿舍，我想和你商量一下一些具体的生活习惯可以吗？如果同学看到了请回复一下我哟",
              time: "2019年9月16日 18:43",
              commentNum: 1,
              like: 15,
              inputShow: false
            },
            {
              from: "大二软件学院某某",
              fromId: 1123,
              fromHeadImg:
                "https://ae01.alicdn.com/kf/Hf6c0b4a7428b4edf866a9fbab75568e6U.jpg",
              to: "大一软件学院某女生某某",
              toId: 19870621,
              comment: "学妹感觉你性格挺好的",
              time: "2019年9月16日 18:43",
              commentNum: 0,
              like: 5,
              inputShow: false
            }
          ]
        },
        {
          name: "大一材料男",
          id: 19891221,
          headImg:
            "https://ae01.alicdn.com/kf/H94c78935ffa64e7e977544d19ecebf06L.jpg",
          comment:
            "爱打游戏：LOL、原神、CSGO都玩，而且水平不差，LOL一区有钻石以上，原神冒险等级58级，被好友称为Beryl。希望找一个可以和我一起开黑的同学，当然前提是能够娱乐适度，不影响学习；晚上作息也正常，绝对不会影响其他室友。有“臭味相同”的好哥们儿可以联系我哟",
          time: "2019年9月16日 18:43",
          commentNum: 1,
          like: 5,
          inputShow: false,
          reply: [
            {
              from: "大一经济男",
              fromId: 19870621,
              fromHeadImg:
                "https://ae01.alicdn.com/kf/Hd60a3f7c06fd47ae85624badd32ce54dv.jpg",
              to: "大一材料男",
              toId: 19891221,
              comment: "大佬带我！！！！",
              time: "2019年9月16日 18:43",
              commentNum: 25,
              like: 5,
              inputShow: false
            }
          ]
        },
        {
          name: "大一艺术男生",
          id: 20190830,
          headImg:
            "https://ae01.alicdn.com/kf/Hdd856ae4c81545d2b51fa0c209f7aa28Z.jpg",
          comment:
            "找室友或朋友（也可以是书友哟），平时喜欢看小说，最喜欢推理的小说，最喜欢看阿加莎的小说，感觉特别经典，看完了他的小说之后完全不想再看其他人写的；也喜欢看动漫，《火影》、《海贼》、《柯南》全都看，也喜欢看柯南的剧场版，可以寻一个最近可以陪我去看《万圣节的新娘》剧场版的友友吗？可以联系我！！！",
          time: "2019年9月16日 18:43",
          commentNum: 0,
          like: 5,
          inputShow: false,
          reply: []
        }
      ]
    };
  },
  directives: { clickoutside },
  methods: {
    handleAnimation: function(anim) {
      console.log(anim); //这里可以看到 lottie 对象的全部属性
      this.defaultAnim = anim;
    },
    inputFocus() {
      var replyInput = document.getElementById("replyInput");
      replyInput.style.padding = "8px 8px";
      replyInput.style.border = "2px solid blue";
      replyInput.focus();
    },
    showReplyBtn() {
      this.btnShow = true;
    },
    hideReplyBtn() {
      this.btnShow = false;
      replyInput.style.padding = "10px";
      replyInput.style.border = "none";
    },
    showReplyInput(i, name, id) {
      this.comments[this.index].inputShow = false;
      this.index = i;
      this.comments[i].inputShow = true;
      this.to = name;
      this.toId = id;
    },
    _inputShow(i) {
      return this.comments[i].inputShow;
    },
    sendComment() {
      if (!this.replyComment) {
        this.$message({
          showClose: true,
          type: "warning",
          message: "评论不能为空"
        });
      } else {
        let a = {};
        let input = document.getElementById("replyInput");
        let timeNow = new Date().getTime();
        let time = this.dateStr(timeNow);
        a.name = this.myName;
        a.comment = this.replyComment;
        a.headImg = this.myHeader;
        a.time = time;
        a.commentNum = 0;
        a.like = 0;
        this.comments.push(a);
        this.replyComment = "";
        input.innerHTML = "";
      }
    },
    sendCommentReply(i, j) {
      if (!this.replyComment) {
        this.$message({
          showClose: true,
          type: "warning",
          message: "评论不能为空"
        });
      } else {
        let a = {};
        let timeNow = new Date().getTime();
        let time = this.dateStr(timeNow);
        a.from = this.myName;
        a.to = this.to;
        a.fromHeadImg = this.myHeader;
        a.comment = this.replyComment;
        a.time = time;
        a.commentNum = 0;
        a.like = 0;
        this.comments[i].reply.push(a);
        this.replyComment = "";
        document.getElementsByClassName("reply-comment-input")[i].innerHTML =
          "";
      }
    },
    onDivInput: function(e) {
      this.replyComment = e.target.innerHTML;
    },
    dateStr(date) {
      //获取js 时间戳
      var time = new Date().getTime();
      //去掉 js 时间戳后三位，与php 时间戳保持一致
      time = parseInt((time - date) / 1000);
      //存储转换值
      var s;
      if (time < 60 * 10) {
        //十分钟内
        return "刚刚";
      } else if (time < 60 * 60 && time >= 60 * 10) {
        //超过十分钟少于1小时
        s = Math.floor(time / 60);
        return s + "分钟前";
      } else if (time < 60 * 60 * 24 && time >= 60 * 60) {
        //超过1小时少于24小时
        s = Math.floor(time / 60 / 60);
        return s + "小时前";
      } else if (time < 60 * 60 * 24 * 30 && time >= 60 * 60 * 24) {
        //超过1天少于30天内
        s = Math.floor(time / 60 / 60 / 24);
        return s + "天前";
      } else {
        //超过30天ddd
        var date = new Date(parseInt(date));
        return (
          date.getFullYear() +
          "/" +
          (date.getMonth() + 1) +
          "/" +
          date.getDate()
        );
      }
    }
  }
};
</script>
