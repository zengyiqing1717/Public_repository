package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 饮食记录对象 diet_record
 * 
 * @author ruoyi
 * @date 2026-05-31
 */
public class DietRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 食物名称 */
    @Excel(name = "食物名称")
    private String foodName;

    /** 热量（千卡） */
    @Excel(name = "热量", readConverterExp = "千=卡")
    private Long calories;

    /** 餐别（早餐/午餐/晚餐/加餐） */
    @Excel(name = "餐别", readConverterExp = "早=餐/午餐/晚餐/加餐")
    private String mealType;

    /** 记录日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordDate;

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

    public void setFoodName(String foodName) 
    {
        this.foodName = foodName;
    }

    public String getFoodName() 
    {
        return foodName;
    }

    public void setCalories(Long calories) 
    {
        this.calories = calories;
    }

    public Long getCalories() 
    {
        return calories;
    }

    public void setMealType(String mealType) 
    {
        this.mealType = mealType;
    }

    public String getMealType() 
    {
        return mealType;
    }

    public void setRecordDate(Date recordDate) 
    {
        this.recordDate = recordDate;
    }

    public Date getRecordDate() 
    {
        return recordDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("foodName", getFoodName())
            .append("calories", getCalories())
            .append("mealType", getMealType())
            .append("recordDate", getRecordDate())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .toString();
    }
}
