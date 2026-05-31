package com.ruoyi.system.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.FitnessWorkoutRecord;
import com.ruoyi.system.service.IFitnessWorkoutRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 运动打卡记录（增强版）Controller
 * 
 * @author ruoyi
 * @date 2026-05-31
 */
@RestController
@RequestMapping("/system/record")
public class FitnessWorkoutRecordController extends BaseController
{
    @Autowired
    private IFitnessWorkoutRecordService fitnessWorkoutRecordService;

    /**
     * 查询运动打卡记录（增强版）列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(FitnessWorkoutRecord fitnessWorkoutRecord)
    {
        startPage();
        List<FitnessWorkoutRecord> list = fitnessWorkoutRecordService.selectFitnessWorkoutRecordList(fitnessWorkoutRecord);
        return getDataTable(list);
    }

    /**
     * 导出运动打卡记录（增强版）列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:export')")
    @Log(title = "运动打卡记录（增强版）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FitnessWorkoutRecord fitnessWorkoutRecord)
    {
        List<FitnessWorkoutRecord> list = fitnessWorkoutRecordService.selectFitnessWorkoutRecordList(fitnessWorkoutRecord);
        ExcelUtil<FitnessWorkoutRecord> util = new ExcelUtil<FitnessWorkoutRecord>(FitnessWorkoutRecord.class);
        util.exportExcel(response, list, "运动打卡记录（增强版）数据");
    }

    /**
     * 获取运动打卡记录（增强版）详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(fitnessWorkoutRecordService.selectFitnessWorkoutRecordById(id));
    }

    /**
     * 新增运动打卡记录（增强版）
     */
    @PreAuthorize("@ss.hasPermi('system:record:add')")
    @Log(title = "运动打卡记录（增强版）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FitnessWorkoutRecord fitnessWorkoutRecord)
    {
        return toAjax(fitnessWorkoutRecordService.insertFitnessWorkoutRecord(fitnessWorkoutRecord));
    }

    /**
     * 修改运动打卡记录（增强版）
     */
    @PreAuthorize("@ss.hasPermi('system:record:edit')")
    @Log(title = "运动打卡记录（增强版）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FitnessWorkoutRecord fitnessWorkoutRecord)
    {
        return toAjax(fitnessWorkoutRecordService.updateFitnessWorkoutRecord(fitnessWorkoutRecord));
    }

    /**
     * 删除运动打卡记录（增强版）
     */
    @PreAuthorize("@ss.hasPermi('system:record:remove')")
    @Log(title = "运动打卡记录（增强版）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(fitnessWorkoutRecordService.deleteFitnessWorkoutRecordByIds(ids));
    }
}
