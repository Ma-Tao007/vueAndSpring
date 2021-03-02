<template>
<div class="f">
        
        <div class="body">
          <h3>金牌讲师</h3>
          <!-- 遍历对象：key键 item值 index索引  需绑定：key-->
          <div class="teacherlist" v-for="(teacher,key,index) in teachers" :key="index">
                 <img v-bind:src="teacher.picUrl"/>
                 <h4>{{teacher.name}}</h4>
                 <p>{{teacher.career}}</p>
                 <p>{{ teacher.profile }}</p>
          </div>
        </div>
</div>
</template>

<script>

    
    export default {
        name:'teachers',
        //组件
        components:{
                       
        },
        // 把数据返回给标签
        data(){
          return{
                  teachers:[
                   {url:"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2456236803,3694062620&fm=26&gp=0.jpg",name:"张老师",cname:"Java基础课",introduction:"深受学生喜爱和信任的好老师! fiona老师 英语专业学士,英语专业八级。具有丰富的耶鲁视线英语教学经验。善于发现孩子的性格特点,抓住孩子的学习兴趣。"},
                    ]
          }
        },
       //绑定的方法在这里
         methods:{
           getLecturers(){
           let that = this;
           this.$axios
           .get("/apis/lecturers")
           .then(function (response) {
             console.log(response);
             that.teachers=response.data
           
        })
        .catch(function (error) {
           console.log(error);
        });
           }
         },
        // 页面渲染完就会加载这个钩子函数（方法）
        mounted(){
           this.getLecturers();
           
        },
        
        }           
</script>
<style>
.f{width: 100%;
   margin: 0 auto;
}

 .f .body{
   width: 100%;
 }

.f .body h3{
  margin:15px 0px;
  text-align: center;
  
}
  .teacherlist{
    float:left;
    width: 270px;
    height: 300px;
    background-color:rgb(244, 247, 250);
    border: 1px solid gainsboro;
    margin:5px 5px;
  }

.f .body .teacherlist {
  width: 280px;
  height: 500px;
}

.f .body .teacherlist img{
  width: 260;
  height: 250px;
  margin:15px 15px;
  
}
.f .body .teacherlist h4{
  margin:5px 15px;
}
.f .body .teacherlist p{
  margin:5px 15px;
  font-size: 16px;
  color: grey;
}

</style>