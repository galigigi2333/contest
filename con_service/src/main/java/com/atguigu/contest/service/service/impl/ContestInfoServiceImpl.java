package com.atguigu.contest.service.service.impl;

import com.atguigu.contest.service.entity.ContestInfo;
import com.atguigu.contest.service.mapper.ContestInfoMapper;
import com.atguigu.contest.service.service.ContestDescriptionService;
import com.atguigu.contest.service.service.ContestInfoService;
import com.atguigu.contest.service.util.ContestQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author galigigi
 * @since 2020-02-25
 */
@Service
public class ContestInfoServiceImpl extends ServiceImpl<ContestInfoMapper, ContestInfo> implements ContestInfoService {

    @Autowired
    private ContestDescriptionService descriptionService;

    @Override
    public IPage<ContestInfo>  selectPageContestInfo(Page<ContestInfo> pageParam, ContestQueryVo contestQueryVo) {

        QueryWrapper<ContestInfo> wrapper = new QueryWrapper<>();

        if (contestQueryVo==null){
            return baseMapper.selectPage(pageParam, null);
        }
        String personCharge = contestQueryVo.getPersonCharge();
        String name = contestQueryVo.getName();

        Integer state = contestQueryVo.getState();
        Integer typeId = contestQueryVo.getTypeId();

        if (!StringUtils.isEmpty(personCharge)){
            wrapper.eq("person_charge",personCharge);
        }
        if (!StringUtils.isEmpty(name)){
            wrapper.eq("name",name);
        }

        if (state!=null){
            wrapper.eq("state",state);
        }
        if (typeId!=null){

            wrapper.eq("type_id",typeId);
        }

        return baseMapper.selectPage(pageParam,wrapper);

    }

    /**
     * 根据id删除竞赛基本信息 同时删除详细信息
     * @param id
     */
    @Transactional
    @Override
    public void deleteById(Integer id) {

        baseMapper.deleteById(id);

        descriptionService.removeById(id);
    }

    /**
     * 根据关键字 模糊查询 即时返回 完成自动查询
     * @param key
     * @return
     */
    @Override
    public List<Map<String, Object>> selectByKey(String key) {
        QueryWrapper<ContestInfo> wrapper = new QueryWrapper<>();
        wrapper.select("name","id").likeRight("name",key);

        List<Map<String, Object>> maps = baseMapper.selectMaps(wrapper);
        return maps;
    }

    /**
     * 保存赛事基本信息 并返回id
     * @param contestInfo
     * @return
     */
    @Override
    public Integer saveContestInfo(ContestInfo contestInfo) {
        baseMapper.insert(contestInfo);

        return contestInfo.getId();
    }

    /**
     * 修改审核状态
     * @param id
     * @param state
     */
    @Override
    public void updateState(Integer id, Integer state) {
        ContestInfo contestInfo = new ContestInfo();
        contestInfo.setState(state);
        UpdateWrapper<ContestInfo> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",id);
        baseMapper.update(contestInfo,wrapper);
    }

    /**
     * 分页查询 已经提交的竞赛申报列表
     * @param pageParam
     * @param contestQueryVo
     * @return
     */
    @Override
    public IPage<ContestInfo> selectBySubmit(Page<ContestInfo> pageParam, ContestQueryVo contestQueryVo) {

        QueryWrapper<ContestInfo> wrapper = new QueryWrapper<>();

        if (contestQueryVo==null){
            return baseMapper.selectPage(pageParam, null);
        }
        String personCharge = contestQueryVo.getPersonCharge();
        String name = contestQueryVo.getName();

        Integer state = contestQueryVo.getState();
        Integer typeId = contestQueryVo.getTypeId();

        if (!StringUtils.isEmpty(personCharge)){
            wrapper.eq("person_charge",personCharge);
        }
        if (!StringUtils.isEmpty(name)){
            wrapper.eq("name",name);
        }

        if (state!=null){
            wrapper.eq("state",state);
        }
        if (typeId!=null){

            wrapper.eq("type_id",typeId);
        }
             wrapper.eq("submit",2);
        return baseMapper.selectPage(pageParam,wrapper);

    }
}
