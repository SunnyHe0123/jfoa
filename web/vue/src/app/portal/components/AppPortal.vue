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
          console.log("===create=======")
          document.body.style += " app-loaded"
       }
    }
</script>

<style scoped>

</style>
