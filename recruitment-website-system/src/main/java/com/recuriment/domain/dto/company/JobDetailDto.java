package com.recuriment.domain.dto.company;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.recuriment.common.enums.CommonEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 岗位详情
 *
 * @author
 * @module
 * @date 2021/11/2 10:24
 * @copyright
 */
@Data
public class JobDetailDto {

    /**
     * id
     */
    private Integer jId;
    /**
     * 职位名称
     */
    private String jName;
    /**
     * 工作经验
     */
    private CommonEnum.ExperienceEnum jExperience;

    /**
     * 学历
     */
    private CommonEnum.EducationEnum jEducation;

    /**
     * 薪资
     */
    private String jSalary;

    /**
     * 城市
     */
    private CommonEnum.CityTypeEnum jCity;

    /**
     * 招聘人数
     */
    private Integer jNumber;

    /**
     * 岗位类型
     */
    private CommonEnum.JobTypeEnum jType;

    /**
     *职位介绍
     */
    private String JResume;

    /**
     *职位要求
     */
    private String JRequire;

    /**
     *职位待遇
     */
    private String JTreatment;

    /**
     *开始时间
     */
    private LocalDateTime jStime;

    /**
     *结束时间
     */
    private LocalDateTime jEtime;


    /**
     * id
     */
    private Integer cId;
    /**
     * 公司名称
     */
    private String cName;
    /**
     * 公司logo
     */
    private String cLogo;
    /**
     * 公司描述
     */
    private String cDescribe;
    /**
     * 公司地址
     */
    private String cAddress;

    /**
     * 城市
     */
    private CommonEnum.CityTypeEnum cCity;

}
