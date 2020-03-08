package com.atguigu.contest.service.controller;


import com.atguigu.contest.service.entity.PersonDesc;
import com.atguigu.contest.service.service.PersonDescService;
import com.atguigu.contest.service.util.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
@RequestMapping("/person-desc")
@CrossOrigin
public class PersonDescController {

    @Autowired
    private PersonDescService descService;

    /**
     * 根据团队id 查询成员列表
     * @param teamId
     * @return
     */
    @GetMapping("get/{teamId}")
    public R getDescByTeamId(
            @PathVariable("teamId") Integer teamId
    ){
        QueryWrapper<PersonDesc> wrapper = new QueryWrapper<>();
        wrapper.eq("team_id",teamId);
        List<PersonDesc> list = descService.list(wrapper);

        return R.ok().data("items",list);
    }

    @DeleteMapping("delete/{teamId}")
    public R deleteByTeamId(
            @PathVariable("teamId") Integer teamId
    ){
        QueryWrapper<PersonDesc> wrapper = new QueryWrapper<>();
        wrapper.eq("team_id",teamId);
        descService.remove(wrapper);

        return R.ok();
    }
    @DeleteMapping("delete-by/{id}")
    public R deleteById(
            @PathVariable("id") Integer id
    ){


        descService.removeById(id);

        return R.ok();
    }

    @PostMapping("save")
    public R savePersonDesc(
            @RequestBody PersonDesc personDesc
    ){

        descService.save(personDesc);
        return R.ok().message("保存成功");
    }

    @PutMapping("update")
    public R updateById(
            @RequestBody PersonDesc personDesc
    ){
        descService.updateById(personDesc);
        return  R.ok().message("更新成功");
    }
    @GetMapping("get-by/{id}")
    public R getById(
            @PathVariable("id")Integer id
    ){
        PersonDesc desc = descService.getById(id);
        return  R.ok().data("item",desc);
    }
}

