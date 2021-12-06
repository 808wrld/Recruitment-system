<template>
  <div>
    <el-form>
      <el-form-item>
        <el-button
          type="primary"
          size="mini"
          icon="el-icon-circle-plus-outline"
          @click="addNotice()"
        >添加</el-button>
      </el-form-item>
    </el-form>
    <el-table :data="carousels" stripe ref="table">
      <el-table-column prop="id" label="编号" width="120"></el-table-column>
      <el-table-column prop="title" label="标题" width="180"></el-table-column>
      <el-table-column prop="description" label="内容"></el-table-column>
      <el-table-column prop="sort" label="顺序" width="120"></el-table-column>
      <el-table-column label="图片" width="120">
           <template slot-scope="scope">
               <el-image :src="scope.row.pic" style="width:200px, height:200px"/>
           </template>
      </el-table-column>
      <el-table-column fixed="right" width="160">
          <template slot-scope="scope">
            <el-button type="primary" size="small" @click="modify(scope.row)">修改</el-button>
            <el-button
                    size="mini"
                    type="danger"
                    @click="deleteRow(scope.row)">删 除</el-button>
          </template>
        </el-table-column>
       <el-table-column type="expand">
          <template slot-scope="props">
               <el-form ref="job_info" :model="carousel"  class="demo-table-expand">
               </el-form>
            <h4>修改轮播</h4>
            <el-form label-position="left" class="demo-table-expand">
              <el-form-item label="标题:">
                <el-input v-model="carousel.title"></el-input>
              </el-form-item>
              <el-form-item label="内容:">
                <el-input type="textline" v-model="carousel.description" />
              </el-form-item>
              <el-form-item label="顺序:">
                <el-input type="textline" v-model="carousel.sort"></el-input>
              </el-form-item>
              <el-form-item label="图片">
                  <Upload v-model="carousel.pic" :path="uploadPath" />
              </el-form-item>
               <el-button type="primary" size="middle" @click="saveModify">保存修改</el-button>
            </el-form>
          </template>
        </el-table-column>
    </el-table>
    <AddNoticeDialog v-if="visible" :visible.sync="visible" :success.sync="updateList" :modal-obj="modalObj" />
  </div>
</template>

<script>
  import AddNoticeDialog from './AddNoticeDialog'
  import {getCarousel, updateCarousel, deleteCarousel} from "network/home";
  import Upload from 'components/upload/UploadCImage.vue';
  export default {
    name: "JobAction",
    components: {Upload, AddNoticeDialog},
    data(){
      return{
        visible: false,
        updateList: false,
        carousel: {},
        carousels: [],
        uploadPath:'http://127.0.0.1:9999/recruiment-website-system/upload',
      }
    },
    watch: {
        updateList(val) {
            if(val) {
                 getCarousel().then(res => {
                    this.carousels = res.result
                })
                this.updateList = false
            } 
        }
    },
    created(){
       getCarousel().then(res => {
        this.carousels = res.result
      })
    },
    methods:{
          // 添加公告
      addNotice() {
        const _this = this
        _this.visible = true // 指定弹出框显示
        _this.modalObj = { title: '添加公告', modal: true, width: '800px'} // 弹窗需要嵌套时，modal: false；不需要则为true。
      },
      modify(rows){
        this.carousel = rows;
        let $table = this.$refs.table;
        $table.toggleRowExpansion(rows)
      },
      saveModify() {
          updateCarousel(this.carousel).then(response => {
              this.$message.success({
                  message: '操作成功'
              })
               getCarousel().then(res => {
                    this.carousels = res.result
               })
          })
      },
      deleteRow(rows) {
        deleteCarousel(rows.id).then(res => {
          this.$message.success({
            message: '删除成功'
          })
          getCarousel().then(res => {
                this.carousels = res.result
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