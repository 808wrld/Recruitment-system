<template>
    <div>
        <el-form>
      <el-form-item>
        <el-button
          type="primary"
          size="mini"
          icon="el-icon-circle-plus-outline"
          @click="addFile"
        >上传</el-button>
      </el-form-item>
    </el-form>
    <el-table
          :data="userFiles"
          stripe
          height="490"
          border
          style="width: 100%">
          <el-table-column
            prop="type"
            label="类型"
            width="250">
    </el-table-column>
    <el-table-column
            prop="remark"
            label="备注"
            width="250">
    </el-table-column>
    <el-table-column
            prop="gmtCreate"
            label="添加时间"
            width="250">
    </el-table-column>
    <el-table-column fixed="right" width="200" label="操作">
          <template slot-scope="scope">
            <el-button
                    size="mini"
                    type="primary"
                    @click="download(scope.row)">下载文件</el-button>
            <el-button
                    size="mini"
                    type="danger"
                    @click="deleteRow(scope.row)">删 除</el-button>
          </template>
        </el-table-column>
  </el-table>
       <AddFileDialog v-if="visible" :visible.sync="visible" :success.sync="updateList" :modal-obj="modalObj" />
    </div>
  
</template>

<script>
  import {getUserFile, deleteUserFile} from "network/users";
  import AddFileDialog from './AddFileDialog';
  export default
  {
    name: "UserFile",
    components: {AddFileDialog},
    data(){
      return {
          visible: false,
          updateList: false,
          userFiles: [],
          user: []
      }
    },
    watch: {
        updateList(val) {
            if(val) {
                getUserFile().then(res => {
                    this.userFiles = res.result
                 })
                this.val = false
            } 
        }
    },
    created(){
      if (this.$cookies.get('userInfo')){
        this.user = this.$cookies.get('userInfo')
      }
      getUserFile().then(res => {
        this.userFiles = res.result
      })
    },
    methods: {
      addFile() {
             const _this = this
            _this.visible = true // 指定弹出框显示
            _this.modalObj = { title: '上传文档', modal: true, width: '800px'} // 弹窗需要嵌套时，modal: false；不需要则为true。
       },
      deleteRow(row){
            deleteUserFile(row.id).then(response => {
            this.$message.success({
                message: '操作成功'
            })
             getUserFile().then(res => {
                this.userFiles = res.result
            })
        })
      },
      download({fileUrl}) {
            const link = document.createElement('a')
            link.href = fileUrl
            link.click()
      }
    }
  }
</script>

<style scoped>
  .active{
    display: none;
  }
</style>