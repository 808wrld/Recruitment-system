<template>
  <el-dialog
    :visible.sync="visible"
    :title="modalObj.title"
    :width="modalObj.width"
    :modal="modalObj.modal"
    :before-close="modalClose"
    :close-on-click-modal="false"
    :close-on-press-escape="true"
    append-to-body
  >
    <el-form label-position="left" ref="sizeForm" :size-form="file" class="demo-table-expand">
              <el-form-item label="文件类型:">
                 <el-select v-model="file.type">
                          <el-option label="四联单" value="四联单"></el-option>
                          <el-option label="实习周记" value="实习周记"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="备注:">
                <el-input type="textline" v-model="file.remark" />
              </el-form-item>
              <el-form-item label="图片">
                  <Upload v-model="file.fileUrl" :path="uploadPath" />
              </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button
        type="success"
        plain
        @click.native.prevent="save('sizeForm')"
      >保存</el-button>
    </div>
  </el-dialog>
</template>
<script>

  import {addUserFile} from "network/users";
import Upload from 'components/upload/UploadImage.vue';
export default {
  name: 'AddCarouselDialog',
  components: {Upload}, 
  props: {
    visible: {
      type: Boolean,
      default: false
    },
    modalObj: {
      type: Object,
      default: null
    }
  },
  data(){
      return{
        file: {},
         uploadPath:'http://127.0.0.1:9999/recruiment-website-system/upload'
      }
    },
  created() {
    // test
  },
  // 页面渲染完成
  mounted() {
  },
  methods: {
    // 关闭弹出框
    modalClose() {
      this.$emit('update:visible', false) // 直接修改父组件的属性
    },
    // 保存
    save(formName) {
        addUserFile(this.file).then(response => {
            this.$message.success({
              message: response.code === 0 ? '操作成功' : response.msg,
            })
            if (response.code === 0) {
                 this.$emit('update:success', true)
                this.modalClose()
            } else {
                 this.$emit('update:success', false)
            }
          })
    }
  }
}
</script>
