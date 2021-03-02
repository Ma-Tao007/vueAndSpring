module.exports = {
    devServer: {
        proxy: {
            '/': {
                //请求地址
                target: "http://localhost:8081",
                //是否跨域
                changeOrigin: true,
            }
        }
    },
};