<template>
  <div>
    <h2 class="sub-header">Information</h2>
      <div class="row">
        <div class="col-md-12">
          <div class="card">
            <!--填表单部分-->
            <div class="card-body">
              <el-form ref="c_info" :model="{c_info}">
                <div class="row">
                  <div class="col-md-4">
                    <div class="form-group">
                      <el-form-item label="公司名称:" prop="cName">
                        <el-input v-model="c_info.cName" :disabled="isDisabled"></el-input>
                      </el-form-item>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="form-group">
                      <el-form-item label="公司Logo:" prop="cName">
                        <Upload v-model="c_info.cLogo" :path="uploadPath" :disabled="isDisabled"/>
                      </el-form-item>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <div class="form-group">
                      <el-form-item label="成立时间:">
                        <el-date-picker
                                v-model="c_info.cEstablished"
                                type="month"
                                placeholder="选择月"
                                :disabled="isDisabled">
                        </el-date-picker>
                      </el-form-item>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-2">
                    <div class="form-group">
                      <el-form-item label="当前状态:">
                        <el-select v-model="c_info.cCurrentstate" value="" :disabled="isDisabled">
                          <el-option label="已上市" value="已上市"></el-option>
                          <el-option label="未上市" value="未上市"></el-option>
                        </el-select>
                      </el-form-item>
                    </div>
                  </div>
                  <div class="col-md-9">
                    <div class="form-group">
                      <el-form-item label="联系方式:" prop="cContact">
                        <el-input v-model="c_info.cContact" :disabled="isDisabled"></el-input>
                      </el-form-item>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-3">
                    <div class="form-group">
                      <el-form-item label="公司类型:" prop="cType">
                        <el-input v-model="c_info.cType" :disabled="isDisabled"></el-input>
                      </el-form-item>
                    </div>
                  </div>
                  <div class="col-md-7">
                    <div class="form-group">
                      <el-form-item label="公司地址:" prop="cAddress">
                        <el-input v-model="c_info.cAddress" :disabled="isDisabled"></el-input>
                      </el-form-item>
                    </div>
                  </div>
                  <div class="col-md-2">
                    <div class="form-group">
                      <el-form-item label="所在城市:" prop="cCity">
                        <el-select v-model="c_info.cCity" filterable placeholder="请选择" :disabled="isDisabled">
                          <el-option
                        v-for="item in cities"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                        </el-option>
                        </el-select>
                      </el-form-item>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="form-group">
                      <div class="form-group">
                        <el-form-item label="公司简介:">
                          <el-input
                                  type="textarea"
                                  placeholder="请输入内容"
                                  v-model="c_info.cDescribe"
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
                <!--保存资料按钮-->
                <button class="btn btn-primary pull-right" @click.prevent="cfsaveClick" >保 存</button>
                <button class="btn btn-success pull-right" @click.prevent="changeInfo">修 改</button>
                <div class="clearfix"></div>
              </el-form>
            </div>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
  import {addCompanyInfo, getUserCompanyInfo} from "network/company";
  import {updateCompanyInfo} from "network/company";
  import Upload from 'components/upload/UploadCImage.vue';
  export default {
    name: "CForm",
    components: {Upload},
    data(){
      return{
        c_info: {
          cId: '',
          cName: '',
          cEstablished: '',
          cCurrentstate: '',
          cContact: '',
          cType: '',
          cAddress: '',
          cCity: '',
          cDescribe: ''
        },
        uploadPath:'http://127.0.0.1:9999/recruiment-website-system/upload',
        company: [],
        cities: [
                 { value: 1, label: '北京' },
                 { value: 2, label: '天津' },
                 { value: 3, label: '成都' },
                 { value: 4, label: '广州' },
                 { value: 5, label: '南京' },
                 { value: 6, label: '深圳' },
                 { value: 7, label: '西安' },
                 { value: 8, label: '武汉' },
                 { value: 9, label: '上海' }],
        isDisabled: true
      }
    },
    created(){
      if (this.$cookies.get('userInfo')){
        this.isLogin = true
      }
      this.fetch()
    },
    methods: {
      fetch(){
        getUserCompanyInfo().then(res => {
          if(res.result){
            this.c_info = res.result
          }
          
        })
      },
      cfsaveClick(){
        if (this.c_info.cId !== ''){
          updateCompanyInfo(this.c_info).then(res => {
            this.$message.success({
              message: '信息更新成功'
            })
            this.isDisabled = true
            this.fetch()
          })
        } else {
          addCompanyInfo(this.c_info).then(res => {
            this.$message.success({
              message: '信息保存成功'
            })
            this.isDisabled = true
            this.fetch()
          })
        }
      },
      changeInfo(){
        this.isDisabled = false
      }
    }
  }
</script>

<style scoped>

  .btn-primary{
    margin-left: 5px;
  }

  .form-group{
    margin: 0;
  }
</style>