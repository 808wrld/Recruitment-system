package com.recuriment.service.company;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recuriment.domain.pojo.company.CompanyInfo;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.mapper.company.CompanyInfoMapper;
import com.recuriment.utils.Subject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 企业相关
 *
 *
 * @author
 * @module
 * @date 2021/10/28 16:51
 * @copyright
 */
@Service
@Slf4j
public class CompanyService {


    @Autowired
    CompanyInfoMapper companyInfoMapper;


    /**
     * 企业列表
     * @return
     */
    public List<CompanyInfo> getCompanyList() {
        return companyInfoMapper.selectList(new LambdaQueryWrapper<CompanyInfo>().orderByDesc(CompanyInfo::getId));
    }

    /**
     * 企业详情
     * @param id
     * @return
     */
    public CompanyInfo getCompanyInfo(Integer id) {
        return companyInfoMapper.selectById(id);
    }

    /**
     * 用户归属企业详情
     * @return
     */
    public CompanyInfo getUserCompanyInfo() {
        return companyInfoMapper.selectOne(new LambdaQueryWrapper<CompanyInfo>().eq(CompanyInfo::getUserId, Subject.getUserId()));
    }


    /**
     * 添加企业
     * @param companyInfo
     * @return
     */
    public PublicRes addUserCompanyInfo(CompanyInfo companyInfo) {
        CompanyInfo userCompanyInfo = getUserCompanyInfo();
        if(userCompanyInfo != null) {
            companyInfoMapper.deleteById(companyInfo.getId());
        }
        companyInfo.setUserId(Subject.getUserId());
        companyInfoMapper.insert(companyInfo);
        return PublicRes.OK();
    }

    /**
     * 更新 用户企业信息
     * @param companyInfo
     * @return
     */
    public PublicRes updateUserCompanyInfo(CompanyInfo companyInfo) {
        companyInfoMapper.updateById(companyInfo);
        return PublicRes.OK();
    }




}
