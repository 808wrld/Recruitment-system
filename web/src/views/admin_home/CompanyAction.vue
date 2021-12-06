<template>
  <div>
    <el-form>
      <el-form-item>
        <el-button
          type="primary"
          size="mini"
          icon="el-icon-circle-plus-outline"
          @click="addUser(3)"
        >添加</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="company">
      <el-table-column prop="id" label="企业编号" width="100"></el-table-column>
      <el-table-column prop="username" label="账号" width="200"></el-table-column>
      <el-table-column prop="cName" label="企业名称" width="160"></el-table-column>
      <el-table-column prop="cAddress" label="地址" width="120"></el-table-column>
      <el-table-column prop="cType" label="企业类型" width="100"></el-table-column>
      <el-table-column prop="cContact" label="联系方式" width="160"></el-table-column>

      <el-table-column fixed="right" label="操作" width="120">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="deleteRow(scope.row)">强制注销</el-button>
        </template>
      </el-table-column>
    </el-table>
    <AddUserDialog v-if="visible" :visible.sync="visible" :modal-obj="modalObj" />
  </div>
</template>

<script>
  import {getUserByCompanyManager, deleteUser} from "network/users";
  import AddUserDialog from './AddUserDialog'

  export default {
    name: "CompanyAction",
    components:{ AddUserDialog},
    data(){
      return{
        visible: false,
        company: [],
        resume: []
      }
    },
    created(){
      getUserByCompanyManager().then(res => {
        this.company = res.result
      })
    },
    methods: {
      // 用户
      addUser(roleId) {
        const _this = this
        _this.visible = true // 指定弹出框显示
        _this.modalObj = { title: '添加用户', modal: true, width: '800px', roleId} // 弹窗需要嵌套时，modal: false；不需要则为true。
      },
      deleteRow(rows){
        deleteUser(rows.id).then(res => {
          this.$message.success({
            message: '删除成功'
          })
          getCompanyManager().then(res => {
            this.company = res.result
          })
        })
      }
    }
  }
</script>

<style scoped>

</style>