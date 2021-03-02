<template>
  <div id="app">
    <el-row class="bg-top">
      <el-col :span="6"
        ><div style="text-align: right" class="grid-top">
          <el-image
            style="width: 240px; height: 120px"
            :src="require('@/assets/logo.png')"
            fit="fill"
          ></el-image></div
      ></el-col>
      <el-col :span="18">
        <div class="grid-top">
          <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#fff0"
            text-color="#242424"
            active-text-color="#ffd04b"
            router="ture"
            style="border-bottom: 0px"
          >
            <el-menu-item
              style="
                font-size: 25px;
                font-weight: 700;
                padding: 0 45px;
                margin-left: 55px;
              "
              index="/"
            >
              首页
            </el-menu-item>
            <el-menu-item
              style="font-size: 25px; font-weight: 700; padding: 0 45px"
              index="/about"
            >
              课程
            </el-menu-item>
            <el-menu-item
              style="font-size: 25px; font-weight: 700; padding: 0 45px"
              index="/teachers"
            >
              名师
            </el-menu-item>
            <el-menu-item
              style="font-size: 25px; font-weight: 700; padding: 0 45px"
              index="/content"
            >
              文章
            </el-menu-item>
          </el-menu>
        </div>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="2"><div class="grid-content"></div></el-col>
      <el-col :span="20"
        ><div class="grid-content bg-purple-light">
          <el-main>
            <router-view />
          </el-main></div
      ></el-col>
      <el-col :span="2"><div class="grid-content"></div></el-col>
    </el-row>

    <div class="grid-bottom bg-bottom">
      <el-row>
        <el-col :span="3"><div class="grid-content"></div></el-col>
        <el-col :span="11"
          ><div class="grid-content">
            <el-image
              style="width: 360px; height: 180px"
              :src="require('@/assets/logo.png')"
              fit="fill"
            ></el-image>
            <div class="el-row-bottom">
              码上云课堂致力于普及中国最好的教育它与中国一流大学和机构合作提供在线课程。<br />
              ©2021课程版权均归码上云课堂所有
            </div>
          </div></el-col
        >
        <el-col :span="3"
          ><div class="grid-content">
            <dl>
              <dt>关于码上云课堂</dt>
              <dd><a href="# ">关于</a></dd>
              <dd><a href="# ">管理团队</a></dd>
              <dd><a href="# ">工作机会</a></dd>
              <dd><a href="# ">客户服务</a></dd>
              <dd><a href="# ">帮助</a></dd>
            </dl>
          </div></el-col
        >
        <el-col :span="3"
          ><div class="grid-content">
            <dl>
              <dt>新手指南</dt>
              <dd><a href="# ">如何注册</a></dd>
              <dd><a href="# ">如何选课</a></dd>
              <dd><a href="# ">如何拿到毕业证</a></dd>
              <dd><a href="# ">学分是什么</a></dd>
            </dl>
          </div></el-col
        >
        <el-col :span="3"
          ><div class="grid-content">
            <dl>
              <dt>合作伙伴</dt>
              <dd><a href="# ">合作机构</a></dd>
              <dd><a href="# ">合作导师</a></dd>
            </dl>
          </div></el-col
        >
        <el-col :span="1"><div class="grid-content"></div></el-col>
      </el-row>
    </div>
  </div>
</template>

<style scoped>

body {
  margin: 0px;
}
.el-row {
  margin-bottom: 20px;
}
.el-col {
  border-radius: 4px;
}
.el-menu-demo {
  height: 94px;
  padding-top: 30px;
}
.bg-top {
  background: -webkit-linear-gradient(top, #ffffff, #29df11, #0cdf0c, #ffffff);
}
.bg-bottom {
  background: -webkit-linear-gradient(top, #ffffff, #29df11, #0cdf0c, #ffffff);
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-top {
  height: 120px;
  background: #fff0;
}
.grid-bottom {
  min-height: 11rem;
  bottom: 0px;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.el-header,
.el-footer {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  line-height: 60px;
}
.el-main {
  background-color: #ffffff;
  color: #333;
  line-height: 80px;
}

body > .el-container {
  margin-bottom: 40px;
}
p {
  position: absolute;
  bottom: 0px;
}
.el-row-bottom {
  position: absolute;
  bottom: 18px;
}
dd > a {
  text-decoration: none;
  color: #242424;
}
dt {
  font-size: 20px;
  font-weight: 700;
  /* line-height: 20px; */
}
dl {
  line-height: 2rem;
}
a {
  text-decoration: none;
}
</style>

<script>
export default {
  data() {
    return {
      activeIndex: "",
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      // console.log(key);
      // console.log(keyPath);
      this.activeIndex = key;
    },
  },
};
</script>