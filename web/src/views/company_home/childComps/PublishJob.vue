<template>
  <div class="publish">
    <h2 class="sub-header">Publish Jobs</h2>
    <div class="row">
      <el-form ref="job_info" :model="job_info">
        <el-form-item label="职位名称:" prop="jName" required
        :rules="[
      { required: true, message: '请输入职位名称', trigger: 'blur' },
    ]">
          <el-input v-model="job_info.jName" :disabled="isDisabled"></el-input>
        </el-form-item>
        <el-form-item label="开始时间:" required 
        prop="jStime" 
        :rules="[
          { required: true, message: '请选择开始时间', trigger: 'blur' },
          { type: 'date', required: true, message: '请选择开始时间', trigger: 'change' }
        ]">
          <el-date-picker
                  v-model="job_info.jStime"
                  type="month"
                  placeholder="选择月"
                
                  :disabled="isDisabled">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束时间:" required
        prop="jEtime" 
        :rules="[
          { required: true, message: '请选择结束时间', trigger: 'blur' },
          { type: 'date', required: true, message: '请选择结束时间', trigger: 'change' }
        ]">
          <el-date-picker
                  v-model="job_info.jEtime"
                  type="month"
                
                  placeholder="选择月"
                  :disabled="isDisabled">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="招聘人数:" required prop="jNumber"
        :rules="[
          { required: true, message: '请输入招聘人数', trigger: 'blur' },
        ]"
        >
          <el-input v-model="job_info.jNumber" :disabled="isDisabled"></el-input>
        </el-form-item>

        <el-form-item label="工资范围:" required prop="jSalaryMin"
        :rules="[
          { required: true, message: '请输入工资范围', trigger: 'blur' },
        ]"
        >
          <el-input v-model="job_info.jSalaryMin" :disabled="isDisabled" style="width:200px"></el-input>
          ~
          <el-input v-model="job_info.jSalaryMax" :disabled="isDisabled" style="width:200px"></el-input>
        </el-form-item>

        <el-form-item label="职位类型:" required
        prop="jType" 
        :rules="[
          { required: true, message: '请选择职位类型', trigger: 'change' }
        ]">
          <el-select v-model="job_info.jType" :disabled="isDisabled" filterable placeholder="请选择">
            <el-option
                    v-for="item in type"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="要求学历:" required 
         prop="jEducation" 
        :rules="[
          { required: true, message: '请选择要求学历', trigger: 'change' }
        ]">
          <el-select v-model="job_info.jEducation" value="" :disabled="isDisabled">
            <el-option :value="1" label="不限"></el-option>
            <el-option :value="2" label="大专"></el-option>
            <el-option :value="3" label="本科"></el-option>
            <el-option :value="4" label="硕士"></el-option>
            <el-option :value="5" label="博士"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="工作经验:" required
         prop="jExperience" 
        :rules="[
          { required: true, message: '请选择工作经验', trigger: 'change' }
        ]">
          <el-select v-model="job_info.jExperience" value="" :disabled="isDisabled">
            <el-option :value="1" label="不限"></el-option>
            <el-option :value="2" label="一年以内"></el-option>
            <el-option :value="3" label="一到三年"></el-option>
            <el-option :value="4" label="三年以上"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="职位简介:">
          <el-input
                  type="textarea"
                  placeholder="请输入内容"
                  v-model="job_info.jResume"
                  rows="3"
                  maxlength="200"
                  show-word-limit
                  :disabled="isDisabled">
          </el-input>
        </el-form-item>

        <el-form-item label="招聘员工要求:">
          <el-input
                  type="textarea"
                  placeholder="请输入内容"
                  v-model="job_info.jRequire"
                  rows="3"
                  maxlength="200"
                  show-word-limit
                  :disabled="isDisabled">
          </el-input>
        </el-form-item>

        <el-form-item label="职位待遇:">
          <el-input
                  type="textarea"
                  placeholder="请输入内容"
                  v-model="job_info.jTreatment"
                  rows="3"
                  maxlength="200"
                  show-word-limit
                  :disabled="isDisabled">
          </el-input>
        </el-form-item>

        <button type="submit" class="btn btn-primary pull-right" @click.prevent="publishJob">发 布</button>
      </el-form>
    </div>
  </div>
</template>

<script>
  import {addJob} from "network/job";
  import {getUserCompanyInfo} from "network/company";

  export default {
    name: "PublishJob",
    data(){
      return{
        rules:[],
        job_info: {
          cId: '',
          jName: '',
          jNumber: '',
          jType: '',
          jTreatment: '',
          jRequire: '',
          jResume: '',
          jEducation: '',
          jExperience: ''
        },
        type: [
                { value: '1', label: '互联网' },
                { value: '2', label: '电子商务' },
                { value: '3', label: '医疗' },
                { value: '4', label: '金融' },
                { value: '5', label: '运营' }],
        company: {},
        isDisabled: false
      }
    },
    created(){
      if (this.$cookies.get('userInfo')){
         getUserCompanyInfo().then(res => {
          this.company = res.result
        })
      }
    },
    methods: {
      publishJob(){
        this.$refs['job_info'].validate((valid) => {
          if (valid) {
            this.job_info.cId = this.company.id
        addJob(this.job_info).then(res => {
          this.$message.success({
            message: '职位发布成功'
          })
          this.isDisabled = true
        })
          } else {
            return false;
          }
        })
      }
    }
  }

</script>

<style scoped>
  .form-group{
    margin: 0;
  }
</style>