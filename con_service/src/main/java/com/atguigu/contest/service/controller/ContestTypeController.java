package com.atguigu.contest.service.controller;


import com.atguigu.contest.service.entity.ContestType;
import com.atguigu.contest.service.service.ContestTypeService;
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
@RequestMapping("/contest-type")
@CrossOrigin
public class ContestTypeController {

    @Autowired
    private ContestTypeService typeService;


    @GetMapping("list")
    public R list(){
        List<ContestType> list = typeService.list(null);
        return R.ok().data("items",list);
    }
}

