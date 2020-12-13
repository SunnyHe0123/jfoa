const path = require('path');

function resolve(dir) {
    return path.join(__dirname, dir)
}
module.exports = {
    outputDir: '../../runner/build/resources/main/static/app/', //build输出目录
    assetsDir: 'assets', //静态资源目录（js, css, img）
    publicPath: './',
    lintOnSave: true, //是否开启eslint
    devServer: {
        open: true, //是否自动弹出浏览器页面
        host: "localhost",
        port: '8080',
        https: false, //是否使用https协议
        hotOnly: false, //是否开启热更新
        proxy: null,
        overlay: {
            warnings: true,
            errors: true
        }
    },
    configureWebpack: {
        resolve: {
            alias: {
                '@assets': resolve('src/assets'),
                '@': path.resolve('src'),
                style: path.resolve('src/style')
            }
        }
    },
}
