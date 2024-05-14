<template>
  <div class="block">
    <h2 class="header">分类</h2>
    <!-- <el-timeline>
      <el-timeline-item v-for="(item, index) in category" placement="bottom">
        <span class="category" @click="getArticleByCategory(item.id, item.category)">{{item.category}}</span>
      </el-timeline-item>
    </el-timeline> -->
    <el-row :gutter="20">
    <el-col :span="7" v-for="(item, index) in category">
      <div class="grid-content ep-bg-purple" style=" text-align: center; margin: 5px 8px; line-height: 35px;">
        <span class="category" @click="getArticleByCategory(item.id, item.category)">{{item.category}}</span>
      </div>
    </el-col>
    
  </el-row>
  </div>
</template>

<script>
  import axios from "axios";

  export default {
    name: "DisplayCategory",
    mounted() {
      this.getAllCategory();
    },
    methods: {
      getAllCategory() {
        axios.get('/category/list').then(value => {
          const data = value.data
          if (data.success) {
            this.category = data.content
          }
        })
      },
      getArticleByCategory(id, category) {
        this.$router.push({path: '/archive', query: {categoryId: id, categoryName: category}});
      },
    },
    data() {
      return {
        category: [],
      }
    }
  }
</script>

<style scoped>
.el-row {
  margin-bottom: 20px;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
/* yishangfuzhi */

  .header {
    text-align: center;
    font-weight: 500;
  }

  .grid-content{
    color: rgb(74, 73, 73);
    cursor: pointer;
    border: 1px solid rgb(176, 175, 175);
    box-shadow: 4px 4px rgb(236, 232, 232);
  }
  .grid-content:hover {
    color: black;
    border-color: black;
    
  } 
  /* .category {
    cursor: pointer;
  }
  .category:hover {
    color: #409EFF;
    border-color: #409EFF;
  } */
</style>
