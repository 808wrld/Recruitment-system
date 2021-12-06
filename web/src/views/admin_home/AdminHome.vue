<template>
  <div>
    <el-container style="height: 100vh; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu router :default-openeds="['1']">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-s-order"></i>信息管理</template>
            <el-menu-item :class="{ active: uIsShow }" @click="showU">求职用户管理</el-menu-item>
            <el-menu-item :class="{ active: cIsShow }" @click="showC">企业管理</el-menu-item>
            <el-menu-item :class="{ active: jIsShow }" @click="showJ">职位管理</el-menu-item>
            <el-menu-item :class="{ active: lIsShow }" @click="showL">用户投诉</el-menu-item>
            <el-menu-item :class="{ active: pIsShow }" @click="showP">首页公告</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <span v-if="isLogin" style="margin-right: 20px; font-size: 15px">管理员，欢迎您!</span>
          <el-button @click="adminQuit">退出</el-button>
        </el-header>

        <el-main>
          <user-action v-if="uIsShow"/>
          <company-action v-if="cIsShow"/>
          <job-action v-if="jIsShow"/>
          <complain-action v-if="lIsShow"/>
          <notice-action v-if="pIsShow"/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  import UserAction from "./UserAction";
  import CompanyAction from "./CompanyAction";
  import JobAction from "./JobAction";
  import NoticeAction from './NoticeAction';
  import ComplainAction from './ComplainAction';
  export default {
    name: "AdminHome",
    components: {JobAction, CompanyAction, UserAction, NoticeAction, ComplainAction},
    data(){
      return{
        uIsShow: true,
        cIsShow: false,
        jIsShow: false,
        pIsShow: false,
        lIsShow: false,
        admin: [],
        isLogin: false
      }
    },
    created(){
      if (this.$cookies.get('userToken')){
        this.isLogin = true
      }
    },
    methods: {
      showU(){
        this.uIsShow = true
        this.cIsShow = false
        this.jIsShow = false
        this.pIsShow = false
        this.lIsShow = false
      },
      showC(){
        this.uIsShow = false
        this.cIsShow = true
        this.jIsShow = false
        this.pIsShow = false
        this.lIsShow = false
      },
      showJ(){
        this.uIsShow = false
        this.cIsShow = false
        this.jIsShow = true
        this.pIsShow = false
        this.lIsShow = false
      },
      showP(){
        this.uIsShow = false
        this.cIsShow = false
        this.jIsShow = false
        this.pIsShow = true
        this.lIsShow = false
      },
      showL(){
        this.uIsShow = false
        this.cIsShow = false
        this.jIsShow = false
        this.pIsShow = false
        this.lIsShow = true
      },
      
      adminQuit(){
          this.$cookies.remove('userToken')
          this.isLogin = false
          this.$message.success({
            message: '退出成功'
          })
          this.$router.replace('/login')
      }
    }
  }
</script>

<style scoped>
  html,body{
    margin: 0;
    padding: 0;
  }

  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }

  .active{
    background-color: #edf4ff;
  }
</style>