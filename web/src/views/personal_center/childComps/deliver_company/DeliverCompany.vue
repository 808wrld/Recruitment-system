<template>
  <el-table
          :data="company"
          stripe
          height="490"
          border
          style="width: 100%">
    <el-table-column
            prop="jName"
            label="职位名称"
            width="170">
    </el-table-column>
    <el-table-column
            prop="jType"
            label="职位类型"
            width="100">
    </el-table-column>
    <el-table-column
            prop="jSalary"
            label="工资"
            width="100">
    </el-table-column>
    <el-table-column
            prop="jExperience"
            label="工作经验"
            width="100">
    </el-table-column>
    <el-table-column
            prop="jNumber"
            label="招聘人数"
            width="100">
    </el-table-column>
    <el-table-column
            prop="cName"
            label="公司名"
            width="100">
    </el-table-column>
    <el-table-column
            prop="cAddress"
            label="地址"
            width="100">
    </el-table-column>
    <el-table-column
            prop="stateValue"
            label="状态"
            width="100">
    </el-table-column>
  </el-table>
</template>

<script>
  import {getResumeAndCompanyInfo} from "network/resume";

  export default
  {
    name: "DeliverCompany",
    data(){
      return {
        company: [],
        user: []
      }
    },
    created(){
      if (this.$cookies.get('userInfo')){
        this.user = this.$cookies.get('userInfo')
      }
      getResumeAndCompanyInfo().then(res => {
        this.company = res.result
      })
    },
    methods: {
      fetch(){

      }
    }
  }
</script>

<style scoped>
  .active{
    display: none;
  }
</style>