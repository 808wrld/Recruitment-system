<template>
  <div>
    <el-table :data="complains" stripe ref="table">
      <el-table-column prop="id" label="编号" width="120"></el-table-column>
      <el-table-column prop="uName" label="投诉人" width="180"></el-table-column>
      <el-table-column prop="cName" width="180" label="投诉企业"></el-table-column>
      <el-table-column prop="gmtCreate" width="180" label="投诉时间"></el-table-column>
      <el-table-column prop="complain" label="投诉内容"></el-table-column>
      <el-table-column fixed="right" width="160">
          <template slot-scope="scope">
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
  import {getComplain, deleteComplain} from "network/users";
  export default {
    name: "JobAction",
    data(){
      return{
        visible: false,
        complains: [],
      }
    },
    created(){
       getComplain().then(res => {
        this.complains = res.result
      })
    },
    methods:{
     
      deleteRow(rows) {
        deleteComplain(rows.id).then(res => {
          this.$message.success({
            message: '删除成功'
          })
          getComplain().then(res => {
                this.complains = res.result
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