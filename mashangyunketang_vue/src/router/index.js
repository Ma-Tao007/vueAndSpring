import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index.vue'


Vue.use(VueRouter)

const routes = [{
        path: '/',
        redirect: '/index',
    }, {
        path: '/index',
        name: 'index',
        //指向views里面的页面
        component: Index
    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: function() {
            return import ( /* webpackChunkName: "about" */ '../views/About.vue')
        }
    },
    {
        path: '/course',
        name: 'Course',
        component: function() {
            return import ('../views/Course.vue')
        }
    }, ,
    {
        //文章管理页面
        path: '/content',
        name: 'Content',
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/Content.vue')
    },
    {
        //文章详情页面
        path: '/details',
        name: 'Details',
        component: () =>
            import ('../views/Details.vue')
    },
    {
        path: '/teachers',
        name: 'Teachers',
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/Teachers.vue')
    }
    //名师路由
    // {
    //     path: '/teachers',
    //     name: 'Teachers',
    //     component: function() {
    //         return import ('../views/Teachers.vue')
    //     }
    // }
    //文章路由
    // {
    //     path: '/content',
    //     name: 'Content',
    //     component: function() {
    //         return import ('../views/Content.vue')
    //     }
    // },
]

const router = new VueRouter({
    routes
})

export default router