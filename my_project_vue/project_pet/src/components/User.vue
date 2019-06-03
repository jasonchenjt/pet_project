<template>
  <div class="User">
    <label>User:</label><textarea v-model='username'></textarea>
    <label>Password:</label><textarea v-model='password'></textarea>
    <button @click="login()">点击登录</button>
  </div>
</template>

<script>
  import qs from 'qs'


    export default {
      name: "User",
      data(){
         return{
           username: '',
           password: ''
        }
      },
      methods: {
        login:function () {
          let postdata = qs.stringify({
            username:this.username,
            password: this.password
          })
          this.axios.post('api/login',postdata).then((response)=>{
            this.message=response.data;
            console.log(this.message);
          }).catch((response)=>{
            console.log(response);
          })
        }
      }

    }
</script>

<style scoped>

</style>
