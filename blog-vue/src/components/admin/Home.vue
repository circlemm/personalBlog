<template>
  <el-container class="container" v-loading="loading">
    <el-header class="header">
      <span @click="toDisplay" class="title">首页</span>
      <el-dropdown @command="handleCommand" class="dropdown">
  <span class="el-dropdown-link dropdown-link">
    {{JSON.parse(this.$store.state.user).nickname}}<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="logout" class="logoutColor" style="background-color: white; ">退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </el-header>
    <el-container>
      <el-aside width="250px" class="aside">
        <el-row class="tac">
          <el-col>
            <el-menu
                router
                :default-active="$route.path"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose"
                background-color="whitesmoke"
                text-color="black"
                active-text-color="black">
              <el-submenu :index="'1'" :key="1">
                <template slot="title">
                  <i class="el-icon-document"></i>
                  <span>文章管理</span>
                </template>
                <el-menu-item :index="'/writeArticle'" :key="'writeArticle'">写文章</el-menu-item>
                <el-menu-item :index="'/articleList'" :key="'articleList'">文章列表</el-menu-item>
                <el-menu-item :index="'/tagCategoryAdmin'" :key="'tagCategoryAdmin'">标签分类管理</el-menu-item>
              </el-submenu>
              <el-submenu :index="'2'" :key="2">
                <template slot="title">
                  <i class="el-icon-setting"></i>
                  <span>系统设置</span>
                </template>
                <el-menu-item :index="'/updateInfo'">更新信息</el-menu-item>
              </el-submenu>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>
      <el-main>
        <el-breadcrumb separator-class="el-icon-arrow-right">
          <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item v-if="this.$route.name != 'Home'">{{this.$route.name}}</el-breadcrumb-item>
        </el-breadcrumb>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import axios from "axios";

  export default {
    name: "Home",
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      handleCommand(command) {
        if (command == 'logout') {
          this.loading = true;
          const token = JSON.parse(this.$store.state.user).token;
          axios.get('/user/logout/' + token).then(value => {
            this.loading = false;
            const data = value.data
            if (data.success) {
              this.$store.commit('logout');
              this.$router.push({path: '/'});
            } else {
              this.$message.error({message: '登出失败'});
            }
          })
        }
      },
      toDisplay() {
        this.$router.push({path: '/'})
      }
    },
    data() {
      return {
        loading: false,
      }
    }
  }
</script>

<style scoped>
  .container {
    height: 100%;
    width: 100%;
    position: absolute;
    top: 0px;
    left: 0px;
  }

  .header {
    background-color: #202021;
  }

  .aside {
    background-color: whitesmoke;
  }

  .el-dropdown-link {
    cursor: pointer;
    color: #2d3033;
  }

  .el-icon-arrow-down {
    font-size: 12px;
  }

  .title {
    float: left;
    margin-left: 20px;
    line-height: 60px;
    font-size: large;
    cursor: pointer;
    color: aliceblue;
  }

  .dropdown {
    float: right;
    line-height: 60px;
  }

  .dropdown-link {
    color: #f5f5f6;
  }
  .logoutColor:hover{
    color: black;
  }
</style>
