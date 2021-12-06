package com.recuriment.domain.pojo.company;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.recuriment.common.enums.CommonEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 企业表(company_info)实体类
 *
 * @author
 * @since 2021-10-25 16:20:41
 * @description 
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("company_info")
public class CompanyInfo extends Model<CompanyInfo> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 登录用户id
     */
    private Integer userId;
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
    private Integer cCity;

    /**
     * 成立时间
     */
    private Date cEstablished;

    /**
     * 当前状态
     */
    private String cCurrentstate;

    /**
     * 联系方式
     */
    private String cContact;

    /**
     * 公司类型
     */
    private String cType;
}