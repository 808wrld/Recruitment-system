package com.recuriment.controller.company;

import com.recuriment.aop.annotation.UserLoginToken;
import com.recuriment.domain.pojo.company.CompanyInfo;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 企业
 *
 *
 * @author
 * @module
 * @date 2021/10/25 16:40
 */
@CrossOrigin
@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    /**
     * 首页企业
     * @return
     */
    @GetMapping
    public PublicRes getCompanyList() {
        return PublicRes.OK(companyService.getCompanyList());
    }

    /**
     * 首页企业详情
     * @param id
     * @return
     */
    @GetMapping("info/{id}")
    public PublicRes getCompanyInfo(@PathVariable Integer id) {
        return PublicRes.OK(companyService.getCompanyInfo(id));
    }

    /**
     * 用户企业信息
     * @return
     */
    @UserLoginToken
    @GetMapping("userCompany")
    public PublicRes getUserCompanyInfo() {
        return PublicRes.OK(companyService.getUserCompanyInfo());
    }

    /**
     *  用户企业信息添加
     * @return
     */
    @UserLoginToken
    @PutMapping("userCompany")
    public PublicRes addUserCompanyInfo(@RequestBody CompanyInfo companyInfo) {
        return companyService.addUserCompanyInfo(companyInfo);
    }

    /**
     * 用户企业信息更新
     * @return
     */
    @UserLoginToken
    @PostMapping("userCompany")
    public PublicRes updateUserCompanyInfo(@RequestBody CompanyInfo companyInfo) {
        return companyService.updateUserCompanyInfo(companyInfo);
    }
}
