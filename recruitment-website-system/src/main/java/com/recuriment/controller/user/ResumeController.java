package com.recuriment.controller.user;

import com.recuriment.aop.annotation.UserLoginToken;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.domain.vo.user.ResumeVo;
import com.recuriment.service.user.ResumeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 简历投递
 *
 * @Author
 * @Date 2021/11/4 17:12
 **/
@RestController
@CrossOrigin
@RequestMapping("resume")
public class ResumeController {

    @Autowired
    ResumeInfoService resumeInfoService;

    /**
     * 用户投递简历列表
     * @param
     * @return
     */
    @UserLoginToken
    @GetMapping
    public PublicRes getUserResumeInfo() {
        return resumeInfoService.getUserResume();
    }

    /**
     * 获取企业应聘信息
     * @return
     */
    @UserLoginToken
    @GetMapping("userCompanyJob")
    public PublicRes userCompanyJob() {
        return resumeInfoService.getUserResumeByCid();
    }

    /**
     * 简历详情
     * @param jId
     * @return
     */
    @UserLoginToken
    @GetMapping("info")
    public PublicRes getUserResumeInfo(Integer jId) {
        return resumeInfoService.getUserResumeInfo(jId);
    }

    /**
     * 投递简历
     * @param resumeVo
     * @return
     */
    @UserLoginToken
    @PostMapping
    public PublicRes addResume(@RequestBody ResumeVo resumeVo) {
        return resumeInfoService.addResume(resumeVo);
    }

    /**
     * 通过
     * @param id
     * @return
     */
    @UserLoginToken
    @PostMapping("pass/{id}")
    public PublicRes updateStatePass(@PathVariable Integer id) {
        resumeInfoService.updateState(id, 1);
        return PublicRes.OK();
    }

    /**
     * 拒绝
     * @param id
     * @return
     */
    @UserLoginToken
    @PostMapping("reject/{id}")
    public PublicRes updateStateReject(@PathVariable Integer id) {
        resumeInfoService.updateState(id, 2);
        return PublicRes.OK();
    }



}
