<template>
  <div class="upload-container">
    <el-upload
      v-show="!imageUrl"
      :headers="actionHeaders"
      :multiple="false"
      :show-file-list="false"
      :on-success="handleImageSuccess"
      :on-error="handleError"
      class="image-uploader"
      drag
      :action="actionUrl"
    >
      <i class="el-icon-upload" />
      <div class="el-upload__text">
        将文件拖到此处，或<em>点击上传</em>
      </div>
    </el-upload>
    <div v-show="imageUrl" class="image-preview image-app-preview">
      <div class="image-preview-wrapper">
        <el-image :src="imageUrl" style="width: 100px; height: 100px" />
        <div class="image-preview-action" v-show="!disabled">
          <i class="el-icon-delete" @click="rmImage" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'UploadImage',
  props: {
    value: {
      type: String,
      default: ''
    },
    path: {
      type: String,
      default: ''
    },
    disabled: {
       type: Boolean,
      default: false
    }
  },
  data() {
    return {
      tempUrl: '',
      actionUrl: ''
    }
  },
  computed: {
    imageUrl() {
      return this.value
    },
    actionHeaders: {
      get() {
        return { 'X-Recuritment-Token' : this.$cookies.get('userToken') }
      }
    }
  },
  created() {
    this.actionUrl = this.path
  },
  methods: {
    rmImage() {
      this.emitInput('')
    },
    emitInput(val) {
      this.$emit('input', val)
    
    },
    handleImageSuccess(response) {
      this.emitInput(response.result)
    },
    beforeUpload() {
    },
    handleError(error) {
      this.$message({
        type: 'error',
        message: error.status === 403 ? '你没有上传权限' : '上传失败'
      })
    },
    download() {
      const link = document.createElement('a')
      link.href = this.imageUrl
      link.click()
    }
  }
}
</script>
