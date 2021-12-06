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
    <el-form label-position="left" ref="sizeForm" class="demo-table-expand">
              <el-form-item label="投诉:">
                <el-input  type="textarea" v-model="complain.complain" />
              </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button
        type="success"
        plain
        @click.native.prevent="save('sizeForm')"
      >提交</el-button>
    </div>
  </el-dialog>
</template>
<script>
  import {addComplain} from "network/users";
import Upload from 'components/upload/UploadCImage.vue';
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
        complain: {},
         uploadPath:'http://127.0.0.1:9999/recruiment-website-system/upload'
      }
    },
  created() {
    // test
  },
  // 页面渲染完成
  mounted() {
    if(this.modalObj && this.modalObj.cId) {
      this.complain.cId = this.modalObj.cId
    }
  },
  methods: {
    // 关闭弹出框
    modalClose() {
      this.$emit('update:visible', false) // 直接修改父组件的属性
    },
    // 保存
    save(formName) {
        addComplain(this.complain).then(response => {
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
