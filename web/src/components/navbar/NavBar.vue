<template>
  <footer class="nav-bar">
  </footer>
</template>

<script>
  export default {
    name: "NavBar",
    data(){
      return {
        qqisActive: false,
        wxisActive: false,
        wbisActive: false
      }
    },
    methods:{
      cqq(){
        this.qqisActive = true
      },
      cqqo(){
        this.qqisActive = false
      },
      cwx(){
        this.wxisActive = true
      },
      cwxo(){
        this.wxisActive = false
      },
      cwb(){
        this.wbisActive = true
      },
      cwbo(){
        this.wbisActive = false
      }
    }
  }
</script>

<style scoped>
  .nav-bar{
    display: flex;
    align-items: center;
    /*justify-content: space-around;*/
    /*flex-wrap: wrap;*/

    margin-top: 30px;
    margin-bottom: -40px;
    background-color: #efeeee;

    width: 100%;
    height: 79px;

    padding-left: 40%;
  }

  .con {
    width: 70px;
    height: 70px;
    display: flex;
    margin-top: -20px;
    justify-content: space-around;
    flex-wrap: wrap;
    align-items: center;
  }

  .con .box {
    display: flex;
    justify-content: space-around;
    flex-direction: column;
    align-items: center;
    align-content: center;
    width: 100px;
    /*height: 140px;*/
    margin: 20px;
  }

  .con .box .img {
    width: 50px;
    height: 50px;
    box-shadow: 10px 10px 15px rgba(0,0,0,0.1),
    -10px -10px 15px rgba(255,255,255,1);
    border-radius: 20px;
    display: flex;
    align-content: center;
    align-items: center;
    background-color: #efeeee;
    transition: box-shadow .2s ease-out;
    position: relative;
  }

  .con .box .img img {
    margin: 0 auto;
    width: 30px;
    transition: width .2s ease-out;
  }

  .con .box .img:hover {
    box-shadow: 0 0 0 rgba(0,0,0,0.1),
    0 0 0 rgba(255,255,255,1),
    inset 10px 10px 15px rgba(0,0,0,0.1),
    inset -10px -10px 15px rgba(255,255,255,1);
    transition: box-shadow .2s ease-out;
    cursor: pointer;
  }

  .con .box .img:hover img {
    width: 37px;
    transition: width .2s ease-out;
  }

  .code{
    width: 150px;
    height: 150px;
    display: none;
  }

  .active{
    display: block;
  }

  #c1{
    width: 150px;
    height: 150px;
    position: absolute;
    /*left: 570px;*/
    left: -50px;
    bottom: 55px;
    /*bottom: -175%;*/
  }
  #c2{
    width: 150px;
    height: 150px;
    position: absolute;
    left: -50px;
    bottom: 55px;
  }
  #c3{
    width: 150px;
    height: 150px;
    position: absolute;
    left: -50px;
    bottom: 55px;
  }

</style>