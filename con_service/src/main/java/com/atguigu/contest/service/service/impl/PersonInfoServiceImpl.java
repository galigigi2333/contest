package com.atguigu.contest.service.service.impl;

import com.atguigu.contest.service.entity.PersonInfo;
import com.atguigu.contest.service.mapper.PersonInfoMapper;
import com.atguigu.contest.service.service.PersonInfoService;
import com.atguigu.contest.service.util.PersonQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author galigigi
 * @since 2020-02-25
 */
@Service
public class PersonInfoServiceImpl extends ServiceImpl<PersonInfoMapper, PersonInfo> implements PersonInfoService {

    @Override
    public IPage<PersonInfo> selectPage(Page<PersonInfo> pageParam, PersonQueryVo personQueryVo) {

        //参赛类型 本科 专科
        Integer type = personQueryVo.getType();
        //参赛形式 团队 或者个人
        Integer form = personQueryVo.getForm();
        //参赛信息id
        Integer matchName = personQueryVo.getMatchName();
        String teamName = personQueryVo.getTeamName();//团队名称或个人姓名

        QueryWrapper<PersonInfo> wrapper = new QueryWrapper<>();
        if(type!=null){
            wrapper.eq("type",type);
        }
        if(form!=null){
            wrapper.eq("form",form);
        }
        if (matchName!=null){
            wrapper.eq("match_name",matchName);

        }
        if (!StringUtils.isEmpty(teamName)){
            wrapper.eq("team_name",teamName);
        }
      return   baseMapper.selectPage(pageParam,wrapper);


    }

    /**
     * 保存完成后 返回 团队id 和参赛形式给前端  用来判断
     * @return
     */

    public Integer savePersonInfo(PersonInfo personInfo) {

        baseMapper.insert(personInfo);


        return personInfo.getId();
    }
}
