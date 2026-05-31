<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="健身用户ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入健身用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="锻炼部位" prop="bodyPart">
        <el-input
          v-model="queryParams.bodyPart"
          placeholder="请输入锻炼部位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="运动时长" prop="durationMinutes">
        <el-input
          v-model="queryParams.durationMinutes"
          placeholder="请输入运动时长"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="消耗卡路里" prop="calories">
        <el-input
          v-model="queryParams.calories"
          placeholder="请输入消耗卡路里"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平均心率" prop="heartRateAvg">
        <el-input
          v-model="queryParams.heartRateAvg"
          placeholder="请输入平均心率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="运动日期" prop="workoutDate">
        <el-date-picker clearable
          v-model="queryParams.workoutDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择运动日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="开始具体时间" prop="startTime">
        <el-date-picker clearable
          v-model="queryParams.startTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择开始具体时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['workout:workout:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['workout:workout:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['workout:workout:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['workout:workout:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="workoutList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="记录ID" align="center" prop="id" />
      <el-table-column label="健身用户ID" align="center" prop="userId" />
      <el-table-column label="运动名称" align="center" prop="workoutType" />
      <el-table-column label="锻炼部位" align="center" prop="bodyPart" />
      <el-table-column label="运动类型：0有氧 1无氧 2混合" align="center" prop="aerobicType" />
      <el-table-column label="运动时长" align="center" prop="durationMinutes" />
      <el-table-column label="消耗卡路里" align="center" prop="calories" />
      <el-table-column label="平均心率" align="center" prop="heartRateAvg" />
      <el-table-column label="运动日期" align="center" prop="workoutDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.workoutDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="开始具体时间" align="center" prop="startTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleViewData(scope.row)"
            v-hasPermi="['workout:workout:query']"
          >详情</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['workout:workout:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['workout:workout:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 运动打卡记录详情抽屉 -->
    <workout-view-drawer ref="workoutViewRef" />
    <!-- 添加或修改运动打卡记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1100px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="健身用户ID" prop="userId">
              <el-input v-model="form.userId" placeholder="请输入健身用户ID" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="锻炼部位" prop="bodyPart">
              <el-input v-model="form.bodyPart" placeholder="请输入锻炼部位" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="运动时长" prop="durationMinutes">
              <el-input v-model="form.durationMinutes" placeholder="请输入运动时长" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="消耗卡路里" prop="calories">
              <el-input v-model="form.calories" placeholder="请输入消耗卡路里" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="平均心率" prop="heartRateAvg">
              <el-input v-model="form.heartRateAvg" placeholder="请输入平均心率" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="运动日期" prop="workoutDate">
              <el-date-picker clearable
                v-model="form.workoutDate"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择运动日期">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="开始具体时间" prop="startTime">
              <el-date-picker clearable
                v-model="form.startTime"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择开始具体时间">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注" prop="remark">
              <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listWorkout, getWorkout, delWorkout, addWorkout, updateWorkout } from "@/api/workout/workout"
import WorkoutViewDrawer from "./view"

export default {
  name: "Workout",
  components: { WorkoutViewDrawer },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 运动打卡记录表格数据
      workoutList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        workoutType: null,
        bodyPart: null,
        aerobicType: null,
        durationMinutes: null,
        calories: null,
        heartRateAvg: null,
        workoutDate: null,
        startTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "健身用户ID不能为空", trigger: "blur" }
        ],
        workoutType: [
          { required: true, message: "运动名称不能为空", trigger: "change" }
        ],
        durationMinutes: [
          { required: true, message: "运动时长不能为空", trigger: "blur" }
        ],
        workoutDate: [
          { required: true, message: "运动日期不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询运动打卡记录列表 */
    getList() {
      this.loading = true
      listWorkout(this.queryParams).then(response => {
        this.workoutList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        userId: null,
        workoutType: null,
        bodyPart: null,
        aerobicType: null,
        durationMinutes: null,
        calories: null,
        heartRateAvg: null,
        workoutDate: null,
        startTime: null,
        remark: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加运动打卡记录"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getWorkout(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改运动打卡记录"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateWorkout(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addWorkout(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除运动打卡记录编号为"' + ids + '"的数据项？').then(function() {
        return delWorkout(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 详情按钮操作 */
    handleViewData(row) {
      this.$refs["workoutViewRef"].open(row.id)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('workout/workout/export', {
        ...this.queryParams
      }, `workout_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
