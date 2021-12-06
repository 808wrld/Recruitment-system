package com.recuriment.mapper.user;

import com.recuriment.domain.dto.user.ResumeInfoDto;
import com.recuriment.domain.pojo.user.ResumeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (resume_info)数据Mapper
 *
 * @author 
 * @since 2021-11-04 17:11:39
 * @description 由 Mybatisplus Code Generator 创建
*/
public interface ResumeInfoMapper extends BaseMapper<ResumeInfo> {

    List<ResumeInfoDto> getUserResume(Integer userId);

    List<ResumeInfoDto> getByCId(@Param("cId") Integer cId);
}
