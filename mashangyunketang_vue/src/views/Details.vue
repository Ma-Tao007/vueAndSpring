<template>
    <div class="body">
        <div class="title">{{obj.title}}</div>
        <br><br>
        <div class="img">
             <img :src="obj.img">
        </div>
        <br>
        <div class="text" v-html="obj.text"></div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            obj:{}
        }
    },
    created(){
        var that = this
      var id = this.$route.query.id
      this.$axios.get("/article/id",{params:{id:id}}).then(function (res) {
          console.log("查询出的对象",res.data)
                that.obj = res.data
            }).catch(function (error) {
                that.$message(error);
            });
    }
}
</script>
<style scoped>
.body{
    width: 50%;
    margin: auto;
    line-height: 25px;
}
.title{
    font-size: 30px;
    font-weight: 1000;
    text-align: center;
}
.img{
    text-align: center;
}
</style>