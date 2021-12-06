<template>
  <div class="login">
    <l-r-module>
      <!--用户登录-->
      <div slot="l-btn">
        <div class="l_btn">
          <el-button type="default" @click="userLoginBtn">用户登录</el-button><br/>
          <el-button type="default" @click="companyLoginBtn">企业登录</el-button><br/>
          <el-button type="default" @click="adminLoginBtn">管理员登录</el-button>
        </div>
      </div>

    </l-r-module>
  </div>
</template>

<script>
  import LRModule from "components/lrmodule/LRModule";

  export default {
    name: "login",
    components: {
      LRModule
    },
    methods:{
      userLoginBtn(){
        this.$router.push('/user_login')
      },
      companyLoginBtn(){
        this.$router.push('/company_login')
      },
      adminLoginBtn(){
        this.$router.push('/admin_login')
      }
    }
  }
</script>

<style scoped>
  @import "~assets/css/lrmodule/LRModule.css";

  .el-button--primary{
    width: 400px;
  }
  .el-button--success{
    margin-top: 1px;
    width: 400px;
  }

  .l_btn{
    margin: 22% 11%;
  }
  .el-button{
    margin-top: 10px;
    width: 400px;
    height: 50px;
  }

  .l{
    position: absolute;
    bottom: 5px;
    right: 5px;
  }
</style>