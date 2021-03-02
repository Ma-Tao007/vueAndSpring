<template>
  <div class="index">
    <!-- header头部模块开始 -->
    <!-- header头部模块结束 -->
    <!-- banner 部分start -->
  
    <div class="banner">
      <div class="block">       
        <el-carousel>
          <el-carousel-item v-for="banner in banners" :key="banner.id">
            <router-link to="/course">
            <img :src="banner.url" width="100%" height="100%"  @click="findCourse(banner.id)"/>
            </router-link>
            <!--<h3 class="small">{{item}}</h3>-->
          </el-carousel-item>
        </el-carousel>
         
      </div>
    </div>
   
    <!-- banner 部分end -->
    <!-- box start -->
    <!-- 热门课程列表 -->
    <div class="box w">
      <div class="box-hd">
        <h3>热门课程</h3>
      </div>
      <!-- 此地方一定要清除浮动，务必务必务必 -->
      <div class="box-bd clearfix">
        <ul
          class="hotcourse"
          v-for="(course, key, index) in courses"
          :key="index"
        >
          <router-link to="/course">
            <li>
              <img :src="course.picture" alt="" />
              <h4>{{course.name}}</h4>
              <div class="pricebox">
                <div>{{course.profile}}</div>
                <el-button type="danger" class="but"
                  >￥{{ course.price }}</el-button
                >
              </div>
            </li>
          </router-link>
        </ul>
      </div>
    </div>
    <!-- box end -->
    <!-- box start -->
    <router-link to="/about">
      <div class="allclass" >全部课程</div>
    </router-link>

    <!--名师大咖 -->
    <div class="box w">
      <div class="box-hd">
        <h3>名师大咖</h3>
      </div>
      <!-- 此地方一定要清除浮动，务必务必务必 -->
      <div class="box-bd clearfix">
        <ul
          class="startheacher"
          v-for="(teacher, key, index) in teachers"
          :key="index"
        >
          <li>
            <img :src="teacher.picUrl" alt=" " />
            <h4>{{teacher.name}}</h4>
            <p>{{teacher.cname}}</p>
            <p>{{teacher.profile}}</p>
          </li>
        </ul>
      </div>
    </div>
    <!-- box end -->
    <router-link to="/teachers">
      <!-- 全部老师按钮 -->
      <div class="allclass">全部老师</div>
    </router-link>
    <!-- footer start -->
    
    <!-- footer end -->
  </div>
</template>



<script>



export default {
  name: "index",
  components: {
   
  },
  data() {
    return {
      courses: [
        //  {
        //   id: 1,
        //   url:require("../../public/images/course.jpg"),
        //   name: "Java基础",
        //   num: "100",
        //    price: "500.00",
        // },
     ],
      teachers: [
      //  {
      //     id: 1,
      //  url:require("../../public/images/teacher.png"),
      //  name: "张老师",
      //  career: "Java基础课",
      //  profile:
      //    "深受学生喜爱和信任的好老师! fiona老师 英语专业学士,英语专业八级。具有丰富的耶鲁视线英语教学经验。善于发现孩子的性格特点,抓住孩子的学习兴趣。",
      //  },
     ],
     banners:[
    //    {
    //     id:1,
    //     url:require("../../public/images/banner1.jpg"),
    //     courseId:3,
    // }
     ]
    };
  },
  methods: {
    //首页
    getIndex() {
      let that = this;
      this.$axios
        .get("/apis/index")
        .then(function (response) {
          // console.log(response.data.hotCourse);
          console.log(response.data.allBanner);
          that.courses=response.data.hotCourse
          that.teachers=response.data.topLecturer
          that.banners=response.data.allBanner
          
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    //点击轮播图
    findCourse(id){
      console.log(id);
      let that = this;
      this.$axios
        .get("/apis/course",{
          params:{
             id
          }
        })
        .then(function (response) {
          
        })
        .catch(function (error) {
          console.log(error);
        });
    },
  },
  mounted() {
    this.getIndex();
  },
};
</script>




<style >
/*css 初始化代码 css reset*/
/*清除元素默认的内外边距*/

* {
  margin: 0;
  padding: 0;
}

/*清除列表样式*/

li {
  list-style: none;
}

/*取消表单的轮廓线*/

input {
  outline: none;
}

/*去掉button 默认自带的边框*/

button {
  border: none;
}

body {
  background-color: white;
  /*方便写代码 一会别忘了删除*/
  /*height: 3000px;*/
}

a {
  text-decoration: none;
}

/*清除浮动的*/

.clearfix:before,
.clearfix:after {
  content: "";
  display: table;
}

.clearfix:after {
  clear: both;
}

.clearfix {
  *zoom: 1;
}

/*版心 1200 水平居中*/

.w {
  width: 100%;
  margin: auto;
}

/*header start*/

.header {
  height: 100px;
  /*background-color: pink;*/
  margin: 30px auto;
}

/*banner start*/

.banner {
  margin: 0 auto;
}

.course {
  /*因为course 子盒子有了浮动，则就不会外边距塌陷的问题了*/
  float: right;
  width: 228px;
  height: 300px;
  background-color: #fff;
  margin-top: 50px;
}

.course-hd {
  height: 48px;
  background-color: #9bceea;
  font-size: 18px;
  text-align: center;
  line-height: 48px;
  color: #fff;
  /*文字加粗*/
  /*font-weight: bold;*/
  font-weight: 700;
}

.course-bd {
  /*没有宽度的盒子 padding 不会撑开盒子*/
  padding: 0 15px;
}

.course-bd ul {
  /*外边距塌陷的问题
	margin-top: 10px;*/
  padding-top: 10px;
}

.course-bd li {
  /*行高等与高度 只能让单行文本垂直居中*/
  height: 50px;
  border-bottom: 1px solid #ccc;
  margin-top: 10px;
}

.course-bd li:hover {
  transform: scale(1.1, 1.1);
}

.course-bd li h4 {
  font-size: 16px;
  color: #4e4e4e;
}

.course-bd li p {
  font-size: 12px;
  color: #a5a5a5;
}

.all {
  display: block;
  height: 38px;
  border: 1px solid #00a4ff;
  margin-top: 10px;
  font-size: 16px;
  color: #00a4ff;
  text-align: center;
  line-height: 38px;
}

.all:hover {
  background-color: #00a4ff;
  color: #fff;
}

/*banner end*/

/*box start*/

.box {
  margin-top: 15px;
}

.box-hd {
  height: 70px;
  line-height: 70px;
  /*background-color: pink;*/
  text-align: center;
}

.box-hd h3 {
  font-size: 22px;
  color: #494949;
  /*让粗体不加粗 400 == normal*/
  font-weight: 400;
  margin-top: 30px;
}

.box-hd a {
  float: right;
  margin-right: 30px;
  font-size: 12px;
  color: #a5a5a5;
}

.box-bd {
  /*这个盒子一定不要给高度 因为我们可能放一行 也可能是2行 或者n行*/
  /*宽度呢？ 呵呵*/
  /*box-bd 宽度 超过了 版心 1200 是可以的，就就解决了问题*/
  width: 100%;
}

.box-bd li {
  position: relative;
  float: left;
  width: 228px;
  margin-right: 15px;
  margin-bottom: 15px;
  background-color: #fff;
  box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.3);
}

.box-bd li img {
  width: 100%;
}
.box-bd li:hover {
  transform: scale(1.1, 1.1);
}

.box-bd li h4 {
  margin: 5px 15px;
  font-size: 18px;
  color: rgba(0, 0, 0, 0.5);
  font-weight: 800px;
}

.box-bd li p {
  margin: 5px 15px;
  font-size: 16px;
  color: #999;
}

.box-bd p span {
  color: #999;
}

.box-bd .pricebox {
  margin: 5px 15px;
  color: black;
  font-size: 16px;
  width: 90%;
  margin-top: 0px;
}

.box-bd div {
  display: block;
  float: left;
  padding-top: px;
   color: rgba(0, 0, 0, 0.5);
}
.box-bd button {
  float: right;
}

/*box end */

.allclass {
  line-height: 50px;
  width: 160px;
  border-radius: 35px;
  border: 1px solid rgb(0, 61, 122);
  text-align: center;
  margin: 10px auto;
  font-size: 22px;
  color: #494949;
  font-weight: 400px;
  cursor: pointer;
  box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5);
}

.allclass:hover {
  background-color: rgb(0, 61, 122);
  color: white;
}

/* 轮播图 */

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>