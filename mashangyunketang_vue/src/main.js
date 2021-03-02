import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import axios from 'axios'
Vue.prototype.$axios = axios;

Vue.config.productionTip = false

new Vue({
    router,
    render: function(h) { return h(App) }
}).$mount('#app')