package com.atguigu.contest.service.service;

import com.atguigu.contest.service.entity.ContestInfo;
import com.atguigu.contest.service.util.ContestQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author galigigi
 * @since 2020-02-25
 */
public interface ContestInfoService extends IService<ContestInfo> {

    IPage<ContestInfo> selectPageContestInfo(Page<ContestInfo> pageParam, ContestQueryVo contestQueryVo);

    void deleteById(Integer id);

    List<Map<String, Object>> selectByKey(String key);

    Integer saveContestInfo(ContestInfo contestInfo);

    void updateState(Integer id, Integer state);

    IPage<ContestInfo> selectBySubmit(Page<ContestInfo> pageParam, ContestQueryVo contestQueryVo);
}
