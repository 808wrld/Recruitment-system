<template>
  <div class="job-page">
    <!--导航栏-->
    <job-tab-bar/>

    <div class="middle">
      <div class="input-box">
        <div class="job-input">
          <el-input placeholder="请输入内容" v-model="keyword" class="input-with-select">
            <el-button slot="append" icon="el-icon-search" @click="search"></el-button>
          </el-input>
        </div>
        <div class="hot-type">
          <!--按热门城市查找-->
         热门城市：
          <!--<el-button type="text" v-for="item in cities">{{ item }} </el-button>-->
          <el-select v-model="cityType" filterable placeholder="请选择">
            <el-option
                    v-for="item in cities"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
            </el-option>
          </el-select>
          <!-- <el-button type="primary" @click="search_by_city">查询</el-button> -->
          <!--按工作类型查找-->
          工作类型：
          <!--<el-button type="text" v-for="item in type">{{ item }} </el-button>-->
          <el-select v-model="jobType" filterable placeholder="请选择">
            <el-option
                    v-for="item in type"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
            </el-option>
          </el-select>
          <el-button type="primary" @click="search">查询</el-button>
        </div>
      </div>

      <div class="display">
        <!--工作展示-->
        <div class="job-display">
          <div class="one-site" v-for="(item,index) in job" :key="index">
            <div class="job-info" @click="itemClick(index)">
              <div class="left">
                <a class="job-name">{{ item.jName }} [{{ item.cAddress }}]</a>
                <div class="info">
                  <p class="job-salary">{{ item.jSalary }}</p>
                  <p class="e">{{ item.jExperience }} | {{ item.jEducation }}</p></div>
              </div>
              <div class="right">
                <div class="c-name">{{ item.cName }}</div>
                <div class="c-info">{{ item.jType }} | {{ item.jNumber }}人</div>
              </div>
            </div>
          </div>
        </div>
      </div>


    </div>

    <!--尾部-->
    <nav-bar/>
  </div>
</template>

<script>
  import {getJobData} from "network/job";

  import JobTabBar from "./childComps/JobTabBar";
  import NavBar from "components/navbar/NavBar";

  export default {
    name: "JobPage",
    components: { NavBar, JobTabBar},
    created(){
      this.fetch()
    },
    data(){
      return{
        keyword: '',
        cities: [{ value: '', label: '不限' },
                 { value: '1', label: '北京' },
                 { value: '2', label: '天津' },
                 { value: '3', label: '成都' },
                 { value: '4', label: '广州' },
                 { value: '5', label: '南京' },
                 { value: '6', label: '深圳' },
                 { value: '7', label: '西安' },
                 { value: '8', label: '武汉' },
                 { value: '9', label: '上海' }],
        cityType: '',
        type: [ { value: '', label: '不限' },
                { value: '1', label: '互联网' },
                { value: '2', label: '电子商务' },
                { value: '3', label: '医疗' },
                { value: '4', label: '金融' },
                { value: '5', label: '运营' }],
        jobType: '',

        job:[]
      }
    },
    methods: {
      search(){
        getJobData({jobType :this.jobType, cityType : this.cityType, keyword : this.keyword }).then(res => {
          this.job = res.result
          if (!this.job){
            this.$notify({
              message: '抱歉，暂职位信息',type: 'warning'
            })
          }
        })
      },
      itemClick(index){
        this.$router.push({path: '/job_detail',query:{ jId:this.job[index].jId }})
      }
    }
  }
</script>

<style scoped>
  @import "~assets/css/tabbar/tabbar.css";

  .middle{

    padding-top: 80px;
    background-color: #f4f4f4;
  }
  .input-box{
    width: 800px;
    margin: 0 auto;
    padding-top: 20px;
    /*background-color: white;*/
  }
  .job-input{
    margin: 0 auto;
    width: 600px;
  }
  .hot-type{
    margin-top: 10px;
    padding-bottom: 10px;
    text-align: center;
  }

  .el-button--primary{
    margin-left: 10px;
    margin-right: 10px;
  }

  .display{
    padding-bottom: 20px;
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
  .c-name{
    font-size: 18px;
    margin-bottom: 10px;
    color: #4c6788;
  }
</style>