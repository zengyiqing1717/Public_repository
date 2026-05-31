<template>
  <div class="fitness-dashboard">
    <!-- 欢迎卡片 -->
    <el-row :gutter="20">
      <el-col :span="24">
        <div class="welcome-card">
          <div class="user-info">
            <el-avatar :size="64" :src="userAvatar"></el-avatar>
            <div style="margin-left: 20px">
              <h2>你好，{{ userName }}！</h2>
              <p>今日已消耗 {{ todayCalories }} 大卡，目标完成度 {{ completionRate }}%</p>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>

    <!-- 统计卡片 -->
    <el-row :gutter="20" style="margin-top: 20px">
      <el-col :xs="24" :sm="12" :md="6">
        <el-card shadow="hover" class="stat-card">
          <div class="stat-icon"><i class="el-icon-time"></i></div>
          <div class="stat-number">{{ todayWorkoutMinutes }}</div>
          <div class="stat-label">今日运动(分钟)</div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="6">
        <el-card shadow="hover" class="stat-card">
          <div class="stat-icon"><i class="el-icon-s-promotion"></i></div>
          <div class="stat-number">{{ todayCalories }}</div>
          <div class="stat-label">消耗卡路里</div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="6">
        <el-card shadow="hover" class="stat-card">
          <div class="stat-icon"><i class="el-icon-food"></i></div>
          <div class="stat-number">{{ todayMealCalories }}</div>
          <div class="stat-label">摄入热量(大卡)</div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12" :md="6">
        <el-card shadow="hover" class="stat-card">
          <div class="stat-icon"><i class="el-icon-data-line"></i></div>
          <div class="stat-number">{{ completionRate }}%</div>
          <div class="stat-label">今日目标完成度</div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 图表区域 -->
    <el-row :gutter="20" style="margin-top: 20px">
      <el-col :span="16">
        <el-card header="近7天运动趋势">
          <div ref="trendChart" style="height: 350px"></div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card header="今日餐次热量">
          <div ref="mealChart" style="height: 350px"></div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 快捷入口 -->
    <el-row :gutter="20" style="margin-top: 20px">
      <el-col :span="24">
        <el-card header="快捷入口">
          <el-button type="primary" plain @click="goTo('/fitness/workout')">快速打卡</el-button>
          <el-button type="success" plain @click="goTo('/fitness/meal')">记录饮食</el-button>
          <el-button type="warning" plain @click="goTo('/fitness/course')">预约课程</el-button>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from 'echarts'

export default {
  name: "FitnessDashboard",
  data() {
    return {
      userName: '健身达人',
      userAvatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
      todayWorkoutMinutes: 45,
      todayCalories: 320,
      todayMealCalories: 480,
      completionRate: 75,
    }
  },
  mounted() {
    this.initTrendChart()
    this.initMealChart()
  },
  methods: {
    initTrendChart() {
      const chart = echarts.init(this.$refs.trendChart)
      chart.setOption({
        tooltip: { trigger: 'axis' },
        xAxis: { type: 'category', data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日'] },
        yAxis: { type: 'value', name: '卡路里' },
        series: [{ type: 'line', data: [280, 310, 290, 350, 400, 480, 520], smooth: true, areaStyle: {} }]
      })
    },
    initMealChart() {
      const chart = echarts.init(this.$refs.mealChart)
      chart.setOption({
        tooltip: { trigger: 'item' },
        legend: { top: 'bottom' },
        series: [{
          type: 'pie',
          radius: '55%',
          data: [
            { name: '早餐', value: 180 },
            { name: '午餐', value: 200 },
            { name: '晚餐', value: 100 },
            { name: '加餐', value: 0 }
          ]
        }]
      })
    },
    goTo(path) {
      this.$router.push(path)
    }
  }
}
</script>

<style scoped lang="scss">
.fitness-dashboard {
  background-color: #f5f7fa;
  padding: 20px;
  min-height: 100vh;

  .welcome-card {
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    border-radius: 16px;
    padding: 24px;
    color: white;

    .user-info {
      display: flex;
      align-items: center;
    }
  }

  .stat-card {
    text-align: center;
    transition: all 0.3s;

    .stat-icon {
      font-size: 32px;
      color: #409eff;
      margin-bottom: 8px;
    }

    .stat-number {
      font-size: 28px;
      font-weight: bold;
      color: #303133;
    }

    .stat-label {
      font-size: 14px;
      color: #909399;
      margin-top: 8px;
    }
  }
}
</style>