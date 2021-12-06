<template>
  <section id="total">
    <a href="/user_home"><img src="~assets/img/tabbar/logo1.png"></a>
    <div class="login" v-if="!isRight">
      <h3>修改密码</h3>
      <el-form :model="users" :rules="rules" ref="users" class="user_login_form">
        <el-form-item prop="username">
          <el-input v-model="users.username" placeholder="Email"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="users.password" placeholder="Password" show-password></el-input>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="userLogin">确 认</el-button>
    </div>
    <div class="login" v-if="isRight">
      <h3>修改密码</h3>
      <el-form :model="user2" :rules="rules" ref="users" class="user_login_form">
        <el-form-item prop="u_password">
          <el-input v-model="user2.u_password" placeholder="Password" show-password></el-input>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="changePwd">确认修改</el-button>
    </div>
  </section>
</template>

<script>
  import {updateUserPassword} from "network/users";
import { login } from 'network/users';

  export default {
    name: "UserLogin",
    data(){
      var checkEmail = (rule, value, callback) => {
        const mailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/
        if (!value) {
          return callback(new Error('邮箱不能为空'))
        }
        setTimeout(() => {
          if (mailReg.test(value)) {
            callback()
          } else {
            callback(new Error('请输入正确的邮箱格式'))
          }
        }, 100)
      }
      var checkPassword = (rule, value, callback) => {
        const pwdReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/
        if (!value) {
          return callback(new Error('密码不能为空'))
        }
        setTimeout(() => {
          if (pwdReg.test(value)) {
            callback()
          } else {
            callback(new Error('密码由长度6-20位的字母和数字组成'))
          }
        }, 100)
      }

      return{
        rules: {
          username: [
            { validator: checkEmail, trigger: 'blur' }
          ],
          password: [
            { validator: checkPassword, trigger: 'blur'}
          ]
        },
        users:{
          username: '',
          password: '',
          roleId: 2
        },
        user: [],
        isRight: false,
        user1: [],
        user2: {
          u_password: ''
        }
      }
    },
    created(){
      if (this.$cookies.get('userInfo')){
        this.isLogin = true
        this.user1 = this.$cookies.get('userInfo')
      }
    },
    methods:{
      userLogin(){
         if (this.users.username === '' || this.users.password === ''){
          this.$message.error({
            message: '未正确输入邮箱或密码，请重试'
          })
         } else {
          login(this.users).then(response => {
              if(response.code === 0) {
                 this.isRight = true
              } else {
                this.isRight = false
                this.$message.error({
                   message: response.msg
                })
              }
            })
         }
        
      },
      changePwd(){
        updateUserPassword({password : this.user2.u_password}).then(res => {
          this.$message.success({
            message: '修改成功，请重新登录'
          })
        })
        if (this.$cookies.get('userInfo')){
          this.$cookies.remove('userInfo')
           this.$cookies.remove('userToken')
        }
        this.$router.replace('/user_login')
      }
    }
  }
</script>

<style scoped>
  @import "~assets/css/lrmodule/LRModule.css";

  .login{
    width: 500px;
    margin: 0 auto;
    text-align: center;
    padding-top: 100px;
  }

  .user_login_form{
    margin: 0 auto;
    width: 400px;
  }
  .el-button--primary{
    width: 400px;
  }
  .el-button--success{
    margin-top: 1px;
    width: 400px;
  }
  .login-content{
    margin-top: 65px;
  }

  .login-content h3{
    color: black;
  }

  .l{
    position: absolute;
    bottom: 5px;
    right: 5px;
  }
</style>