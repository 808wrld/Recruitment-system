package com.recuriment.service.user;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recuriment.common.enums.ExceptionEnum;
import com.recuriment.domain.pojo.company.CompanyInfo;
import com.recuriment.domain.pojo.company.JobInfo;
import com.recuriment.domain.pojo.user.ResumeInfo;
import com.recuriment.domain.pojo.user.UserInfo;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.domain.vo.user.ResumeVo;
import com.recuriment.mapper.company.CompanyInfoMapper;
import com.recuriment.mapper.company.JobInfoMapper;
import com.recuriment.mapper.user.ResumeInfoMapper;
import com.recuriment.mapper.user.UserInfoMapper;
import com.recuriment.utils.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author lqp
 * @Date 2021/11/4 17:14
 **/
@Service
public class ResumeInfoService {

    @Autowired
    ResumeInfoMapper resumeInfoMapper;
    @Autowired
    JobInfoMapper jobInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    CompanyInfoMapper companyInfoMapper;

    public PublicRes getUserResume() {
        return PublicRes.OK(resumeInfoMapper.getUserResume(Subject.getUserId()));
    }


    public PublicRes getUserResumeByCid() {
        CompanyInfo companyInfo = companyInfoMapper.selectOne(new LambdaQueryWrapper<CompanyInfo>().eq(CompanyInfo::getUserId, Subject.getUserId()));
        return PublicRes.OK(resumeInfoMapper.getByCId(companyInfo.getId()));
    }

    /**
     * 已投递简历信息
     * @param jId
     * @return
     */
    public PublicRes getUserResumeInfo(Integer jId) {
        ResumeInfo resumeInfo = resumeInfoMapper.selectOne(new LambdaQueryWrapper<ResumeInfo>().eq(ResumeInfo::getUserId, Subject.getUserId()).eq(ResumeInfo::getState, 0).eq(ResumeInfo::getJId, jId));
        return PublicRes.OK(resumeInfo);
    }

    /**
     * 投递简历
     * @return
     */
    public PublicRes addResume(ResumeVo resumeVo) {
        ResumeInfo resumeInfo1 = resumeInfoMapper.selectOne(new LambdaQueryWrapper<ResumeInfo>().eq(ResumeInfo::getUserId, Subject.getUserId()).eq(ResumeInfo::getState, 0));
        if(resumeInfo1 != null) {
            return PublicRes.Error(ExceptionEnum.RESUME_ERROR_DUPLICATE);
        }
        ResumeInfo resumeInfo = new ResumeInfo();
        resumeInfo.setJId(resumeVo.getJId());

        JobInfo jobInfo = jobInfoMapper.selectById(resumeVo.getJId());
        resumeInfo.setCId(jobInfo.getCId());

        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserId, Subject.getUserId()));
        if(userInfo == null || StrUtil.isEmpty(userInfo.getCurriculumVitae())) {
            return PublicRes.Error(ExceptionEnum.RESUME_ERROR_NO_CURRICULUM_VITAE);
        }
        resumeInfo.setUserId(Subject.getUserId());
        resumeInfo.setCurriculumVitae(userInfo.getCurriculumVitae());
        resumeInfo.setResumeTime(new Date());
        resumeInfo.setState(0);
        resumeInfoMapper.insert(resumeInfo);
        return PublicRes.OK();
    }


    public void updateState(Integer id, Integer state) {
        ResumeInfo resumeInfo = new ResumeInfo();
        resumeInfo.setId(id).setState(state);
        resumeInfoMapper.updateById(resumeInfo);
    }

}
