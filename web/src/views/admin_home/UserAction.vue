<template>
  <div>
    <el-form>
      <el-form-item>
        <el-button
          type="primary"
          size="mini"
          icon="el-icon-circle-plus-outline"
          @click="addUser(2)"
        >添加</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="users">
      <el-table-column prop="id" label="用户编号" width="80"></el-table-column>
      <el-table-column prop="username" label="账号" width="200"></el-table-column>
      <el-table-column prop="realName" label="真实姓名" width="100"></el-table-column>
      <el-table-column prop="sex" label="性别" width="80"></el-table-column>
      <el-table-column prop="age" label="年龄" width="80"></el-table-column>
      <el-table-column prop="education" label="学历" width="100"></el-table-column>
      <el-table-column prop="mobile" label="联系方式" width="140"></el-table-column>

      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="deleteRow(scope.row)">强制注销</el-button>
        </template>
      </el-table-column>
    </el-table>
     <AddUserDialog v-if="visible" :visible.sync="visible" :modal-obj="modalObj" />
  </div>
</template>

<script>
  import {getUserByJober, deleteUser} from "network/users";
  import AddUserDialog from './AddUserDialog'

  export default {
    name: "UserAction",
    components: { AddUserDialog },
    data() {
      return {
        visible: false,
        users: []
      }
    },
    created(){
      getUserByJober().then(res => {
        this.users = res.result
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
          getUserByJober().then(res => {
            this.users = res.result
          })
        })
      }
    }
  }
</script>

<style scoped>

</style>