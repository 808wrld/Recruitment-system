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
  import {addCarousel} from "network/home";
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
        carousel: {},
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
        addCarousel(this.carousel).then(response => {
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
