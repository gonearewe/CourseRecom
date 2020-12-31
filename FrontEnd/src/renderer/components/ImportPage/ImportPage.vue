<template lang="pug">
    <!-- page for user importing information -->
<div class="block">
  <el-timeline>
    <el-timeline-item
      v-for="(activity, index) in activities"
      :key="index"
      :icon="activity.icon"
      :type="activity.type"
      :color="activity.color"
      :size="activity.size"
      :timestamp="activity.timestamp">
      {{activity.content}}
    </el-timeline-item>
  </el-timeline>
</div>
</template>

<script>
  export default {
    data() {
      return {
        activities: [{
          content: '图标',
          timestamp: '2020-12-31 20:46',
          size: 'large',
          type: 'primary',
          icon: 'el-icon-more'
        }, {
          content: '导入',
          timestamp: '2020-12-31 20:46',
          color: '#0bbd87'
        }, {
          content: '自定义尺寸',
          timestamp: '2020-12-31 20:46',
          size: 'large'
        }, {
          content: '默认',
          timestamp: '2020-12-31 20:46'
        }]
      };
    }
  };
</script>