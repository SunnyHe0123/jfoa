import VueRouter from 'vue-router'
import Vue from "vue"
import AppPortal from "../app/portal/components/AppPortal";
import EMComponent from "../app/em/components/EMComponent";
import HelloWorld from "../components/HelloWorld";
import AppRouting from "../app/portal/app-routing"
import Welcome from "../app/portal/components/Welcome";

Vue.use(VueRouter)

export default new VueRouter({
    mode: "history",
    routes: [{
        path: "/",
        component: HelloWorld,
        children: [
            {
                path: "portal",
                component: AppPortal
            },
            {
                path: "em",
                component: EMComponent
            },
            {
                path: "wel",
                component: Welcome
            },
            ...AppRouting
        ]
    }]
})

