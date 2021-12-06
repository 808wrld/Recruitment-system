package com.recuriment.domain.pojo.user;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 投诉(user_complain)实体类
 *
 * @author 
 * @since 2021-11-06 19:01:41
 * @description 
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user_complain")
public class UserComplain extends Model<UserComplain> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 企业id
     */
    private Integer cId;
    /**
     * 投诉内容
     */
    private String complain;
    /**
     * 创建时间
     */
    private Date gmtCreate;


    @TableField(exist = false)
    private String uName;

    @TableField(exist = false)
    private String cName;
}