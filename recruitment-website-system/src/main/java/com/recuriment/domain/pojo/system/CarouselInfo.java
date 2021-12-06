package com.recuriment.domain.pojo.system;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (carousel_info)实体类
 *
 * @author 
 * @since 2021-11-06 17:13:13
 * @description 
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("carousel_info")
public class CarouselInfo extends Model<CarouselInfo> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 图片
     */
    private String pic;
    /**
     * 排序
     */
    private Integer sort;

    /**
     * 激活
     */
    private Boolean active;


    private Integer isDelete;

}