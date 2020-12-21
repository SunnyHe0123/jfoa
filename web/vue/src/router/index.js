import Vue from "vue";
import VueRouter from "vue-router";
import AppPortal from "../views/portal/AppPortal";
import EMComponent from "../views/em/EMComponent";
import PortalWelcome from "../views/portal/PortalWelcome";

Vue.use(VueRouter);

const routes = [
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue")
  },
  {
    path: "/portal",
    component: AppPortal,
    children: [
      {
        path: "welcome",
        component: PortalWelcome
      },
      {
        path: "*",
        redirect: "welcome"
      },
      {
        path: "",
        redirect: "welcome"
      }
    ]
  },
  {
    path: "/em",
    name: "em",
    component: EMComponent
  },
  {
    path: "*",
    redirect: "portal"
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
