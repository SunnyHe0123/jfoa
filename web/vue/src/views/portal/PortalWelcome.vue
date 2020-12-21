<template>
    <div class="portal-content">
        <iframe src="https://javafamilyclub.github.io/jfoa" class="welcome-container"></iframe>
    </div>
</template>

<script>
    export default {
        name: "PortalWelcome"
    }
</script>

<style lang="scss" scoped>
    .portal-content {
        height: calc(100% - 60px);
    }

    .welcome-container {
        width: 100%;
        height: 100%;
        border: 0;
        border-radius: 8px;
    }

</style>