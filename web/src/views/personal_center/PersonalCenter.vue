<template>
  <div class="personal container">
    <tab-bar/>

    <div class="p-content">
      <div class="p-left">
        <ul class="nav nav-pills nav-stacked">
          <li role="presentation" class="li-bar" :class="{active: pIsShow}"><a @click="pClick">个人信息</a></li>
          <li role="presentation" class="li-bar" :class="{active: cIsShow}"><a @click="cClick">已投递职位</a></li>
          <li role="presentation" class="li-bar" :class="{active: fIsShow}"><a @click="fClick">我的文档</a></li>
        </ul>
      </div>

      <div class="p-right">
        <p-form v-if="pIsShow"/>
        <deliver-company v-if="cIsShow"/>
        <user-file v-if="fIsShow"/>
      </div>
    </div>

    <nav-bar/>
  </div>

</template>

<script>
  import NavBar from "components/navbar/NavBar";
  import TabBar from "components/tabbar/TabBar";
  import PForm from "./childComps/p-form/pForm";
  import DeliverCompany from "./childComps/deliver_company/DeliverCompany";
  import UserFile from "./childComps/UserFile";

  export default {
    name: "PersonalCenter",
    data(){
      return{
        pIsShow: true,
        fIsShow: false,
        cIsShow: false,
      }
    },
    components: {
      DeliverCompany,
      PForm,
      UserFile,
      TabBar,
      NavBar
    },
    methods:{
      pClick(){
        this.fIsShow = false
        this.pIsShow = true
        this.cIsShow = false
      },
      cClick(){
        this.pIsShow = false
        this.fIsShow = false
        this.cIsShow = true
      },
      fClick(){
        this.pIsShow = false
        this.fIsShow = true
        this.cIsShow = false
      }
    }
  }
</script>

<style scoped>
  .p-left{
    width: 200px;
    margin-top: 10%;
  }

  .p-right{
    margin-top: 10%;
    margin-left: 5%;
  }

  .li-bar a{
    border: 1px solid #777777;
    color: black;
    cursor: pointer;
  }

  .nav-pills > li.active > a,
  .nav-pills > li.active > a:hover,
  .nav-pills > li.active > a:focus{
    background-color: #222222;
  }

  .p-content{
    display: flex;
  }

</style>