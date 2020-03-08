package com.atguigu.contest.service.util;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ContestQueryVo {

    @ApiModelProperty(value = "赛事名称")
    private String name;


    @ApiModelProperty(value = "竞赛类型ID")
    private Integer typeId;

    @ApiModelProperty(value = "赛事负责人")
    private String personCharge;

    @ApiModelProperty(value = "审核状态（1未审核，2已审核）")
    private Integer state;
}
