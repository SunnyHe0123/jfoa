<template>
   <div>
      <div>AppPortal</div>
   </div>
</template>

<script>
    export default {
       name: "AppPortal",
       //life circle hooks
       beforeCreate() {
          console.log("====before=create=======")
       },
       created() {
          document.body.className += " app-loaded"
       }
    }
</script>

<style scoped>

</style>
