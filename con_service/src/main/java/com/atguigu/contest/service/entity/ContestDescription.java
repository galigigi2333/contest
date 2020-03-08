package com.atguigu.contest.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author galigigi
 * @since 2020-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("con_contest_description")
@ApiModel(value="ContestDescription对象", description="")
public class ContestDescription implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "竞赛项目id（外键）" )
    @TableId(value = "id", type = IdType.NONE)
    private Integer id;

    @ApiModelProperty(value = "竞赛级别ID")
    private Integer levelId;

    @ApiModelProperty(value = "院赛时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date collegeTime;

    @ApiModelProperty(value = "校赛时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date schoolTime;

    @ApiModelProperty(value = "省赛时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date provinceTime;

    @ApiModelProperty(value = "国赛时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date countryTime;

    @ApiModelProperty(value = "国际赛时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date nationalTime;

    @ApiModelProperty(value = "省赛地点")
    private String provinceAddress;

    @ApiModelProperty(value = "国赛地点")
    private String countryAddress;

    @ApiModelProperty(value = "国际赛地点")
    private String nationalAddress;

    @ApiModelProperty(value = "院赛计划花费")
    private BigDecimal collegePrice;

    @ApiModelProperty(value = "省赛计划花费")
    private BigDecimal provincePrice;

    @ApiModelProperty(value = "国赛计划花费")
    private BigDecimal countryPrice;

    @ApiModelProperty(value = "国际赛预计花费")
    private BigDecimal nationalPrice;

    @ApiModelProperty(value = "逻辑删除(0代表未删除，1代表已删除)")
    @TableLogic
    private Integer isDeleted;


}
