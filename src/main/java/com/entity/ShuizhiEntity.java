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
 * 水质
 *
 * @author 
 * @email
 */
@TableName("shuizhi")
public class ShuizhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShuizhiEntity() {

	}

	public ShuizhiEntity(T t) {
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
     * 养殖区域
     */
    @ColumnInfo(comment="养殖区域",type="int(11)")
    @TableField(value = "yangzhiquyu_id")

    private Integer yangzhiquyuId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 水质编号
     */
    @ColumnInfo(comment="水质编号",type="varchar(200)")
    @TableField(value = "shuizhi_uuid_number")

    private String shuizhiUuidNumber;


    /**
     * 水质照片
     */
    @ColumnInfo(comment="水质照片",type="varchar(200)")
    @TableField(value = "shuizhi_photo")

    private String shuizhiPhoto;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "shuizhi_file")

    private String shuizhiFile;


    /**
     * 水质状态
     */
    @ColumnInfo(comment="水质状态",type="int(11)")
    @TableField(value = "shuizhi_types")

    private Integer shuizhiTypes;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="所属日期",type="date")
    @TableField(value = "shuizhi_time")

    private Date shuizhiTime;


    /**
     * 水质详情
     */
    @ColumnInfo(comment="水质详情",type="longtext")
    @TableField(value = "shuizhi_content")

    private String shuizhiContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上传时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
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
	 * 获取：养殖区域
	 */
    public Integer getYangzhiquyuId() {
        return yangzhiquyuId;
    }
    /**
	 * 设置：养殖区域
	 */

    public void setYangzhiquyuId(Integer yangzhiquyuId) {
        this.yangzhiquyuId = yangzhiquyuId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：水质编号
	 */
    public String getShuizhiUuidNumber() {
        return shuizhiUuidNumber;
    }
    /**
	 * 设置：水质编号
	 */

    public void setShuizhiUuidNumber(String shuizhiUuidNumber) {
        this.shuizhiUuidNumber = shuizhiUuidNumber;
    }
    /**
	 * 获取：水质照片
	 */
    public String getShuizhiPhoto() {
        return shuizhiPhoto;
    }
    /**
	 * 设置：水质照片
	 */

    public void setShuizhiPhoto(String shuizhiPhoto) {
        this.shuizhiPhoto = shuizhiPhoto;
    }
    /**
	 * 获取：附件
	 */
    public String getShuizhiFile() {
        return shuizhiFile;
    }
    /**
	 * 设置：附件
	 */

    public void setShuizhiFile(String shuizhiFile) {
        this.shuizhiFile = shuizhiFile;
    }
    /**
	 * 获取：水质状态
	 */
    public Integer getShuizhiTypes() {
        return shuizhiTypes;
    }
    /**
	 * 设置：水质状态
	 */

    public void setShuizhiTypes(Integer shuizhiTypes) {
        this.shuizhiTypes = shuizhiTypes;
    }
    /**
	 * 获取：所属日期
	 */
    public Date getShuizhiTime() {
        return shuizhiTime;
    }
    /**
	 * 设置：所属日期
	 */

    public void setShuizhiTime(Date shuizhiTime) {
        this.shuizhiTime = shuizhiTime;
    }
    /**
	 * 获取：水质详情
	 */
    public String getShuizhiContent() {
        return shuizhiContent;
    }
    /**
	 * 设置：水质详情
	 */

    public void setShuizhiContent(String shuizhiContent) {
        this.shuizhiContent = shuizhiContent;
    }
    /**
	 * 获取：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：上传时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shuizhi{" +
            ", id=" + id +
            ", yangzhiquyuId=" + yangzhiquyuId +
            ", yonghuId=" + yonghuId +
            ", shuizhiUuidNumber=" + shuizhiUuidNumber +
            ", shuizhiPhoto=" + shuizhiPhoto +
            ", shuizhiFile=" + shuizhiFile +
            ", shuizhiTypes=" + shuizhiTypes +
            ", shuizhiTime=" + DateUtil.convertString(shuizhiTime,"yyyy-MM-dd") +
            ", shuizhiContent=" + shuizhiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
