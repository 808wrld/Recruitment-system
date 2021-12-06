package com.recuriment.domain.dto.user;

import cn.hutool.core.date.DateUtil;
import com.recuriment.common.enums.CommonEnum;
import com.recuriment.domain.pojo.user.ResumeInfo;
import lombok.Data;

import java.util.Date;

/**
 * @Author lqp
 * @Date 2021/11/5 9:01
 **/
@Data
public class ResumeInfoDto extends ResumeInfo {

    /**
     * 公司名称
     */
    private String cName;

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
     * 招聘人数
     */
    private Integer jNumber;

    /**
     * 岗位类型
     */
    private CommonEnum.JobTypeEnum jType;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 学历
     */
    private String education;

    /**
     * 毕业学校
      */
    private String graduateSchool;

    /**
     * 毕业年份
     */
    private Date graduateDate;

    /**
     * 联系方式
     */
    private String mobile;


    public Integer getAge() {

        if(birthday != null) {
            return DateUtil.age(birthday, new Date());
        }
        return null;
    }
}
