package com.recuriment.domain.pojo.user;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (resume_info)实体类
 *
 * @author 
 * @since 2021-11-04 17:11:39
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("resume_info")
public class ResumeInfo extends Model<ResumeInfo> implements Serializable {
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
     * 职位id
     */
    private Integer jId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 简历
     */
    private String curriculumVitae;
    /**
     * 投递时间
     */
    private Date resumeTime;
    /**
     * 状态
     */
    private Integer state;


    public String getStateValue() {
        if(state == 0) {
            return "待处理";
        } else if (state == 1) {
            return "简历通过";
        } else {
            return "已拒绝";
        }
    }

}