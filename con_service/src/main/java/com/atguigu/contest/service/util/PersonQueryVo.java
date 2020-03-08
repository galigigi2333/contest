package com.atguigu.contest.service.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PersonQueryVo {

    @ApiModelProperty(value = "团队名称（或者个人姓名）")
    private String teamName;

    @ApiModelProperty(value = "竞赛名称")
    private Integer matchName;

    @ApiModelProperty(value = "参赛类型(1本科，2专科)")
    private Integer type;

    @ApiModelProperty(value = "参赛形式(1团队，2个人)")
    private Integer form;



}
