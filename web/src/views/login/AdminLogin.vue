<template>
  <div class="a">
    <div class="admin">
      <h3>管理员登录</h3>
      <el-form :model="admin_input" ref="admin_input" class="user_login_form">
        <el-form-item prop="a_email">
          <el-input placeholder="Email" v-model="admin_input.username"></el-input>
        </el-form-item>
        <el-form-item prop="a_password">
          <el-input placeholder="Password" show-password v-model="admin_input.password"></el-input>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click.prevent="adminLogin">登 录</el-button>
    </div>
  </div>
</template>

<script>
import { login } from 'network/users';

  export default {
    name: "AdminLogin",
    data(){
      // var checkEmail = (rule, value, callback) => {
      //   const mailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/
      //   if (!value) {
      //     return callback(new Error('邮箱不能为空'))
      //   }
      //   setTimeout(() => {
      //     if (mailReg.test(value)) {
      //       callback()
      //     } else {
      //       callback(new Error('请输入正确的邮箱格式'))
      //     }
      //   }, 100)
      // }
      // var checkPassword = (rule, value, callback) => {
      //   const pwdReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z\\W]{6,18}$/
      //   if (!value) {
      //     return callback(new Error('密码不能为空'))
      //   }
      //   setTimeout(() => {
      //     if (pwdReg.test(value)) {
      //       callback()
      //     } else {
      //       callback(new Error('密码必须包含数字和字母，长度6-18'))
      //     }
      //   }, 100)
      // }

      return{
        admin: [],
        admin_input: {
          usernameusername: '',
          password: '',
          roleId: 1
        }
        // rules: {
        //   a_email: [
        //     { validator: checkEmail, trigger: 'blur' }
        //   ],
        //   a_password: [
        //     { validator: checkPassword, trigger: 'blur'}
        //   ]
        // }
      }
    },
    created(){
    },
    methods:{
       adminLogin(){
        //  this.$router.replace('/user_home')
        if (this.admin_input.username === '' || this.admin_input.password === ''){
          this.$message.error({
            message: '账号或密码为空，请重新填写',
            type: 'error'
          })
        }
        login(this.admin_input).then(response => {
              if(response.code === 0) {
                  this.$message.success({
                    message: response.msg
                 })

                 this.$cookies.set('userToken',  response.result.token)
                this.$router.push('/admin_home')
              } else {
                this.$message.error({
                   message: response.msg
                })
              }
              
            })
        }
    }
  }
</script>

<style scoped>
  html,body{
    margin: 0;
    padding: 0;
  }
  .a{
    margin-top: -20px;
    width: 100%;
    height: 100vh;
    background-color: #f4f4f4;
  }
  .admin{
    margin: 0 auto;
    width: 500px;
  }
  .admin h3{
    padding-top: 30%;
  }

  .el-button--primary{
    width: 500px;
  }

  .l{
    position: absolute;
    bottom: 5px;
    right: 5px;
  }
</style>