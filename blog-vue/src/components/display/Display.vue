<!-- <template>
  <el-container class="container">
    <el-header>
      <el-menu router :default-active="this.$route.path" class="el-menu-demo" mode="horizontal" @select="handleSelect">
        <el-menu-item :index="'/'" class="menu-item">首页</el-menu-item>
        <el-menu-item :index="'/archive'">归档</el-menu-item>
        <el-menu-item :index="'/displayCategory'">分类</el-menu-item>
        <el-menu-item :index="'/displayTag'">标签</el-menu-item>
        <el-menu-item :index="'/about'">关于</el-menu-item>
        <el-button v-if="this.$store.state.user == '{}' || this.$store.state.user == '' || this.$store.state.user == undefined" @click="toLogin" style="margin-top: 13px;margin-right: -260px" size="medium" round plain type="primary">登录</el-button>
        <span @click="toHome" style="line-height: 60px;margin-right: -280px;color: #409eff;padding: 5px; border: solid 1.5px #409eff;border-radius: 7px; cursor: pointer" v-else>{{ JSON.parse(this.$store.state.user).nickname }}</span>
      </el-menu>
    </el-header>
    <el-main>
      <router-view v-if="this.$route.name == '博客首页'"></router-view>
      <el-row :gutter="20" v-else>
        <el-col :span="16" :offset="4">
          <el-card class="box-card">
            <router-view></router-view>
          </el-card>
        </el-col>
      </el-row>
      <el-footer>
        <div class="footer">© 2024 mby</div>
      </el-footer>
    </el-main>
  </el-container>
</template> -->

<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <el-menu router :default-active="this.$route.path" class="el-menu-demo" mode="horizontal"
          @select="handleSelect">
          <el-menu-item :index="'/'" class="menu-item">首页</el-menu-item>
          <el-menu-item :index="'/archive'">博客</el-menu-item>
          <el-menu-item :index="'/displayCategory'">分类</el-menu-item>
          <!-- <el-menu-item :index="'/displayTag'">标签</el-menu-item> -->
          <el-menu-item :index="'/about'">关于</el-menu-item>
          <el-button
          class="login"
            v-if="this.$store.state.user == '{}' || this.$store.state.user == '' || this.$store.state.user == undefined"
            @click="toLogin" style="margin-top: 13px;margin-right: -260px" size="medium" round plain
            type="primary">登录</el-button>
          <span @click="toHome"
            style="line-height: 60px;margin-right: -280px;color: black;  cursor: pointer"
            v-else>{{ JSON.parse(this.$store.state.user).nickname }}</span>
        </el-menu>
      </el-header>
      <el-container>
        <el-aside width="300px">
          <!-- <div class="dtag">
            <div class="tag-container" >
              <h2 class="header">标签</h2>
              <el-card class="box-card" >
                <el-tag @click="getArticleByTagId(item.id, item.tag)" class="tag" effect="plain" type="info"
                v-for="(item, index) in tag">{{ item.tag }}</el-tag>
                </el-card>
            </div>
          </div> -->
        <DisplayTag />
        </el-aside>
        <el-container>
          <el-main>
            <router-view v-if="this.$route.name == '博客首页'"></router-view>
            <el-row :gutter="20" v-else>
              <el-col :span="16" :offset="4">
                <el-card class="box-card">
                  <router-view></router-view>
                </el-card>
              </el-col>
            </el-row>
          </el-main>
          <el-footer>
            <div class="footer">© 2024 mby</div>
          </el-footer>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import DisplayTag from './DisplayTag.vue';




  export default {
    name: "Display",
    components:{
      DisplayTag
    },
    data() {
      return {
        activeIndex: '1',
      };
    },

    
    methods: {
      handleSelect(key, keyPath) {
        // console.log(key, keyPath);
      },
      toLogin() {
        this.$router.push({path: '/login'})
      },
      toHome() {
        this.$router.push({path: '/writeArticle'})
      },
    },
  }
</script>

<style scoped>
.login{
    color: black;
    background-color: white;
    border: 1px solid rgb(39, 38, 38);
   
  }
  .login:hover{
    color: white;
    background-color: black;
  }

  .el-row {
    margin-bottom: 20px;
  &:last-child {
     margin-bottom: 0;
   }
  }
  .el-col {
    border-radius: 4px;
  }

  .container {
    height: 100%;
    width: 100%;
    position: absolute;
    top: 0px;
    left: 0px;
  }

  .menu-item {
    margin-left: 250px;
  }

  .footer {
    line-height: 60px;
    font-size: 14px;
    color: #999;
  }

  .box-card {
    width: 100%;
    text-align: left;
  }

</style>
