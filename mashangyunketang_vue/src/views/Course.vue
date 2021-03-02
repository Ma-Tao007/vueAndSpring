<template>
  <div id="app">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item>首页</el-breadcrumb-item>
      <el-breadcrumb-item>
        <router-link to="/about">课程管理</router-link>
      </el-breadcrumb-item>
      <el-breadcrumb-item>
        <router-link to="/course">课程内容</router-link>
      </el-breadcrumb-item>
    </el-breadcrumb>
    <el-row :gutter="20">
      <!-- 视频位 -->
      <el-col :span="11"><div class="grid-content SP"></div></el-col>
      <!-- ======== -->
      <el-col :span="13"
        ><div class="grid-content bg-purple-dark">
          <h1>课程名称：</h1>
          <div>{{ course.name }}</div>

          <el-row>
            <el-col :span="24" style="height: 130px"></el-col>
          </el-row>
          <el-button
            style="width: 196px; height: 66px; font-size: 18px"
            type="primary"
            @click="dialogVisible = true"
            >点击购买</el-button
          >

          <el-dialog
            title="扫码支付，极速更安全"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose"
            center
          >
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="dialogVisible = false"
                >确 定</el-button
              >
            </span>
          </el-dialog>
        </div></el-col
      >
    </el-row>
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane label="课程信息" name="first">
        <h3>
          {{ course.name }}
        </h3>
        讲师:{{ course.lecturerName }}
        <br />
        价格：{{ course.price }}
      </el-tab-pane>
      <el-tab-pane label="分章目录" name="second">
        <el-collapse v-model="activeNames" @change="handleChange">
          <el-collapse-item
            v-for="c in chapter"
            :key="c.id"
            :title="c.name"
            :name="c.id"
          >
            <div style="font-size: 20px" v-for="s in c.session" :key="s.id">
              <a :href="s.videoUrl">{{ s.name }}</a>
            </div>
          </el-collapse-item>
        </el-collapse>
      </el-tab-pane>
      <el-tab-pane label="详情介绍" name="third">
        {{ course.profile }}
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<style scoped>
.SP {
  width: 700px;
  background-color: #000;
}
.grid-content {
  border-radius: 4px;
  min-height: 400px;
  margin-top: 2rem;
}
.bg-purple-dark {
  background: #f5f8f4;
}
</style>

<script>
export default {
  data() {
    return {
      activeName: "first",
      dialogVisible: false,
      activeNames: [1],
      course: {},
      chapter: [
        {
          id: 1,
          name: "第一章",
          session: [
            {
              id: 1,
              name: "第一节",
              videoUrl: "",
            },
            {
              id: 2,
              name: "第一节",
              videoUrl: "",
            },
            {
              id: 3,
              name: "第一节",
              videoUrl: "",
            },
          ],
        },
        {
          id: 2,
          name: "第一章",
          session: [
            {
              id: 1,
              name: "第一节",
            },
          ],
        },
        {
          id: 3,
          name: "第一章",
          session: [
            {
              id: 1,
              name: "第一节",
            },
          ],
        },
      ],
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
        })
        .catch((_) => {});
    },
    handleChange(val) {
      console.log(val);
    },
  },
};
</script>