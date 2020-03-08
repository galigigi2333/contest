package com.atguigu.contest.service.controller;


import com.atguigu.contest.service.entity.PersonDesc;
import com.atguigu.contest.service.entity.PersonInfo;
import com.atguigu.contest.service.service.PersonDescService;
import com.atguigu.contest.service.service.PersonInfoService;
import com.atguigu.contest.service.util.PersonQueryVo;
import com.atguigu.contest.service.util.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author galigigi
 * @since 2020-02-25
 */
@RestController
@RequestMapping("/person-info")
@CrossOrigin
public class PersonInfoController {

    @Autowired
    private PersonInfoService infoService;
    @Autowired
    private PersonDescService descService;

    @GetMapping("getlist/{page}/{limit}")
    public R selectPage(
            @PathVariable("page")Integer page,
            @PathVariable("limit")Integer limit,
            PersonQueryVo personQueryVo
    ){

        Page<PersonInfo> pageParam = new Page<>();
        IPage<PersonInfo> pageInfo = infoService.selectPage(pageParam, personQueryVo);
        return R.ok().data("items",pageInfo.getRecords()).data("total",pageInfo.getTotal());

    }

    @PutMapping("update")
    public R updateById(
            @RequestBody PersonInfo personInfo
    ){

        infoService.updateById(personInfo);
        return R.ok().message("更新成功");
    }
    @GetMapping("get/{id}")
    public R getById(
            @PathVariable("id") Integer id
    ){
        PersonInfo personInfo = infoService.getById(id);
        return R.ok().data("item",personInfo);
    }

    @PostMapping("save")
    public R savePersonInfo(
            @RequestBody PersonInfo personInfo
    ){
        Integer id=infoService.savePersonInfo(personInfo);

       return R.ok().data("id",id);
    }

    @DeleteMapping("delete/{id}")
    public R delete(
            @PathVariable("id")Integer id
    ){
        infoService.removeById(id);
        QueryWrapper<PersonDesc> wrapper = new QueryWrapper<>();
        wrapper.eq("team_id",id);
        descService.remove(wrapper);
        return R.ok().message("删除成功");
    }

}

