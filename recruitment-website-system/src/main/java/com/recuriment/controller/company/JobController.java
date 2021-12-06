package com.recuriment.controller.company;

import com.recuriment.domain.pojo.company.JobInfo;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.domain.vo.company.JobVo;
import com.recuriment.service.company.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 职位
 *
 *
 * @author
 * @module
 * @date 2021/10/25 16:40
 */
@CrossOrigin
@RestController
@RequestMapping("job")
public class JobController {


    @Autowired
    JobService jobService;

    /**
     * 首页职位
     * @return
     */
    @GetMapping("/")
    public PublicRes getJobList(JobVo jobVo) {
        return PublicRes.OK(jobService.getHomeJobList(jobVo));
    }

    /**
     * 职位详情
     * @param jId
     * @return
     */
    @GetMapping("/info/{jId}")
    public PublicRes getJobInfo(@PathVariable Integer jId) {
        return PublicRes.OK(jobService.getJobDetail(jId));
    }


    /**
     * 根据公司id获取职位详情
     * @param id
     * @return
     */
    @GetMapping("byCid/{id}")
    public PublicRes getJobByCompanyId(@PathVariable Integer id) {
        return PublicRes.OK(jobService.getJobListByCompanyId(id));
    }


    /**
     * 根据公司id获取职位详情
     * @param id
     * @return
     */
    @GetMapping("byJid/{id}")
    public PublicRes getJobById(@PathVariable Integer id) {
        return PublicRes.OK(jobService.getJobById(id));
    }

    /**
     * 发布职位
     * @param jobInfo
     * @return
     */
    @PutMapping("addJob")
    public PublicRes addJob(@RequestBody JobInfo jobInfo) {
        return jobService.addJob(jobInfo);
    }

    /**
     * 更新职位
     * @param jobInfo
     * @return
     */
    @PostMapping
    public PublicRes updateJob(@RequestBody JobInfo jobInfo) {
        return jobService.updateJob(jobInfo);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public PublicRes deleteJob(@PathVariable Integer id) {
        jobService.deleteById(id);
        return PublicRes.OK();
    }
}
