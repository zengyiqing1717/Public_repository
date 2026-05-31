package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FitnessWorkoutRecordMapper;
import com.ruoyi.system.domain.FitnessWorkoutRecord;
import com.ruoyi.system.service.IFitnessWorkoutRecordService;

/**
 * 运动打卡记录（增强版）Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-31
 */
@Service
public class FitnessWorkoutRecordServiceImpl implements IFitnessWorkoutRecordService 
{
    @Autowired
    private FitnessWorkoutRecordMapper fitnessWorkoutRecordMapper;

    /**
     * 查询运动打卡记录（增强版）
     * 
     * @param id 运动打卡记录（增强版）主键
     * @return 运动打卡记录（增强版）
     */
    @Override
    public FitnessWorkoutRecord selectFitnessWorkoutRecordById(Long id)
    {
        return fitnessWorkoutRecordMapper.selectFitnessWorkoutRecordById(id);
    }

    /**
     * 查询运动打卡记录（增强版）列表
     * 
     * @param fitnessWorkoutRecord 运动打卡记录（增强版）
     * @return 运动打卡记录（增强版）
     */
    @Override
    public List<FitnessWorkoutRecord> selectFitnessWorkoutRecordList(FitnessWorkoutRecord fitnessWorkoutRecord)
    {
        return fitnessWorkoutRecordMapper.selectFitnessWorkoutRecordList(fitnessWorkoutRecord);
    }

    /**
     * 新增运动打卡记录（增强版）
     * 
     * @param fitnessWorkoutRecord 运动打卡记录（增强版）
     * @return 结果
     */
    @Override
    public int insertFitnessWorkoutRecord(FitnessWorkoutRecord fitnessWorkoutRecord)
    {
        fitnessWorkoutRecord.setCreateTime(DateUtils.getNowDate());
        return fitnessWorkoutRecordMapper.insertFitnessWorkoutRecord(fitnessWorkoutRecord);
    }

    /**
     * 修改运动打卡记录（增强版）
     * 
     * @param fitnessWorkoutRecord 运动打卡记录（增强版）
     * @return 结果
     */
    @Override
    public int updateFitnessWorkoutRecord(FitnessWorkoutRecord fitnessWorkoutRecord)
    {
        fitnessWorkoutRecord.setUpdateTime(DateUtils.getNowDate());
        return fitnessWorkoutRecordMapper.updateFitnessWorkoutRecord(fitnessWorkoutRecord);
    }

    /**
     * 批量删除运动打卡记录（增强版）
     * 
     * @param ids 需要删除的运动打卡记录（增强版）主键
     * @return 结果
     */
    @Override
    public int deleteFitnessWorkoutRecordByIds(Long[] ids)
    {
        return fitnessWorkoutRecordMapper.deleteFitnessWorkoutRecordByIds(ids);
    }

    /**
     * 删除运动打卡记录（增强版）信息
     * 
     * @param id 运动打卡记录（增强版）主键
     * @return 结果
     */
    @Override
    public int deleteFitnessWorkoutRecordById(Long id)
    {
        return fitnessWorkoutRecordMapper.deleteFitnessWorkoutRecordById(id);
    }
}
