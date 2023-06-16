<template>
  <div class="Menu">
    <br /><br />
    <ul class="Menu-list" data-offset="10">
      <li class="Menu-list-item" data-offset="20" onclick>
        根据
        <span class="Mask"><span>根据</span></span>
        <span class="Mask"><span>根据</span></span>
      </li>
      <li class="Menu-list-item" data-offset="16" onclick>
        爱好，习惯，作息，性格
        <span class="Mask"><span>爱好，习惯，作息，性格</span></span>
        <span class="Mask"><span>爱好，习惯，作息，性格</span></span>
      </li>
      <li class="Menu-list-item" data-offset="12" onclick>
        自由选择
        <span class="Mask"><span>自由选择</span></span>
        <span class="Mask"><span>自由选择</span></span>
      </li>
      <li class="Menu-list-item" data-offset="8" onclick>
        室友
        <span class="Mask"><span> 室友</span></span>
        <span class="Mask"><span> 室友</span></span>
      </li>
      <a  @click="checkDataIsSet()" style="text-decoration:underline; ">
        <li class="Menu-list-item" data-offset="4" onclick >
          Let's Go!
          <span class="Mask"><span> Let's Go!</span></span>
          <span class="Mask"><span> Let's Go!</span></span>
        </li>
      </a>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return{
      flag: '',
    }
  },
  methods: {
    nativeJs() {
      var $menu = $(".Menu-list"),
        $item = $(".Menu-list-item"),
        w = $(window).width(), //window width
        h = $(window).height(); //window height

      $(window).on("mousemove", function(e) {
        var offsetX = 0.5 - e.pageX / w, //cursor position X
          offsetY = 0.5 - e.pageY / h, //cursor position Y
          dy = e.pageY - h / 2, //@h/2 = center of poster
          dx = e.pageX - w / 2, //@w/2 = center of poster
          theta = Math.atan2(dy, dx), //angle between cursor and center of poster in RAD
          angle = (theta * 180) / Math.PI - 90, //convert rad in degrees
          offsetPoster = $menu.data("offset"),
          transformPoster =
            "translate3d(0, " +
            -offsetX * offsetPoster +
            "px, 0) rotateX(" +
            -offsetY * offsetPoster +
            "deg) rotateY(" +
            offsetX * (offsetPoster * 2) +
            "deg)"; //poster transform

        //get angle between 0-360
        if (angle < 0) {
          angle = angle + 360;
        }

        //poster transform
        $menu.css("transform", transformPoster);

        //parallax for each layer
        $item.each(function() {
          var $this = $(this),
            offsetLayer = $this.data("offset") || 0,
            transformLayer =
              "translate3d(" +
              offsetX * offsetLayer +
              "px, " +
              offsetY * offsetLayer +
              "px, 20px)";

          $this.css("transform", transformLayer);
        });
      });
    },
    checkDataIsSet() {
      var that = this;
      console.log(sessionStorage.getItem("username"));
      this.$http
        .get("/checkDataFlag", {
          params: { username: sessionStorage.getItem("username") }
        })
        .then((data) => {
          if (data.data) {
            console.log("已经填写资料啦");
            this.flag = true;
            console.log(this.flag)
            this.open()
            that.$router.push({
                  path: "/index"
                });
          } else {
            console.log("还没填写资料o");
            this.open()
            that.$router.push({
                  path: "/myinfoModify"
                });
          }
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    open() {
      if (this.flag === true) {
        this.$notify({
          title: "欢迎",
          message: "即将开启你的大学生活！",
          type: "success",
          offset: 100
        });
      } else {
        console.log(this.flag)
        this.$notify({
          title: "Wait!",
          message: "请先填写一下你的个人资料o，即将为你跳转",
          offset: 100
        });
      }
    }
  },
  mounted: function() {
    this.$nextTick(function() {
      this.nativeJs();
      // this.checkDataIsSet()
    });
  }
};
</script>

<style scoped>
body {
  font-family: "Gilroy ExtraBold", system-ui, sans-serif;
  font-style: normal;
  font-weight: normal;
  -webkit-font-smoothing: antialiased;
  -webkit-font-kerning: normal;
  -webkit-text-size-adjust: 100%;
}

html,
body {
  width: 100vw;
  height: 100vh;
}

body {
  background: linear-gradient(
    90deg,
    rgba(247, 149, 51, 0.1),
    rgba(243, 112, 85, 0.1) 15%,
    rgba(239, 78, 123, 0.1) 30%,
    rgba(161, 102, 171, 0.1) 44%,
    rgba(80, 115, 184, 0.1) 58%,
    rgba(16, 152, 173, 0.1) 72%,
    rgba(7, 179, 155, 0.1) 86%,
    rgba(109, 186, 130, 0.1)
  );
  transform-style: preserve-3d;
  transform: perspective(60rem);
  position: fixed;
  display: flex;
  align-items: center;
  justify-content: center;
}
.Menu-list {
  font-size: 4.25rem;
  line-height: 1.2;
  text-transform: uppercase;
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
  transform: rotateX(-10deg) rotateY(20deg);
}

.Menu-list-item {
  position: relative;
  color: transparent;
  cursor: pointer;
}
.Menu-list-item::before {
  content: "";
  display: block;
  position: absolute;
  top: 49%;
  left: -10%;
  right: -10%;
  height: 4px;
  border-radius: 4px;
  margin-top: -2px;
  background: #ff2c75;
  transform: scale(0);
  transition: transform 0.8s cubic-bezier(0.16, 1.08, 0.38, 0.98);
  z-index: 1;
}

.Mask {
  display: block;
  position: absolute;
  overflow: hidden;
  color: #ff2c75;
  top: 0;
  height: 49%;
  transition: all 0.8s cubic-bezier(0.16, 1.08, 0.38, 0.98);
}
.Mask span {
  display: block;
}

.Mask + .Mask {
  top: 48.9%;
  height: 51.1%;
}
.Mask + .Mask span {
  transform: translateY(-49%);
}

.Menu-list-item:hover .Mask,
.Menu-list-item:active .Mask {
  color: #fff;
  transform: skewX(12deg) translateX(5px);
}
.Menu-list-item:hover .Mask + .Mask,
.Menu-list-item:active .Mask + .Mask {
  transform: skewX(12deg) translateX(-5px);
}
.Menu-list-item:hover::before,
.Menu-list-item:active::before {
  transform: scale(1);
}
</style>
