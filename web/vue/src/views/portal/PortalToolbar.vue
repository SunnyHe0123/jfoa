<template>
    <div class="portal-toolbar">
        <el-menu class="el-menu-demo" mode="horizontal" background-color="#545c64" text-color="#fff"
                 active-text-color="#ffd04b">
            <el-menu-item index="1">Home</el-menu-item>
            <el-menu-item index="2">Subject to Vote </el-menu-item>
            <el-submenu index="3">
                <template slot="title">Support</template>
                <el-menu-item index="3-1">Document</el-menu-item>
                <el-menu-item index="3-2">Api Document</el-menu-item>
                <el-menu-item index="3-3">Client Download</el-menu-item>
            </el-submenu>
            <el-menu-item index="4">Language</el-menu-item>
            <el-menu-item index="5">Help</el-menu-item>
            <el-submenu index="6">
                <template slot="title">Account</template>
                <el-menu-item index="6-1">Profile (Anonymous)</el-menu-item>
                <el-menu-item index="6-2">Sign in</el-menu-item>
                <el-menu-item index="6-3">Sign out</el-menu-item>
            </el-submenu>

        </el-menu>
    </div>
</template>

<script>
    export default {
        name: "PortalToolbar",

        methods: {
            getIcon() {
                console.log("=======get==icon=====");
                return "../jfoa-icon.ico";
            }
        }
    }
</script>

<style lang="scss" scoped>
    .portal-toolbar {
        width: 100%;
        height: 60px;
        display: flex;

        .el-menu {
            width: 100%;
        }
    }

    .jfoa-icon-size {
        font-size: 24px;
        text-align: center;
        vertical-align: center;
        height: 52px;
    }

</style>