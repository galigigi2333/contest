package com.atguigu.contest.service.controller;


import com.atguigu.contest.service.entity.ContestInfo;
import com.atguigu.contest.service.service.ContestInfoService;
import com.atguigu.contest.service.util.ContestQueryVo;
import com.atguigu.contest.service.util.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author galigigi
 * @since 2020-02-25
 */
@RestController
@RequestMapping("/contest-info")
@CrossOrigin
public class ContestInfoController {

    @Autowired
    private ContestInfoService infoService;


    /***
     * 已经审核的竞赛列表
     * @return
     */
    @GetMapping("get/state")
    public R selectByState(){
        QueryWrapper<ContestInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("state",2);
        List<ContestInfo> list = infoService.list(wrapper);

        return R.ok().data("items",list);
    }

    /**
     * 已经提交的列表
     * @param page
     * @param limit
     * @param contestQueryVo
     * @return
     */
    @GetMapping("get-submit/{page}/{limit}")
    public R selectBySubmit(
            @PathVariable("page")Integer page,
            @PathVariable("limit")Integer limit,
            ContestQueryVo contestQueryVo
    ){
        Page<ContestInfo> pageParam = new Page<ContestInfo>(page,limit);

        IPage<ContestInfo> infoPage = infoService.selectBySubmit(pageParam, contestQueryVo);
        List<ContestInfo> records =infoPage.getRecords();
        long total = infoPage.getTotal();
        return  R.ok().data("items",records).data("total",total);
    }

    @GetMapping("/get/name/{key}")
    public R selectByKey(
            @PathVariable("key")String key
    ) {
        List<Map<String, Object>> list = infoService.selectByKey(key);

        return R.ok().data("items", list);
    }

    /**
     * 修改审核状态未审核
     * @param id
     * @param state
     * @return
     */
    @PutMapping("update-state")
    public R updateState(
            @RequestParam Integer id,
            @RequestParam Integer state
    ){
        infoService.updateState(id,state);
        return R.ok();
    }
    @PutMapping("update-state-reject")
    public R updateStateReject(
            @RequestParam Integer id,
            @RequestParam Integer state,
            @RequestParam Integer submit
    ){
        ContestInfo contestInfo = new ContestInfo();
        contestInfo.setState(state);
        contestInfo.setSubmit(submit);
        QueryWrapper<ContestInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        infoService.update(contestInfo,wrapper);
        return R.ok();
    }

    /**
     * 分页查询 列表
     * @param page
     * @param limit
     * @param contestQueryVo
     * @return
     */
    @GetMapping("list/{page}/{limit}")
    public R selectPageContestInfo(
            @PathVariable("page")Integer page,
            @PathVariable("limit")Integer limit,
            ContestQueryVo contestQueryVo
    ){
        Page<ContestInfo> pageParam = new Page<ContestInfo>(page,limit);

        IPage<ContestInfo> infoPage = infoService.selectPageContestInfo(pageParam, contestQueryVo);
        List<ContestInfo> records =infoPage.getRecords();
        long total = infoPage.getTotal();
        return  R.ok().data("items",records).data("total",total);
    }

    /**
     * 获取列表
     * @return
     */
    @GetMapping("getlist")
    public R selectList(){
        List<ContestInfo> list = infoService.list(null);
        return R.ok().data("items",list);
    }

    /**
     * 保存
     * @param contestInfo
     * @return
     */
    @PostMapping("save")
    public R save(
           @RequestBody ContestInfo contestInfo
    ){
       Integer id =infoService.saveContestInfo(contestInfo);
        return R.ok().data("id",id).message("保存成功");
    }

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
     public R selectById(
             @PathVariable("id")Integer id
    ){
        ContestInfo contestInfo = infoService.getById(id);
        return R.ok().data("item",contestInfo);
    }

    /**
     * 根据ID修改
     *
     * @param contestInfo
     * @return
     */
    @PutMapping("update")
    public R updateById(
            @RequestBody ContestInfo contestInfo
    ){
        contestInfo.setState(1);
        infoService.updateById(contestInfo);

        return  R.ok().message("更新成功");
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R deleteById(
            @PathVariable("id")Integer id
    ){
        infoService.deleteById(id);
        return  R.ok().message("删除成功");
    }


}

