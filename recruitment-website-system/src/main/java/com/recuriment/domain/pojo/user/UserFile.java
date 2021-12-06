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
 * (user_file)实体类
 *
 * @author 
 * @since 2021-11-06 18:24:52
 * @description 
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("user_file")
public class UserFile extends Model<UserFile> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * userId
     */
    private Integer userId;
    /**
     * type
     */
    private String type;
    /**
     * fileUrl
     */
    private String fileUrl;
    /**
     * gmtCreate
     */
    private Date gmtCreate;

    /**
     * 备注
     */
    private String remark;
}