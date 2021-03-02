<template>
  <div id="app">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item>首页</el-breadcrumb-item>
      <el-breadcrumb-item>
        <router-link to="/about">课程管理</router-link>
      </el-breadcrumb-item>
    </el-breadcrumb>

    <el-select
      v-model="courseCategoryName"
      clearable
      filterable
      placeholder="试试搜索想选课程"
      style="padding: 20px 0 0 60px"
      @change="getValue"
    >
      <el-option
        v-for="item in courseCategory"
        :key="item.id"
        :label="item.name"
        :value="item.id"
      >
      </el-option>
    </el-select>

    <el-row>
      <el-col
        :span="5"
        v-for="(c, index) in course"
        :key="c.id"
        :offset="index >= 0 ? 1 : 0"
      >
        <div class="card">
          <router-link to="/course">
            <el-card shadow="hover" :body-style="{ padding: '0px' }">
              <img :src="c.picture" class="image" />
              <div style="padding: 14px">
                <span>{{ c.name }}</span>
                <el-divider></el-divider>
                <div class="bottom clearfix">
                  <time class="teacher">{{ c.lecturerName }}</time>
                  <el-button type="text" class="price"
                    >￥{{ c.price }}</el-button
                  >
                </div>
              </div>
            </el-card>
          </router-link>
        </div>
      </el-col>
    </el-row>
    <el-pagination
      background
      layout="prev, pager, next"
      :total="course.length"
      :page-size="12"
    >
    </el-pagination>
  </div>
</template>

<style scoped>
/* Add "scoped" attribute to limit CSS to this component only  */
.teacher {
  font-size: 13px;
  color: #999;
}

.card {
  margin-top: 40px;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.price {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}

a {
  text-decoration: none;
}
</style>

<script>
export default {
  name: "HelloWorld",
  props: {
    msg: String,
  },
  data() {
    return {
      courseCategoryName: "",
      course: [
        {
          id: 1,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 2,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 3,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 4,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 5,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 6,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 7,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 8,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 9,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 10,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 11,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 12,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 13,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 14,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 15,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 16,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 17,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
        {
          id: 18,
          name: "HTML",
          lecturerName: "sun",
          price: "888",
          picture: "http://img2.mukewang.com/5feddf40097ffb6505400304.png",
        },
      ],
      courseCategory: [
        {
          id: 1,
          name: "hh",
        },
        {
          id: 2,
          name: "hh",
        },
        {
          id: 3,
          name: "sh",
        },
        {
          id: 4,
          name: "hh",
        },
      ],
    };
  },
  methods: {
    over(index) {
      // console.log(index);
      //将点击的元素的索引赋值给bian变量
      this.isactive = index;
    },
    leave(index) {
      // console.log(index);
      //将点击的元素的索引赋值给bian变量
      this.isactive = false;
    },

    //赛选值变更触发方法
    getValue(value) {
      console.log(value);
    },
  },
};
</script>

