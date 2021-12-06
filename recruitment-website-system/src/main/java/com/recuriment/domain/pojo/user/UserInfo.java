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
 * (user_info)实体类
 *
 * @author 
 * @since 2021-11-04 14:22:58
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user_info")
public class UserInfo extends Model<UserInfo> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 联系方式
     */
    private String mobile;
    /**
     * 性别
     */
    private String sex;
    /**
     * 毕业时间
     */
    private Date graduateDate;
    /**
     * 毕业院校
     */
    private String graduateSchool;
    /**
     * 学历
     */
    private String education;
    /**
     * 自我介绍
     */
    private String introduction;
    /**
     * 简历
     */
    private String curriculumVitae;
    /**
     * 用户id
     */
    private Integer userId;

}