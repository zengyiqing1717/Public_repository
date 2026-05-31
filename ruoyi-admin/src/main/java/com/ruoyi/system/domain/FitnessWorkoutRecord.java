package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 运动打卡记录（增强版）对象 fitness_workout_record
 * 
 * @author ruoyi
 * @date 2026-05-31
 */
public class FitnessWorkoutRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long id;

    /** 健身用户ID */
    @Excel(name = "健身用户ID")
    private Long userId;

    /** 运动名称（跑步/卧推/深蹲等） */
    @Excel(name = "运动名称", readConverterExp = "跑=步/卧推/深蹲等")
    private String workoutType;

    /** 锻炼部位（胸/背/腿/肩/腹/有氧/全身） */
    @Excel(name = "锻炼部位", readConverterExp = "胸=/背/腿/肩/腹/有氧/全身")
    private String bodyPart;

    /** 运动类型：0有氧 1无氧 2混合 */
    @Excel(name = "运动类型：0有氧 1无氧 2混合")
    private String aerobicType;

    /** 运动时长（分钟） */
    @Excel(name = "运动时长", readConverterExp = "分=钟")
    private Long duration;

    /** 消耗卡路里 */
    @Excel(name = "消耗卡路里")
    private Long calories;

    /** 平均心率 */
    @Excel(name = "平均心率")
    private Long heartRateAvg;

    /** 运动日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "运动日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date workoutDate;

    /** 开始时间（精确到分钟） */
    @Excel(name = "开始时间", readConverterExp = "精=确到分钟")
    private Date startTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setWorkoutType(String workoutType) 
    {
        this.workoutType = workoutType;
    }

    public String getWorkoutType() 
    {
        return workoutType;
    }

    public void setBodyPart(String bodyPart) 
    {
        this.bodyPart = bodyPart;
    }

    public String getBodyPart() 
    {
        return bodyPart;
    }

    public void setAerobicType(String aerobicType) 
    {
        this.aerobicType = aerobicType;
    }

    public String getAerobicType() 
    {
        return aerobicType;
    }

    public void setDuration(Long duration) 
    {
        this.duration = duration;
    }

    public Long getDuration() 
    {
        return duration;
    }

    public void setCalories(Long calories) 
    {
        this.calories = calories;
    }

    public Long getCalories() 
    {
        return calories;
    }

    public void setHeartRateAvg(Long heartRateAvg) 
    {
        this.heartRateAvg = heartRateAvg;
    }

    public Long getHeartRateAvg() 
    {
        return heartRateAvg;
    }

    public void setWorkoutDate(Date workoutDate) 
    {
        this.workoutDate = workoutDate;
    }

    public Date getWorkoutDate() 
    {
        return workoutDate;
    }

    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("workoutType", getWorkoutType())
            .append("bodyPart", getBodyPart())
            .append("aerobicType", getAerobicType())
            .append("duration", getDuration())
            .append("calories", getCalories())
            .append("heartRateAvg", getHeartRateAvg())
            .append("workoutDate", getWorkoutDate())
            .append("startTime", getStartTime())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
