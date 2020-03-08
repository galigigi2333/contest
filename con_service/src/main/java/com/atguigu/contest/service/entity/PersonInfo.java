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
@TableName("con_person_info")
@ApiModel(value="PersonInfo对象", description="")
public class PersonInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "团队或个人ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "团队名称（或者个人姓名）")
    private String teamName;

    @ApiModelProperty(value = "校内指导教师")
    private String inTeacher;

    @ApiModelProperty(value = "校外指导教师")
    private String outTeacher;

    @ApiModelProperty(value = "竞赛名称")
    private Integer matchName;

    @ApiModelProperty(value = "逻辑删除(0代表未删除，1代表已删除)")
    @TableLogic
    private Integer isDeleted;

    @ApiModelProperty(value = "参赛类型(1本科，2专科)")
    private Integer type;

    @ApiModelProperty(value = "参赛形式(1团队，2个人)")
    private Integer form;

    @ApiModelProperty(value = "学校名称")
    private String schoolName;


}
