package com.atguigu.contest.service.service;

import com.atguigu.contest.service.entity.PersonInfo;
import com.atguigu.contest.service.util.PersonQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author galigigi
 * @since 2020-02-25
 */
public interface PersonInfoService extends IService<PersonInfo> {

    IPage<PersonInfo> selectPage(Page<PersonInfo> pageParam, PersonQueryVo personQueryVo);


   Integer savePersonInfo(PersonInfo personInfo);
}
