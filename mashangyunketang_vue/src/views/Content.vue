<template>
    <div class="body">
        <!-- 分类列表 -->
        <div class="fl_list">
            <div @click="changeFl(flitem.id)" :class="['flitem',flitem.active==1?'actionFl':'']" v-for="(flitem,index) in flList" :key="index">  {{flitem.acname}} </div>
        </div>
        <div class="kj" ></div>
        <!-- 文章列表 -->
        <div class="wz_list">
            <div class="wzitem"  v-for="(item,index) in wzList" :key="index">
                <div class="imgCon l">
                    <img :src="item.img">
                </div>
                <div class='wz_contain l'>
                    <a @click="toDetails(item.id)" target="_blank" class="title"><p>{{item.title}}</p></a>
                    <div class="wz_contain_bottom">
                        <div class="wz_contain_bottom_left">
                            <label class="moco-label label l"><a  target="_blank">{{obj.title}}</a></label>
                            <div class="browseNum l"><i class="iconfont iconyanjing"></i><span>&emsp;34799</span></div>
                            <div class="browseNum l">作者：{{item.author}}</div>
                            <div class="browseNum time">{{item.create_time.split("T")[0]}}</div>
                        </div>
                    </div>
                </div>
            </div>
            <p class='loading' v-if="loading">加载中...</p>
            <p class='loading' v-if="noMore">没有更多了</p>
        </div>
    </div>

</template>
<script>
// const flList = [
//     {id:1,title:"资讯",active:1},{id:2,title:"最新文章"},{id:3,title:"区块链"},{id:4,title:"人工智能"},
//     {id:5,title:"资讯"},{id:6,title:"资讯"},{id:7,title:"资讯"},{id:8,title:"资讯"}
// ]
const wzList = [
    {fid:1,src:'https://img2.sycdn.imooc.com/602353ae000156d802740184-200-200.jpg'},
    {fid:2,src:'https://img4.sycdn.imooc.com/5bd1355a0001a27c04000294-200-200.jpg'},
    {fid:3,src:'https://img4.sycdn.imooc.com/6021fe1d000192ff14001400-200-200.jpg'},
    {fid:4,src:'https://img4.sycdn.imooc.com/60192b8e0001198e03000300-200-200.jpg'},
    {fid:5,src:'https://img4.sycdn.imooc.com/601cb1ac00015b4e08550294-200-200.jpg'},
    {fid:6,src:'https://img4.sycdn.imooc.com/5bf3a027000159ea02720272-200-200.jpg'},
    {fid:7,src:'https://img4.sycdn.imooc.com/5ff52b110001f22c05600384-200-200.jpg'},
    {fid:8,src:'https://img4.sycdn.imooc.com/5bf3a1460001f88002720272-200-200.jpg'},

]
export default {
    data(){
        return{
            flList:[],
            wzList:[],
            currentActiveid:0,
            obj:{},
            loading:false,
            noMore:false,
            //每页的个数
            num:10,
            //第几页
            pageNo:1,
            //总数
            count:0,
        }
    },
    created(){
        window.addEventListener('scroll', this.Scrollbottom);
        this.getAllCategory()
        // this.obj.title = this.flList[0].title
        // this.obj.src = this.wzList.filter(item=>item.fid==this.flList[0].id)[0].src
    },
    methods:{
        getAllCategory(){
            let that = this;
           this.$axios.get("/getAllCategory/getAllCategory").then(function (response) {
                that.flList=response.data
                if(that.flList.length>0){
                    that.flList[0].active=1
                    that.obj.title = that.flList[0].acname
                    //加载数据
                   // that.$axios.get("/getAllCategory/getAllCategory").then(function (response) {
                    that.changeFl(that.flList[0].id)
                }
            }).catch(function (error) {
                that.$message(error);
            });
        },
        toDetails(id){
            this.$router.push({path:'details?id='+id})
        },
        destroyed() { 
            window.removeEventListener('scroll', this.Scrollbottom)//页面离开后销毁监听事件
        },
        changeFl(id){
            if(id==this.currentActiveid){
                return
            }
            this.num = 10
            this.pageNo = 1
            this.count = 0
            this.wzList = []
            let that = this;
            ///article/categoryid
            //切换分类
            this.flList.map(item=>{
                if(item.id==id){
                    that.obj.title = item.acname
                    item.active=1
                    that.currentActiveid = id
                    this.$axios.get("/article/categoryid",{params:{page:this.pageNo,limit:this.num,categoryid:id}}).then(function (res) {
                        that.count = res.data.count
                        that.wzList = res.data.list
                    }).catch(function (error) {
                        that.$message(error);
                    });
                }else{
                    item.active=0
                }
            })
            
            this.$forceUpdate()
        },
        Scrollbottom () { 
             if(this.count == this.wzList.length){
                this.loading = false
                this.noMore = false
                return
             }
             if(this.loading){
                 return
             }
             var that = this
            let scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
            let clientHeight = document.documentElement.clientHeight;
            let scrollHeight = document.documentElement.scrollHeight;
            if (scrollTop + clientHeight >= scrollHeight) {
                this.loading = true
                setTimeout(()=>{
                    that.pageNo = that.pageNo+1
                    that.$axios.get("/article/categoryid",{params:{page:that.pageNo,limit:that.num,categoryid:that.currentActiveid}}).then(function (res) {
                        that.wzList = that.wzList.concat(res.data.list)
                        that.loading = false
                        that.$forceUpdate()
                    }).catch(function (error) {
                        that.$message(error);
                    });
                },1000)                
            }
	    },
    }
}
</script>
<style scoped>
.body{
    line-height: 25px;
}
@font-face {font-family: "iconfont";
  src: url('//at.alicdn.com/t/font_2387107_y08svn14rym.eot?t=1614231779666'); /* IE9 */
  src: url('//at.alicdn.com/t/font_2387107_y08svn14rym.eot?t=1614231779666#iefix') format('embedded-opentype'), /* IE6-IE8 */
  url('data:application/x-font-woff2;charset=utf-8;base64,d09GMgABAAAAAAM8AAsAAAAABvAAAALtAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHEIGVgCCcAqBeIFyATYCJAMICwYABCAFhG0HMRsZBhHVk61kXydwbnrI2cuDt01UoVzhgKNYV+T9blZVZsD7M93SYcWUHBM8/63xu292voon96aCaRSTSPwVvNFoK6gk0chZs9tuExZEVKkuJgl3FB8aJQlFqbbWrATGZKrLkt2dLynALPDkUnglKoR5Atv9basktQWYYMCWTg7sn6dQEqdUcOG0mkWqC1wAJF71uwKH0y5QIHdAudxzOQww/hrgfxj1RQskAM8JeOsyTkOAr0TykZN1DaE0a5IAeXp+Es0FaFpIexOeNStHsBzqvOOI+iVOhd+XPxUFxSOxqvrmmmewL/l2lgEXHH0CwvlsgLAODJAPaMitTfQgRKAZfBNOKuyrXPAF1/VNyF7/PGRilfoDiIfgnoSu6FZLFQCN3maI7aNeD3qn+Pvd/19ib319vP+ccPnTxf5w/N0Ds3/+fOgL8ayl1Udn9LGzvh01F9PbybZHHGfUsoZNc8KRDUW87CzbLv4Jk/ZOSdaTlGRzfS2s5bLfbet6f8/hBm+41DH8supx686NuTyPS3vWXVXc+bfidA9GY7c+rrI8y7VZXbrGo7zjd7OqdNZN7uXtv1v1Rb9aSTJs+9zmfoGUPR7WbMIgwIVnNvCbf8P/V0mx/p92NQCvGv8Yivq5SnjfjFPwU3M8kwB8sS6GUVWdAiaoNDOpTQE80Y1LlieUN2M1EW+QEd4i3sPlJSGFwVs6UVPz4cFPOTx5a4KvPFrX+wljC0LKB8jlAEEEswEl0GMYgnlK1NTX8BDJN3gKFoGvEQnb0U+mcLrThDfGJ9z/QD9iEI6ZO1H5BuXL3SgrDukHpEKHYTIcF9M5BqQ55hRvOWUWICh6yOg8dC5ComjwwUPFnGajkai70vARfalDE94Yn3D/A/2IQfiNuVP6/Ably92opabGeUAqdP8wGY57EHNF6FVzL5cUbzllFiAoeshoGDoXIdUPM/jgoRoRS7ORXU/0VQzXV/mv20Sp1MHSVsQeKLR234LRQZZKAAAA') format('woff2'),
  url('//at.alicdn.com/t/font_2387107_y08svn14rym.woff?t=1614231779666') format('woff'),
  url('//at.alicdn.com/t/font_2387107_y08svn14rym.ttf?t=1614231779666') format('truetype'), /* chrome, firefox, opera, Safari, Android, iOS 4.2+ */
  url('//at.alicdn.com/t/font_2387107_y08svn14rym.svg?t=1614231779666#iconfont') format('svg'); /* iOS 4.1- */
}

.iconfont {
  font-family: "iconfont" !important;
  font-size: 12px;
  font-style: normal;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.iconyanjing:before {
  content: "\e62c";
}

.loading{
    text-align: center;
    height: 50px;
    line-height: 45px;
    width: 100%;
    float: left;
}
.body{
    width: 70%;
    margin: auto;
    display: block;
}
.kj{
    width: 5%;
    height: 100px;
    float: left;
}
.fl_list{
    text-align: center;
    float: left;
    padding:0px 10px 10px;
    width: 10%;
    border-radius: 12px;
    box-shadow: 0 4px 8px 0 rgba(28,31,33,.1);
    border: 0.5px rgb(202 202 202) solid;
}
.wz_list{
    float: left;
    text-align: left;
    padding:8px;
    border-radius: 12px;
    width: 70%;
    border: 1px rgb(202 202 202) solid;
}
.flitem{
    margin: auto;
    width: 80%;
    padding:8px;
    border-radius: 6px;
    margin-top:15px;
    cursor: pointer;
}
.actionFl{
    background-color: rgba(51,119,255,.1);
    font-weight: 700;
    color:#37f
}
.wzitem{
    width: 100%;
    height: 80px;
    padding: 0 4px;
    box-sizing: border-box;
    margin-bottom: 0;
    background: #fff;
    box-shadow: unset;
    border-radius: 0;
    transition: all .3s;
}
.imgCon{
    width: 13%;
    height: 80px;
    border-radius: 8px;
    margin: 8px 16px 6px 16px;
}
.l{
    float: left;
}
.imgCon img{
    width: 100%;
    height: 100%;
    border-radius: 8px;
}
.wz_contain{
    width: 80%;
    height: 83px;
    padding-top: 10px;
    border-bottom: 1px solid rgba(28,31,33,.1);
    position: relative;
}
.wz_contain p {
    font-weight: 700;
    margin-bottom: 4px;
    font-size: 16px;
    color: #1c1f21;
    line-height: 30px;
    word-break: keep-all;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    transition: all .3s;
}
.wz_contain p:hover{
    color: #2618ff;
}
.moco-label {
    padding: 4px 12px;
    font-size: 13px;
    color: #545c63;
    line-height: 24px;
    background: rgba(84,92,99,0.1);
    border-radius: 12px;
    cursor: pointer;
    margin-right: 30px;
}

.browseNum {
    margin-right: 25px;
    font-size: 12px;
    color: #9199a1;
    line-height: 24px;
    padding-top: 3px;
}
.wz_contain_bottom_left .time{
    float: right;
}
a{
    text-decoration: none;
    cursor: pointer;
}
p{
    padding: 0px;
    margin: 0px;
}
</style>