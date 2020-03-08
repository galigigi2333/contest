package com.atguigu.contest.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("con_contest_level")
@ApiModel(value="ContestLevel对象", description="")
public class ContestLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "竞赛级别id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "竞赛级别 名称")
    private String name;

    @ApiModelProperty(value = "逻辑删除(0代表未删除，1代表已删除)")
    @TableLogic
    private Integer isDeleted;


}
