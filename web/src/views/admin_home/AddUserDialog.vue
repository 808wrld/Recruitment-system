<template>
  <el-dialog
    :visible.sync="visible"
    :title="modalObj.title"
    :width="modalObj.width"
    :modal="modalObj.modal"
    :before-close="modalClose"
    :close-on-click-modal="false"
    :close-on-press-escape="true"
    append-to-body
  >

    <div class="login-box">
      <div id="myTabContent" class="tab-content">
        <!--应聘登陆界面-->
        <div id="recruit">
          <div class="login-content">
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
              <el-form-item prop="昵称">
                <el-input v-model="re_users.nickName" placeholder="昵称"></el-input>
              </el-form-item>
            </el-form>
            <el-button type="success" :loading="u_r_isClick" @click="userRegister">注 册</el-button>
          </div>
        </div>
      </div>
    </div>
  </el-dialog>
</template>
<script>
  import {addUser} from "network/users";

export default {
  name: 'AddUserDialog',
  props: {
    visible: {
      type: Boolean,
      default: false
    },
    modalObj: {
      type: Object,
      default: null
    }
  },
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
          nickName: ''
        },
        u_r_isClick: false,
        users: [],
        uIsPost: true,
      }
    },
  created() {
    // test
  },
  // 页面渲染完成
  mounted() {
    if (this.modalObj && this.modalObj.roleId) {
        this.re_users.roleId = this.modalObj.roleId
    }
  },
  methods: {
    // 关闭弹出框
    modalClose() {
      this.$emit('update:visible', false) // 直接修改父组件的属性
    },
    userRegister(){
        if (this.re_users.username === '' || this.re_users.password === '' || this.re_users.password_confirm === ''){
          this.$message.error({
            message: '未正确输入邮箱或密码，请重试'
          })
        } else {
          addUser(this.re_users).then(response => {
              if(response.code === 0) {
                  this.$message.success({
                    message: response.msg
                 })
                this.modalClose()
              } else {
                this.$message.error({
                   message: response.msg
                })
              }
            })
        }
      }
  }
}
</script>
