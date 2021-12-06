<template>
  <div class="company-detail">
    <detail-tab-bar></detail-tab-bar>

    <div class="content">
      <div class="top">
        <div class="top-content">
          <div class="title">
            <img class="logo" :src="companyInfo.cLogo">
            <span class="c_name">{{ companyInfo.cName }}</span>
          </div>
          <div class="intro">{{ companyInfo.cAddress }}</div>
           <div class="btn1">
          <el-button  type="primary" plain class="sendBtn" @click="addComplain">投诉</el-button>
        </div>
        <div class="describe"><span>{{ companyInfo.cDescribe }}</span></div>
        </div>
      </div>
      <div class="down">
        <div v-if="isExist">
          <div class="r-now">在招职位</div>
          <div class="display">
            <!--工作展示-->
            <div class="job-display">
              <div class="one-site" v-for="(item,index) in jobInfo" :key="index">
                <div class="job-info" @click="itemClick(index)">
                  <div class="left">
                    <a class="job-name">{{ item.jName }}</a>
                    <div class="info">
                      <p class="job-salary">{{ item.jSalary }}</p>
                      <p class="e">{{ item.jExperience }} | {{ item.jEducation }}</p></div>
                  </div>
                  <div class="right">
                    <div class="c-info">{{ item.jType }} | {{ item.jNumber }}人</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div v-if="!isExist">
          <div class="none">此公司暂无在招职位</div>
        </div>
      </div>
    </div>
    <UserComplainDialog v-if="visible" :visible.sync="visible" :modal-obj="modalObj" />
  </div>
</template>

<script>
  import DetailTabBar from './childComps/DetailTabBar'
  import NavBar from "../../components/navbar/NavBar";
  import UserComplainDialog from './childComps/AddComplainDialog.vue';
  import {getCompanyById} from "network/company";
  import {getJobInfoByCId} from "network/job";

  export default {
    name: "CompanyDetail",
    components: {
      DetailTabBar,
      UserComplainDialog,
      NavBar
    },
    data(){
      return {
        id: null,
        companyInfo: {},
        jobInfo: [],
        isExist: false,
        visible: false
      }
    },
    created(){
      this.id = this.$route.query.id
      getCompanyById(this.id).then(res => {
        this.companyInfo = res.result
      })
      getJobInfoByCId(this.id).then(res => {
        this.jobInfo = res.result
        if(this.jobInfo.length > 0) {
           this.isExist = true
        }
      })
    },
    methods: {
      itemClick(index){
        this.$router.push({path: '/job_detail',query:{ jId:this.jobInfo[index].jId }})
      },
      addComplain() {
        const _this = this
        _this.visible = true // 指定弹出框显示
        _this.modalObj = { title: '我要投诉', modal: true, width: '800px', cId: this.$route.query.id } // 弹窗需要嵌套时，modal: false；不需要则为true。
      }
    }
  }
</script>

<style scoped>
  .nav-bar{
    position: absolute;
    bottom: 46px;
  }
  .content{
    margin-top: 52px;
  }
  .top{
    background-color: #2e3740;
    width: 100%;
    height: 150px;
  }
  .top-content{
    color: white;
    margin: 0 180px;
  }
  .logo{
    width: 70px;
    height: 70px;
    margin-top: 40px;
    margin-right: 25px;
  }
  .title{
    font-size: 30px;
    /*padding-top: 30px;*/
  }
  .c_name{
    padding-top: 10px;
  }
  .intro{
    margin-top: -20px;
    margin-left: 95px;
  }
  .describe{
    top: 143px;
    left: 400px;
    color: #fff;
  }
  .btn1{
    position: absolute;
    right: 180px;
    top: 100px;
  }
  .job-display{
    position: relative;
    margin: 0 auto;
    margin-top: 20px;
    /*background-color: white;*/
    width: 800px;
  }
  .one-site{
    background-color: white;
    margin-top: 10px;
    box-shadow: 0 0 5px #dfdfdf;
  }
  .one-site:hover{
    box-shadow: 3px 3px 5px #dfdfdf;
  }
  .job-info{
    /*上，右，下，左*/
    padding: 20px 10px 8px 20px;
    cursor: pointer;
    display: flex;
  }
  .job-name{
    font-size: 18px;
    text-decoration: none;
    /*color: #4a4b4b;*/
  }
  .info{
    display: flex;
    margin-top: 5px;
  }
  .job-salary{
    margin-right: 5px;
    font-size: 18px;
    color: #ff4519;
  }
  .e{
    font-size: 15px;
    margin-top: 2px;
  }
  .right{
    position: absolute;
    left: 650px;
  }

  .r-now{
    margin-top: 15px;
    margin-left: 47%;
    font-size: 26px;
    font-family: 方正粗黑宋简体;
  }
  .none{
    margin-top: 15px;
    margin-left: 40%;
    font-size: 26px;
    font-family: 方正粗黑宋简体;
  }
</style>