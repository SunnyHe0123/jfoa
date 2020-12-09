import VueRouter from 'vue-router'
import Vue from "vue"
import AppPortal from "../app/portal/components/AppPortal";
import EMComponent from "../app/em/components/EMComponent";

Vue.use(VueRouter)

export default new VueRouter({
    mode: "history",
    routes: [
        {
            path: "/portal",
            component: AppPortal
        },
        {
            path: "/em",
            component: EMComponent
        }

    ]
})

