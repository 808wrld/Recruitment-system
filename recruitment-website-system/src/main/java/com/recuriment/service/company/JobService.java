package com.recuriment.service.company;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.handlers.MybatisEnumTypeHandler;
import com.recuriment.domain.dto.company.JobDetailDto;
import com.recuriment.domain.dto.company.JobInfoDto;
import com.recuriment.domain.pojo.company.JobInfo;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.domain.vo.company.JobVo;
import com.recuriment.mapper.company.JobInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 *
 *
 * @author
 * @module 职位相关
 * @date 2021/10/25 16:47
 * @copyright
 */
@Service
public class JobService {

    @Autowired
    JobInfoMapper jobInfoMapper;

    /**
     * 首页职位而列表
     * @return
     */
    public List<JobInfoDto> getHomeJobList(JobVo jobVo) {
        List<JobInfoDto> homePageJobList = jobInfoMapper.getHomePageJobList(jobVo);
        return homePageJobList;
    }

    /**
     * 岗位ixangqing
     * @param jId
     * @return
     */
    public JobDetailDto getJobDetail(Integer jId) {
        return jobInfoMapper.getJobDetail(jId);
    }


    /**
     * 根据公司id获取岗位信息
     * @param id
     * @return
     */
    public List<JobDetailDto> getJobListByCompanyId(Integer id) {
        return jobInfoMapper.getByCId(id);
    }

    /**
     *
     * @param id
     * @return
     */
    public JobInfo getJobById(Integer id) {
        return jobInfoMapper.selectById(id);
    }


    /**
     * 发布职位
     * @param jobInfo
     * @return
     */
    public PublicRes addJob(JobInfo jobInfo) {
        jobInfoMapper.insert(jobInfo);
        return PublicRes.OK();
    }

    /**
     * 更新
     * @param jobInfo
     * @return
     */
    public PublicRes updateJob(JobInfo jobInfo) {
        jobInfoMapper.updateById(jobInfo);
        return PublicRes.OK();
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        jobInfoMapper.deleteById(id);
    }

}
