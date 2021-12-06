package com.recuriment.domain.dto.company;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.TableField;
import com.recuriment.common.enums.CommonEnum;
import lombok.Data;

/**
 *
 */
@Data
public class JobInfoDto {

    /**
     * 岗位id
     */
    private Integer jId;

    /**
     * 企业id
     */
    private Integer cId;

    /**
     * 公司logo
     */
    private String cLogo;

    /**
     * 公司地址
     */
    private String cAddress;

    /**
     * 岗位名称
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
     * 企业名字
     */
    private String cName;


}
