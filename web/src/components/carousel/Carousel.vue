<template>
  <!-- Carousel   轮播图
    ================================================== -->
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li v-for="carousel in carousels" data-target="#myCarousel"  :data-slide-to="carousel.sort" v-bind:class="{ active: carousel.active }"></li>
      <!-- <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li> -->
    </ol>
    <!--图片和文字部分-->
    <div class="carousel-inner" role="listbox">
      <div class="item" v-for="carousel in carousels" v-bind:class="{ active: carousel.active }"> 
        <!--轮播图图片-->
        <img class="first-slide" :src="carousel.pic">
        <!--轮播图文字-->
        <div class="container">
          <div class="carousel-caption">
            <h1>{{carousel.title}}</h1>
            <!--<code>file://</code>--><br>
            <p>{{carousel.description}}</p>
          </div>
        </div>
      </div>
      <!-- <div class="item">
        <img class="second-slide" src="~assets/img/carousel/Carousel_photo1.jpg" alt="Second slide">
        <div class="container">
          <div class="carousel-caption">
            <h1>第八届京津冀招才引智大会</h1><br>
            <p>“京津冀招才引智大会”是助力人才强冀工程深入实施，服务和促进京津冀人才协同发展的重要引才平台，是2020年省委人才工作要点，省政府年度工作任务确定的重点人才工作项目。</p>
          </div>
        </div>
      </div>
      <div class="item">
        <img class="third-slide" src="~assets/img/carousel/Carousel_photo3.jpg" alt="Third slide">
        <div class="container">
          <div class="carousel-caption">
            <h1>2020届高校毕业生全国网络联合招聘</h1><br>
            <p>上线视频面试，避免疫情感染，随时随地在线沟通，语音视频面试更安全<br>
              随时随地可面试，在哪都能聊工作。远程面试防止疫情感染</p>
          </div>
        </div>
      </div> -->
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div><!-- /.carousel -->
</template>


<script>
  import { getCarousel } from 'network/home' 

  export default {
    name: "Carousel",
    data() {
      return{
         carousels : []
      }
    },
    created() {
       getCarousel().then(res => {
        this.carousels = res.result
      })

    },
    methods: {

    }
  }
</script>

<style scoped>
  @import "~assets/css/tabbar/tabbar.css";
</style>