<template>
  <section id="total">
    <a href="/user_home"><img src="~assets/img/tabbar/logo1.png"></a>
    <div class="login">
      <h3>登录</h3>
      <el-form :model="users" :rules="rules" ref="users" class="user_login_form">
        <el-form-item prop="username">
          <el-input v-model="users.username" placeholder="Email"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="users.password" placeholder="Password" show-password></el-input>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="userLogin">登 录</el-button><br/>
      
    </div>
  </section>
</template>

<script>
import { login } from 'network/users';
import { getUserInfo } from '../../network/users';

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
          roleId: 3
        },
        user: []
      }
    },
    created(){
    },
    methods:{
      userLogin(){
        //  this.$router.replace('/user_home')
        if (this.users.username === '' || this.users.password === ''){
          this.$message.error({
            message: '账号或密码为空，请重新填写',
            type: 'error'
          })
        }
        this.$refs['users'].validate((valid) => {
          if (valid) {
            login(this.users).then(response => {
              if(response.code === 0) {
                  this.$message.success({
                    message: response.msg
                 })

                 this.$cookies.set('userToken',  response.result.token)
                 getUserInfo().then(response => {
                     this.$cookies.set('userInfo',  response.result)
                     setTimeout(() => {
                        this.$router.push('/company_home')
                    }, 500)
                 }) 
                 
              } else {
                this.$message.error({
                   message: response.msg
                })
              }
              
            })
          } else {
            return false;
          }
        });

        
        },
        // } else {
        //   for (let i = 0; i < this.user.length; i++) {
        //     if (this.user[i].u_email === this.users.u_email && this.user[i].u_password === this.users.u_password) {
        //       this.$cookies.set('userCookie', this.user[i])
        //       this.$message.success({
        //         message: '登录成功'
        //       })
        //       this.$router.replace('/user_home')
        //     } else if (this.user[i].u_email !== this.users.u_email && this.user[i].u_password !== this.users.u_password) {
        //       this.$message.error({
        //         message: '账号或密码不正确',
        //       })
        //     }
        //   }
        // }
      // },
      registerClick(){
        this.$router.push('/company_register')
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