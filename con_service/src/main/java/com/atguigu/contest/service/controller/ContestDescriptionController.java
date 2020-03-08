package com.atguigu.contest.service.controller;


import com.atguigu.contest.service.entity.ContestDescription;
import com.atguigu.contest.service.service.ContestDescriptionService;
import com.atguigu.contest.service.util.R;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author galigigi
 * @since 2020-02-25
 */
@RestController
@RequestMapping("/contest-description")
@CrossOrigin
public class ContestDescriptionController {
    @Autowired
    private ContestDescriptionService descriptionService;


    @GetMapping("list")
    public R list(){
        List<ContestDescription> list = descriptionService.list(null);
        return  R.ok().data("items",list);

    }
    @ApiOperation(value = "根据ID查询")
    @GetMapping("get/{id}")
    public R selectById(
            @ApiParam(name = "id",value = "竞赛基本信息ID")
            @PathVariable("id")Integer id
    ){
        ContestDescription contestDescription = descriptionService.getById(id);
        return R.ok().data("item",contestDescription);
    }

    @ApiOperation(value = "根据ID修改")
    @PutMapping("update")
    public R updateById(
            @RequestBody ContestDescription description
    ){

        descriptionService.updateById(description);
        return R.ok().message("更新成功");
    }

    @ApiOperation(value = "保存详情信息")
    @PostMapping("save")
    public R save(
            @RequestBody ContestDescription description
    ){

        descriptionService.save(description);
        return R.ok().message("保存成功");
    }


}

