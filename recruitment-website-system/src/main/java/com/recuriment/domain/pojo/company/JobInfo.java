package com.recuriment.domain.pojo.company;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 职业表(job_info)实体类
 *
 * @author 李秋平
 * @since 2021-10-25 16:20:42
 * @description 
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("job_info")
public class JobInfo extends Model<JobInfo> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 公司id
     */
    private Integer cId;
    /**
     * 职位名称
     */
    private String jName;
    /**
     * 工作经验
     */
    private Integer jExperience;
    /**
     * 学历
     */
    private Integer jEducation;
    /**
     * 薪资范围(低)
     */
    private Integer jSalaryMin;
    /**
     * 薪资范围(高)
     */
    private Integer jSalaryMax;

    /**
     * 招聘人数
     */
    private Integer jNumber;

    /**
     * 岗位类型
     */
    private Integer jType;

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
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date jStime;

    /**
     *结束时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date jEtime;

}