<template>
    <div class="bg">
        <div class="login-card">
            <div class="rotate">
                <div class="card-front">
                    <h4>登录</h4>
                    <div class="img_nav"><i class="top_nav"></i></div>
                    <form action="">
                        <div class="form-group"><img class="input-icon" :src="require('./images/login.png')">
                            <input type="text" v-model="mobile" class="form-style" placeholder="请输入手机号">
                        </div>
                        <div class="form-group"><img class="input-icon" :src="require('./images/pass.png')">
                            <input type="password" v-model="password" class="form-style" placeholder="请输入密码">
                        </div>
                        <div class="form-group"><input type="button" @click="toLogin" class="input-btn" value="登录"></div>
                        <div class="form-group form-left">
                            <span>没有账号?</span>
                            <span class="btn" id="btn2">立即注册</span>
                            <span class="form-font1">忘记密码?</span>
                        </div>
                    </form>
                </div>
                <div class="card-back">
                    <form action="">
                        <h4>注册</h4>
                        <div class="img_nav"><i class="top_nav"></i></div>
                        <div class="form-group">
                            <img class="input-icon" :src="require('./images/login.png')">
                            <input type="text" v-model="mobile" class="form-style" placeholder="请输入手机号码">
                        </div>
                        <div class="form-group">
                            <img class="input-icon" :src="require('./images/pass.png')">
                            <input type="password" v-model="password" class="form-style" placeholder="请输入密码">
                        </div>
                        <div class="form-group">
                            <img class="input-icon" :src="require('./images/icon-email.png')">
                            <input type="email" v-model="email" class="form-style" placeholder="请输入邮箱地址">
                        </div>
                        <div class="form-group"><input type="button" class="input-btn" value="注册" @click="toRegister"></div>
                        <div class="form-group">
                            <span>已有账号?</span>
                            <span class="btn" id="btn">立即登录</span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>


export default {
    name: "login",
    data() {
        return {
            mobile: "",
            password: "",
            email:""
        }
    },
    props: {
        
    },
    methods: {
        start(){
            this.login();
            this.pop();
        },
        login() {
            var rotate = document.querySelector(".rotate");
            var btn = document.getElementById("btn");
            var btn2 = document.getElementById("btn2");
            btn.onclick = function() {
                rotate.classList.add("change");
            }
            btn2.onclick = function() {
                rotate.classList.remove("change");
            }
        },
        pop() {
            let _this = this;
            var bg = document.querySelector(".bg");
            var loginCard = document.querySelector(".login-card");
            var close = document.querySelector(".card-front .top_nav")
            var close2 = document.querySelector(".card-back .top_nav")
            bg.onclick = function() {
                // classLlist属性，用于在元素中添加，移除及切换 CSS 类
                loginCard.classList.remove("card-active");
                loginCard.classList.add("card-active2");
                setTimeout(function() {
                    bg.classList.remove("active")
                    _this.loginClose();
                }, 200)
            }
            loginCard.onclick = function(e) {
                if (e.target == close || e.target == close2) {
                    _this.loginClose();
                    return;
                }
                e.stopPropagation();
            }

            loginCard.classList.remove("card-active2");
                loginCard.classList.add("card-active");
                bg.classList.add("active");
        },
        loginClose() {

        },
        /** 
         * -------------------------点击登录按钮，提交表单信息
         */
        toLogin(){
            this.$axios.get('/api/user/login', 
                {params: {
                    mobile:this.mobile,
                    password:this.password
                    }
                }).then(res => {
                    let data = res.data;
                    if(data.code === 500) {
                        alert(data.message);
                    }else {
                        var bg = document.querySelector(".bg");
                        bg.click();
                        this.$store.dispatch('set_user_infor', data.infor);
                    }
                })
        },
        /**
         * -----------------------点击注册按钮，提交用户信息
         */
        toRegister(){
            this.$axios.get('/api/user/register', 
                {params: {
                        mobile:this.mobile,
                        password:this.password,
                        email:this.email
                        }
                    }).then(res => {
                        let data = res.data;
                        if(data.code === 500) {
                            alert(data.message);
                        }else {
                            var bg = document.querySelector(".bg");
                            bg.click();
                            alert(data.message);
                        }
                    })
        }
    },
}
</script>

<style lang="scss" scoped>
    @import "./css/style.css"
</style>