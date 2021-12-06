package com.recuriment.mapper.company;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recuriment.domain.dto.company.JobDetailDto;
import com.recuriment.domain.dto.company.JobInfoDto;
import com.recuriment.domain.pojo.company.JobInfo;
import com.recuriment.domain.vo.company.JobVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职业表(job_info)数据Mapper
 * @author
 * @since 2021-10-25 16:20:42
 * @description 
*/
public interface JobInfoMapper extends BaseMapper<JobInfo> {

    /**
     * 首页职位
     * @return
     */
    List<JobInfoDto> getHomePageJobList(@Param("jobVo") JobVo jobVo);

    /**
     * 职位详情
     * @param jId
     * @return
     */
    JobDetailDto getJobDetail(@Param("jId") Integer jId);

    /**
     * 公司id获取职位信息
     * @param cId
     * @return
     */
    List<JobDetailDto> getByCId(@Param("cId") Integer cId);
}
