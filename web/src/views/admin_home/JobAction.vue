<template>
  <div>
    <el-table :data="job" stripe>
      <el-table-column prop="jId" label="职位编号" width="120"></el-table-column>
      <el-table-column prop="jName" label="职位名称" width="180"></el-table-column>
      <el-table-column prop="cName" label="所属企业" width="120"></el-table-column>
      <el-table-column prop="jSalary" label="工资" width="120"></el-table-column>
      <el-table-column prop="jType" label="职位类型" width="120"></el-table-column>
      <el-table-column prop="jExperience" label="所需经验" width="120"></el-table-column>
      <el-table-column prop="jEducation" label="学历" width="120"></el-table-column>
      <el-table-column prop="jNumber" label="所需人数" width="120"></el-table-column>

      <el-table-column fixed="right" width="160">
        <template slot="header" slot-scope="scope">
          <el-input
                  v-model="search_job"
                  size="mini"
                  placeholder="输入关键字搜索">
            <el-button icon="el-icon-search" slot="append" @click="searchJob"></el-button>
          </el-input>
        </template>
        <template slot-scope="scope">
          <!--<el-button type="text" size="small" @click.native.prevent="deleteJob">删除</el-button>-->
          <el-button
                  size="mini"
                  type="danger"
                  @click="deleteRow(scope.row)">删 除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
  import {getJobData,deleteJobInfo} from "network/job";

  export default {
    name: "JobAction",
    data(){
      return{
        job: [],
        search_job: ''
      }
    },
    created(){
      getJobData().then(res => {
        this.job = res.result
      })
    },
    methods:{
      searchJob(){
        getJobData({keyword : this.search_job}).then(res => {
          this.job = res.result
          if (this.job.length === 0){
            this.$notify({
              message: '抱歉，暂无含有此关键字的职位信息',type: 'warning'
            })
          }
        })
      },
      deleteRow(rows) {
        deleteJobInfo(rows.jId).then(res => {
          this.$message.success({
            message: '删除成功'
          })
          getJobData({keyword : this.search_job}).then(res => {
            this.job = res.result
          if (this.job.length === 0){
            this.$notify({
              message: '抱歉，暂无含有此关键字的职位信息',type: 'warning'
            })
          }
        })
        })
      }
    }
  }
</script>

<style scoped>

</style>