package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FitnessWorkoutRecord;

/**
 * 运动打卡记录（增强版）Mapper接口
 * 
 * @author ruoyi
 * @date 2026-05-31
 */
public interface FitnessWorkoutRecordMapper 
{
    /**
     * 查询运动打卡记录（增强版）
     * 
     * @param id 运动打卡记录（增强版）主键
     * @return 运动打卡记录（增强版）
     */
    public FitnessWorkoutRecord selectFitnessWorkoutRecordById(Long id);

    /**
     * 查询运动打卡记录（增强版）列表
     * 
     * @param fitnessWorkoutRecord 运动打卡记录（增强版）
     * @return 运动打卡记录（增强版）集合
     */
    public List<FitnessWorkoutRecord> selectFitnessWorkoutRecordList(FitnessWorkoutRecord fitnessWorkoutRecord);

    /**
     * 新增运动打卡记录（增强版）
     * 
     * @param fitnessWorkoutRecord 运动打卡记录（增强版）
     * @return 结果
     */
    public int insertFitnessWorkoutRecord(FitnessWorkoutRecord fitnessWorkoutRecord);

    /**
     * 修改运动打卡记录（增强版）
     * 
     * @param fitnessWorkoutRecord 运动打卡记录（增强版）
     * @return 结果
     */
    public int updateFitnessWorkoutRecord(FitnessWorkoutRecord fitnessWorkoutRecord);

    /**
     * 删除运动打卡记录（增强版）
     * 
     * @param id 运动打卡记录（增强版）主键
     * @return 结果
     */
    public int deleteFitnessWorkoutRecordById(Long id);

    /**
     * 批量删除运动打卡记录（增强版）
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFitnessWorkoutRecordByIds(Long[] ids);
}
