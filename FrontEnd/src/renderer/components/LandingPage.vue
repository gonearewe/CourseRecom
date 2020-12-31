<template>
  <el-row>
  <el-col :span="6">
    <div class="grid-content bg-purple">
       <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>我的课程</span>
          </template>
          <el-menu-item-group>
            <template slot="title">大一</template>
            <el-menu-item index="1-1">第一学期</el-menu-item>
            <el-menu-item index="1-2">第二学期</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group>
            <template slot="title">大二</template>
            <el-menu-item index="1-1">第一学期</el-menu-item>
            <el-menu-item index="1-2">第二学期</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group>
            <template slot="title">大三</template>
            <el-menu-item index="1-1">第一学期</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-menu-item index="2">
          <i class="el-icon-menu"></i>
          <span slot="title">推荐课程</span>
        </el-menu-item>
        <el-menu-item index="3" disabled>
          <i class="el-icon-document"></i>
          <span slot="title">我的同学</span>
        </el-menu-item>
        <el-menu-item index="3">
          <i class="el-icon-document"></i>
          <span slot="title">导入课程</span>
        </el-menu-item>
      </el-menu>
    </div>
  </el-col>
  <el-col :span="15">
    <div class="grid-content bg-purple-light">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%">
        <el-table-column
          label="课程序号"
          width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.id }}</span>
          </template>
        </el-table-column>
        <el-table-column
          label="课程名称"
          width="180">
          <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
              <p>名称: {{ scope.row.name }}</p>
              <p>授课教师: {{ scope.row.teacher }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.name }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column
          label="推荐指数"
          width="180">
          <template slot-scope="scope">
            <span style="margin-left: 10px">{{ scope.row.score }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">评价</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">不感兴趣</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </el-col>
</el-row>
</template>

<script>
  export default {
    data () {
      // TODO: records should be stored in a more proper data structure
      // example for showing in PPT
      return {
        tableData: [{
          id: 'U08M11006',
          name: '单片机及嵌入式系统设计',
          teacher: '杨奇',
          score: 92
        }, {
          id: 'U08M11039',
          name: '机器视觉与人工智能',
          teacher: '戴玉超',
          score: 91
        }, {
          id: 'U08M11234',
          name: '大数据',
          teacher: '雷雨 侍佼',
          score: 90
        }, {
          id: 'U08M11021',
          name: '数字图像处理',
          teacher: '樊养余 王毅',
          score: 89
        }, {
          id: 'U08M11138',
          name: 'DSP/FPGA原理及应用',
          teacher: '吕国云 张怡',
          score: 89
        }, {
          id: 'U08M11141',
          name: '模式识别',
          teacher: '梅少辉',
          score: 87
        }, {
          id: 'UOCL11022',
          name: '美学原理',
          teacher: '在线开放课程',
          score: 86
        }]
      }
    },
    methods: {
      // TODO: switch fuctions
      handleOpen (key, keyPath) {
        console.log(key, keyPath)
      },
      handleClose (key, keyPath) {
        console.log(key, keyPath)
      },
      handleEdit (index, row) {
        console.log(index, row)
      },
      handleDelete (index, row) {
        console.log(index, row)
      }
    }
  }
</script>
