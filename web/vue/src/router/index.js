import VueRouter from 'vue-router'
import Vue from "vue"
import HelloWorld from "../components/HelloWorld";

Vue.use(VueRouter)

export default new VueRouter({
    mode: "history",
    routes: [{
        path: "/",
        component: HelloWorld
    }]
})

