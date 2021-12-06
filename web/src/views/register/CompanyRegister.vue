<template>
  <section id="total">
    <header id="header">
      <nav class="navbar">
        <!--导航栏标志，校园招聘-->
        <a class="navbar-brand col-lg-6 col-md-5 col-sm-4 col-xs-4" href="/user_home"><img src="~assets/img/tabbar/logo.png"></a>
      </nav>
    </header>
    <div class="login-box">
      <div id="myTabContent" class="tab-content">
        <!--应聘登陆界面-->
        <div id="recruit">
          <div class="login-content">
            <h3>Register</h3>
            <el-form :model="re_users" :rules="rules" ref="re_users" class="user_re_form">
              <el-form-item prop="username">
                <el-input v-model.trim="re_users.username" placeholder="邮箱"></el-input>
              </el-form-item>
              <el-form-item prop="password">
                <el-input v-model.trim="re_users.password" placeholder="密码" show-password></el-input>
              </el-form-item>
              <el-form-item prop="password_confirm">
                <el-input v-model="re_users.password_confirm" placeholder="密码确认" show-password></el-input>
              </el-form-item>
              </el-form-item>
            </el-form>
            <el-button type="success" :loading="u_r_isClick" @click="userRegister">注 册</el-button>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
  import {addUser} from "network/users";

  export default {
    name: "UserRegister",
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
        const pwdReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z\\W]{6,18}$/
        if (!value) {
          return callback(new Error('密码不能为空'))
        }
        setTimeout(() => {
          if (pwdReg.test(value)) {
            callback()
          } else {
            callback(new Error('密码必须包含数字和字母，长度6-18'))
          }
        }, 100)
      }
      var uCheckPassword = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('密码不一致'))
        }
        setTimeout(() => {
          if (value === this.re_users.password) {
            callback()
          } else {
            callback(new Error('密码不一致'))
          }
        }, 100)
      }

      return{
        rules: {
          username: [
            { validator: checkEmail, trigger: 'blur' }
          ],
          assword: [
            { validator: checkPassword, trigger: 'blur' }
          ],
          password_confirm: [
            { validator: uCheckPassword, trigger: 'blur' }
          ]
        },
        re_users: {
          username: '',
          password: '',
          password_confirm: '',
          roleId: 3
        },
        u_r_isClick: false,
        users: [],
        uIsPost: true,
      }
    },
    created(){
    },
    methods:{
      userRegister(){
        if (this.re_users.username === '' || this.re_users.password === '' || this.re_users.password_confirm === ''){
          this.$message.error({
            message: '未正确输入邮箱或密码，请重试'
          })
        } else {
          this.$refs['re_users'].validate((valid) => {
          if (valid) {
            addUser(this.re_users).then(response => {
              if(response.code === 0) {
                  this.$message.success({
                    message: response.msg
                 })
                 setTimeout(() => {
                    this.$router.push('/company_login')
                  }, 2000)
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

          
        }
      }
    }
  }
</script>

<style scoped>
  @import "~assets/css/lrmodule/LRModule.css";

  .user_re_form{
    margin: 0 auto;
    width: 400px;
  }
  .company_re_form{
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

  .r{
    position: absolute;
    bottom: 5px;
    right: 5px;
  }
</style>