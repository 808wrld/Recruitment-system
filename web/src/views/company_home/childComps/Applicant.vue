<template>
  <div>
    <h2 class="sub-header">Applicants</h2>
    <div class="table-responsive">
      <el-table stripe :data="users" style="width: 100%">
        <el-table-column type="expand">
          <template slot-scope="props">
            <h4>个人简介</h4>
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="姓名">
                <span>{{ props.row.realName }}</span>
              </el-form-item>
              <el-form-item label="毕业院校">
                <span>{{ props.row.graduateSchool }}</span>
              </el-form-item>
              <el-form-item label="毕业年份">
                <span>{{ props.row.graduateDate.substr(0, 10) }}</span>
              </el-form-item>
              <el-form-item label="联系方式">
                <span>{{ props.row.mobile }}</span>
              </el-form-item>
              <el-form-item label="下载简历">
                <el-button type="success" @click.prevent="download(props.row.curriculumVitae)">下载</el-button>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column label="编号" prop="id"></el-table-column>
        <el-table-column label="姓名" prop="realName"></el-table-column>
        <el-table-column label="性别" prop="sex"></el-table-column>
        <el-table-column label="年龄" prop="age"></el-table-column>
        <el-table-column label="学历" prop="education"></el-table-column>
        <el-table-column label="应聘职位" prop="jName"></el-table-column>
         <el-table-column label="状态" prop="stateValue"></el-table-column>
        <el-table-column label="操作" width="220px">
          <template slot-scope="scope">
            <el-button v-if="scope.row.state === 0" type="success" @click.native.prevent="passBtn(scope.$index, users)">通过</el-button>&nbsp;
            <el-button v-if="scope.row.state === 0" type="danger" @click.native.prevent="rejectBtn(scope.$index, users)">拒绝</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  import {updateStatePass, updateStateReject, getUserJob} from "network/resume";

  export default {
    name: "Applicant",
    data(){
      return{
        users:[],
        drawer: false,
        company: [],
      }
    },
    created(){
      if (this.$cookies.get('userInfo')){
           getUserJob().then(res => {
            this.users = res.result
          })
      }
    },
    methods: {
      passBtn(index,rows){
        updateStatePass(this.users[index].id).then(res => {
          this.$message.success({
            message : '操作成功'
          })
          getUserJob().then(res => {
            this.users = res.result
          })
        })
      },
      rejectBtn(index,rows){
        updateStateReject(this.users[index].id).then(res => {
            this.$message.success({
            message : '操作成功'
          })
          getUserJob().then(res => {
            this.users = res.result
          })
        })
      },

       download(imageUrl) {
        const link = document.createElement('a')
        link.href = imageUrl
        link.click()
      }
    }
  }
</script>

<style scoped>

  .a-tr td{
    line-height: 35px;
  }

  .el-button{
    padding: 0;
    width: 75px;
    height: 34px;
  }

  .el-button--primary{
    margin: 0 !important;
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