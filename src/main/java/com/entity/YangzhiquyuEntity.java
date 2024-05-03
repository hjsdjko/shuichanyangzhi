package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 养殖区域
 *
 * @author 
 * @email
 */
@TableName("yangzhiquyu")
public class YangzhiquyuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YangzhiquyuEntity() {

	}

	public YangzhiquyuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 区域名称
     */
    @ColumnInfo(comment="区域名称",type="varchar(200)")
    @TableField(value = "yangzhiquyu_name")

    private String yangzhiquyuName;


    /**
     * 养殖区域编号
     */
    @ColumnInfo(comment="养殖区域编号",type="varchar(200)")
    @TableField(value = "yangzhiquyu_uuid_number")

    private String yangzhiquyuUuidNumber;


    /**
     * 养殖区域照片
     */
    @ColumnInfo(comment="养殖区域照片",type="varchar(200)")
    @TableField(value = "yangzhiquyu_photo")

    private String yangzhiquyuPhoto;


    /**
     * 养殖区域地点
     */
    @ColumnInfo(comment="养殖区域地点",type="varchar(200)")
    @TableField(value = "yangzhiquyu_address")

    private String yangzhiquyuAddress;


    /**
     * 养殖区域类型
     */
    @ColumnInfo(comment="养殖区域类型",type="int(11)")
    @TableField(value = "yangzhiquyu_types")

    private Integer yangzhiquyuTypes;


    /**
     * 养殖区域介绍
     */
    @ColumnInfo(comment="养殖区域介绍",type="longtext")
    @TableField(value = "yangzhiquyu_content")

    private String yangzhiquyuContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：区域名称
	 */
    public String getYangzhiquyuName() {
        return yangzhiquyuName;
    }
    /**
	 * 设置：区域名称
	 */

    public void setYangzhiquyuName(String yangzhiquyuName) {
        this.yangzhiquyuName = yangzhiquyuName;
    }
    /**
	 * 获取：养殖区域编号
	 */
    public String getYangzhiquyuUuidNumber() {
        return yangzhiquyuUuidNumber;
    }
    /**
	 * 设置：养殖区域编号
	 */

    public void setYangzhiquyuUuidNumber(String yangzhiquyuUuidNumber) {
        this.yangzhiquyuUuidNumber = yangzhiquyuUuidNumber;
    }
    /**
	 * 获取：养殖区域照片
	 */
    public String getYangzhiquyuPhoto() {
        return yangzhiquyuPhoto;
    }
    /**
	 * 设置：养殖区域照片
	 */

    public void setYangzhiquyuPhoto(String yangzhiquyuPhoto) {
        this.yangzhiquyuPhoto = yangzhiquyuPhoto;
    }
    /**
	 * 获取：养殖区域地点
	 */
    public String getYangzhiquyuAddress() {
        return yangzhiquyuAddress;
    }
    /**
	 * 设置：养殖区域地点
	 */

    public void setYangzhiquyuAddress(String yangzhiquyuAddress) {
        this.yangzhiquyuAddress = yangzhiquyuAddress;
    }
    /**
	 * 获取：养殖区域类型
	 */
    public Integer getYangzhiquyuTypes() {
        return yangzhiquyuTypes;
    }
    /**
	 * 设置：养殖区域类型
	 */

    public void setYangzhiquyuTypes(Integer yangzhiquyuTypes) {
        this.yangzhiquyuTypes = yangzhiquyuTypes;
    }
    /**
	 * 获取：养殖区域介绍
	 */
    public String getYangzhiquyuContent() {
        return yangzhiquyuContent;
    }
    /**
	 * 设置：养殖区域介绍
	 */

    public void setYangzhiquyuContent(String yangzhiquyuContent) {
        this.yangzhiquyuContent = yangzhiquyuContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yangzhiquyu{" +
            ", id=" + id +
            ", yangzhiquyuName=" + yangzhiquyuName +
            ", yangzhiquyuUuidNumber=" + yangzhiquyuUuidNumber +
            ", yangzhiquyuPhoto=" + yangzhiquyuPhoto +
            ", yangzhiquyuAddress=" + yangzhiquyuAddress +
            ", yangzhiquyuTypes=" + yangzhiquyuTypes +
            ", yangzhiquyuContent=" + yangzhiquyuContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
