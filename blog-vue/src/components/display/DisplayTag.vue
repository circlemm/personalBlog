<template>
  <div class="dtag">
    <h2 class="header">Tags</h2>
    <div class="tag-container">
      <el-tag @click="getArticleByTagId(item.id, item.tag)" class="tag" effect="plain" type="info" v-for="(item, index) in tag">{{item.tag}}</el-tag>
    </div>
  </div>
</template>

<script>
  import axios from "axios";

  export default {
    name: "DisplayTag",
    mounted() {
      this.getAllTag();
    },
    methods: {
      getAllTag() {
        axios.get('/tag/list').then(value => {
          const data = value.data;
          if (data.success) {
            this.tag = data.content;
          }
        })
      },
      getArticleByTagId(id, tag) {
        this.$router.push({path: '/archive', query: {tagId: id, tagName: tag}});
      },
    },
    data() {
      return {
        tag: [],
      }
    }
  }
</script>

<style scoped>
  .dtag {
    text-align: center;
  }

  .header {
    text-align: center;
    font-weight: 500;
  }

  .tag-container {
    margin: 0 50px;
  }

  .tag {
    margin: 5px 10px;
    cursor: pointer;
  }

  .tag:hover {
    border-color: black;
    color: black;
  }
</style>
