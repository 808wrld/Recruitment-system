<template>
  <div>
    <h2 class="sub-header">Launched</h2>
    <div class="table-responsive">
      <el-table :data="job" stripe ref="table">
        <el-table-column prop="jId" label="编号" width="80"></el-table-column>
        <el-table-column prop="jName" label="职位名称" width="180"></el-table-column>
        <el-table-column prop="jNumber" label="招聘人数" width="120"></el-table-column>
        <el-table-column prop="jSalary" label="工资" width="120"></el-table-column>
        <el-table-column prop="jType" label="职位类型" width="120"></el-table-column>
        <el-table-column prop="jExperience" label="所需经验" width="120"></el-table-column>
        <el-table-column prop="jStime" label="开始时间" width="120"></el-table-column>
        <el-table-column prop="jEtime" label="结束时间" width="120"></el-table-column>

        <el-table-column fixed="right" width="160">
          <template slot-scope="scope">
            <el-button type="primary" size="small" @click="modifyJobInfo(scope.row)">修改</el-button>
            <el-button
                    size="mini"
                    type="danger"
                    @click="deleteRow(scope.row)">删 除</el-button>
          </template>
        </el-table-column>
        <el-table-column type="expand">
          <template slot-scope="props">
            <h4>修改招聘信息</h4>
            <el-form ref="job_info" :model="job_info" label-position="left" inline class="demo-table-expand">
              <el-form-item label="职位名称:">
                <el-input v-model="job_info.jName"></el-input>
              </el-form-item>
              <el-form-item label="开始时间:">
                <el-date-picker
                        v-model="job_info.jStime"
                        type="month"
                        placeholder="选择月">
                </el-date-picker>
              </el-form-item>
              <el-form-item label="结束时间:">
                <el-date-picker
                        v-model="job_info.jEtime"
                        type="month"
                        placeholder="选择月">
                </el-date-picker>
              </el-form-item>

              <el-form-item label="招聘人数:">
                <el-input v-model="job_info.jNumber"></el-input>
              </el-form-item>

              <el-form-item label="工 资:">
                 <el-input v-model="job_info.jSalaryMin" :disabled="isDisabled" style="width:200px"></el-input>
                  ~
                  <el-input v-model="job_info.jSalaryMax" :disabled="isDisabled" style="width:200px"></el-input>
              </el-form-item>

              <el-form-item label="职位类型:">
               <el-select v-model="job_info.jType" :disabled="isDisabled" filterable placeholder="请选择">
            <el-option
                    v-for="item in type"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
            </el-option>
          </el-select>
              </el-form-item>

              <el-form-item label="要求学历:">
                <el-select v-model="job_info.jEducation" value="">
                 <el-option :value="1" label="不限"></el-option>
                <el-option :value="2" label="大专"></el-option>
                <el-option :value="3" label="本科"></el-option>
                <el-option :value="4" label="硕士"></el-option>
                <el-option :value="5" label="博士"></el-option>
                </el-select>
              </el-form-item>

              <el-form-item label="工作经验:">
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
                        show-word-limit>
                </el-input>
              </el-form-item>

              <el-form-item label="招聘员工要求:">
                <el-input
                        type="textarea"
                        placeholder="请输入内容"
                        v-model="job_info.jRequire"
                        rows="3"
                        maxlength="200"
                        show-word-limit>
                </el-input>
              </el-form-item>

              <el-form-item label="职位待遇:">
                <el-input
                        type="textarea"
                        placeholder="请输入内容"
                        v-model="job_info.jTreatment"
                        rows="3"
                        maxlength="200"
                        show-word-limit>
                </el-input>
              </el-form-item>
              <el-button type="primary" size="middle" @click="saveJobModify">保存修改</el-button>
            </el-form>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  import {getJobInfoByCId,deleteJobInfo,getJobInfoByJId,modifyJobInfo} from "network/job";
  import {getUserCompanyInfo} from "network/company";
  export default {
    name: "Launched",
    data(){
      return{
        job:[],
        job_info: {
          id: '',
          CId: '',
          jName: '',
          jStime: '',
          jEtime: '',
          jNumber: '',
          jType: '',
          jSalaryMin: '',
          jSalaryMax: '',
          jTreatment: '',
          jRequire: '',
          jResume: '',
          jEducation: '',
          jExperience: ''
        },
        company: [],
        type: [
                { value: 1, label: '互联网' },
                { value: 2, label: '电子商务' },
                { value: 3, label: '医疗' },
                { value: 4, label: '金融' },
                { value: 5, label: '运营' }]
      }
    },
    created(){
      if (this.$cookies.get('userInfo')){
         getUserCompanyInfo().then(res => {
          this.company = res.result

          getJobInfoByCId(this.company.id).then(res => {
            this.job=res.result;
          })
        })
      }
    },
    methods: {
      deleteRow(rows){
        deleteJobInfo(rows.jId).then(res => {
          this.$message.success({
            message: '删除成功'
          })
          getJobInfoByCId(this.company.id).then(res => {
            this.job=res.result;
          })
        })
      },
      modifyJobInfo(rows){
        getJobInfoByJId(rows.jId).then(res => {
          this.job_info = res.result
        })
        let $table = this.$refs.table;
        $table.toggleRowExpansion(rows)
      },
      saveJobModify(){
        modifyJobInfo(this.job_info).then(res => {
          this.$message.success({
            message: '保存修改成功'
          })
          getJobInfoByCId(this.company.id).then(res => {
            this.job=res.result;
          })
        })
      }
    }
  }
</script>

<style scoped>
  .a-tr td{
    line-height: 35px;
  }

  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>