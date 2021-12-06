<template>
  <div class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-12">
          <div class="card">
            <div class="card-header card-header-primary">
              <h4 class="card-title">Edit Profile</h4>
              <p class="card-category">Complete your profile</p>
            </div>
            <div class="card-body">
              <el-form ref="userInfo" :model="{userInfo}">
                <div class="row">
                  <div class="col-md-4">
                    <div class="form-group">
                      <el-form-item label="真实姓名:" prop="realName">
                        <el-input v-model="userInfo.realName" :disabled="isDisabled"></el-input>
                      </el-form-item>
                    </div>
                  </div>
                  <div class="col-md-8">
                    <div class="form-group">
                      <el-form-item label="联系方式:" prop="mobile">
                        <el-input v-model="userInfo.mobile" :disabled="isDisabled"></el-input>
                      </el-form-item>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-3">
                    <div class="form-group">
                      <el-form-item label="性别:">
                        <el-select v-model="userInfo.sex" value="" :disabled="isDisabled">
                          <el-option label="男" value="男"></el-option>
                          <el-option label="女" value="女"></el-option>
                        </el-select>
                      </el-form-item>
                    </div>
                  </div>
                   <div class="col-md-4">
                    <div class="form-group">
                      <el-form-item label="出生日期:">
                        <el-date-picker
                                v-model="userInfo.birthday"
                                type="date"
                                placeholder="选择月"
                                format="yyyy-MM-dd"
                                :disabled="isDisabled">
                        </el-date-picker>
                      </el-form-item>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="form-group">
                      <el-form-item label="毕业年份:">
                        <el-date-picker
                                v-model="userInfo.graduateDate"
                                type="date"
                                format="yyyy-MM-dd"
                                placeholder="选择年"
                                :disabled="isDisabled">
                        </el-date-picker>
                      </el-form-item>
                    </div>
                  </div>
                </div>

                <div class="row">
                  <div class="col-md-8">
                    <div class="form-group">
                      <el-form-item label="毕业院校:" prop="graduateSchool">
                        <el-input v-model="userInfo.graduateSchool" :disabled="isDisabled"></el-input>
                      </el-form-item>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="form-group">
                      <el-form-item label="学历:">
                        <el-select v-model="userInfo.education" value="" :disabled="isDisabled">
                          <el-option label="无" value="无"></el-option>
                          <el-option label="小学" value="小学"></el-option>
                          <el-option label="初中" value="初中"></el-option>
                          <el-option label="高中" value="高中"></el-option>
                          <el-option label="大专" value="大专"></el-option>
                          <el-option label="本科" value="本科"></el-option>
                          <el-option label="硕士" value="硕士"></el-option>
                          <el-option label="博士" value="博士"></el-option>
                        </el-select>
                      </el-form-item>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="form-group">
                      <div class="form-group">
                        <el-form-item label="介绍自己:">
                        <el-input
                                type="textarea"
                                placeholder="请输入内容"
                                v-model="userInfo.introduction"
                                rows="3"
                                maxlength="200"
                                show-word-limit
                                :disabled="isDisabled">
                        </el-input>
                      </el-form-item>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                      <div class="form-group">
                        <el-form-item label="我的简历:">
                          <Upload v-model="userInfo.curriculumVitae" :path="uploadPath" :disabled="isDisabled"/>
                       </el-form-item>
                      </div>
                  </div>
                   
                </div>
                <!--保存资料按钮-->
                <button class="btn btn-primary pull-right" @click.prevent="userInfoSave">保 存</button>
                <button class="btn btn-success pull-right" @click.prevent="changeDisabledState">修 改</button>
                <div class="clearfix"></div>
              </el-form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {updateUserInfo, addUserInfo, getUserDetailInfoById} from "network/users";
  import Upload from 'components/upload/UploadImage.vue';
  export default {
    name: "pForm",
    components: {Upload},
    data(){
      return{
        isDisabled: true,
        user: [],
        userInfo:{
          id: '',
          userId: '',
          realName: '',
          birthday: '',
          mobile: '',
          sex: '',
          graduateDate: '',
          graduateSchool: '',
          education: '',
          introduction: '',
          curriculumVitae:''
        },
        uploadPath:'http://127.0.0.1:9999/recruiment-website-system/upload'
      }
    },
    created(){
      getUserDetailInfoById().then(response => {
        if(response.result) {
           this.userInfo = response.result
        }
      })
    },
    methods:{
      userInfoSave(){
        if( this.userInfo.id ) {
           //不是空就执行更新数据，而不是添加
          updateUserInfo(this.userInfo).then(res => {
            this.$message.success({
              message: '信息保存成功',
            })
            this.isDisabled = true
          })
        } else {
           addUserInfo(this.userInfo).then(res => {
            this.$message.success({
              message: '信息保存成功',
            })
            this.isDisabled = true
          })
        }
      },
      changeDisabledState(){
        this.isDisabled = false
      }
    }
  }
</script>

<style scoped>
  @import "~assets/css/p-form/form.css";

  .btn-primary{
    margin-left: 5px;
  }

  .form-group{
    margin: 0;
  }
</style>