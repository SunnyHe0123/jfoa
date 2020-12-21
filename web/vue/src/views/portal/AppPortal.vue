<template>
    <div class="app-portal">
        <portal-toolbar></portal-toolbar>
        <router-view></router-view>
    </div>
</template>

<script>
    import PortalToolbar from "./PortalToolbar";
    export default {
        name: "AppPortal",
        components: {PortalToolbar},
    }
</script>

<style lang="scss" scoped>
    .app-portal {
        height: 100%;
    }

</style>