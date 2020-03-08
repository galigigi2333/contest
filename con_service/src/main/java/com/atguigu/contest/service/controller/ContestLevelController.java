package com.atguigu.contest.service.controller;


import com.atguigu.contest.service.entity.ContestLevel;
import com.atguigu.contest.service.service.ContestLevelService;
import com.atguigu.contest.service.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/contest-level")
@CrossOrigin
public class ContestLevelController {
    @Autowired
    private ContestLevelService levelService;

    @GetMapping("list")
    public R getList(){
        List<ContestLevel> list = levelService.list(null);
        return R.ok().data("items",list);
    }

}

