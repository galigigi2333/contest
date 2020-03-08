package com.atguigu.contest.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@TableName("con_contest_info")
@ApiModel(value="ContestInfo对象", description="")
public class ContestInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "竞赛基本信息id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "赛事名称")
    private String name;

    @ApiModelProperty(value = "竞赛对象（本科，专科，或本和专）")
    private String obj;

    @ApiModelProperty(value = "竞赛类型ID")
    private Integer typeId;

    @ApiModelProperty(value = "主办单位")
    private String host;

    @ApiModelProperty(value = "审核状态（1未审核，2已审核）")
    private Integer state;

    @ApiModelProperty(value = "举办周期（1代表定期，2代表不定期）")
    private Integer cycle;
    @ApiModelProperty(value = "提交状态（1代表已提交，2代表未提交）")
    private Integer submit;

    @ApiModelProperty(value = "逻辑删除(0代表未删除，1代表已删除)")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "赛事负责人")
    private String personCharge;

    @ApiModelProperty(value = "负责人电话")
    private String personPhone;


}
