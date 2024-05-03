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
 * 水产
 *
 * @author 
 * @email
 */
@TableName("shuichan")
public class ShuichanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShuichanEntity() {

	}

	public ShuichanEntity(T t) {
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
     * 水产名称
     */
    @ColumnInfo(comment="水产名称",type="varchar(200)")
    @TableField(value = "shuichan_name")

    private String shuichanName;


    /**
     * 水产编号
     */
    @ColumnInfo(comment="水产编号",type="varchar(200)")
    @TableField(value = "shuichan_uuid_number")

    private String shuichanUuidNumber;


    /**
     * 水产照片
     */
    @ColumnInfo(comment="水产照片",type="varchar(200)")
    @TableField(value = "shuichan_photo")

    private String shuichanPhoto;


    /**
     * 水产附件
     */
    @ColumnInfo(comment="水产附件",type="varchar(200)")
    @TableField(value = "shuichan_file")

    private String shuichanFile;


    /**
     * 水产类型
     */
    @ColumnInfo(comment="水产类型",type="int(11)")
    @TableField(value = "shuichan_types")

    private Integer shuichanTypes;


    /**
     * 养殖数量
     */
    @ColumnInfo(comment="养殖数量",type="int(11)")
    @TableField(value = "shuichan_number")

    private Integer shuichanNumber;


    /**
     * 投放日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="投放日期",type="timestamp")
    @TableField(value = "toufang_time")

    private Date toufangTime;


    /**
     * 捞出日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="捞出日期",type="timestamp")
    @TableField(value = "laochu_time")

    private Date laochuTime;


    /**
     * 水产介绍
     */
    @ColumnInfo(comment="水产介绍",type="longtext")
    @TableField(value = "shuichan_content")

    private String shuichanContent;


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
	 * 获取：水产名称
	 */
    public String getShuichanName() {
        return shuichanName;
    }
    /**
	 * 设置：水产名称
	 */

    public void setShuichanName(String shuichanName) {
        this.shuichanName = shuichanName;
    }
    /**
	 * 获取：水产编号
	 */
    public String getShuichanUuidNumber() {
        return shuichanUuidNumber;
    }
    /**
	 * 设置：水产编号
	 */

    public void setShuichanUuidNumber(String shuichanUuidNumber) {
        this.shuichanUuidNumber = shuichanUuidNumber;
    }
    /**
	 * 获取：水产照片
	 */
    public String getShuichanPhoto() {
        return shuichanPhoto;
    }
    /**
	 * 设置：水产照片
	 */

    public void setShuichanPhoto(String shuichanPhoto) {
        this.shuichanPhoto = shuichanPhoto;
    }
    /**
	 * 获取：水产附件
	 */
    public String getShuichanFile() {
        return shuichanFile;
    }
    /**
	 * 设置：水产附件
	 */

    public void setShuichanFile(String shuichanFile) {
        this.shuichanFile = shuichanFile;
    }
    /**
	 * 获取：水产类型
	 */
    public Integer getShuichanTypes() {
        return shuichanTypes;
    }
    /**
	 * 设置：水产类型
	 */

    public void setShuichanTypes(Integer shuichanTypes) {
        this.shuichanTypes = shuichanTypes;
    }
    /**
	 * 获取：养殖数量
	 */
    public Integer getShuichanNumber() {
        return shuichanNumber;
    }
    /**
	 * 设置：养殖数量
	 */

    public void setShuichanNumber(Integer shuichanNumber) {
        this.shuichanNumber = shuichanNumber;
    }
    /**
	 * 获取：投放日期
	 */
    public Date getToufangTime() {
        return toufangTime;
    }
    /**
	 * 设置：投放日期
	 */

    public void setToufangTime(Date toufangTime) {
        this.toufangTime = toufangTime;
    }
    /**
	 * 获取：捞出日期
	 */
    public Date getLaochuTime() {
        return laochuTime;
    }
    /**
	 * 设置：捞出日期
	 */

    public void setLaochuTime(Date laochuTime) {
        this.laochuTime = laochuTime;
    }
    /**
	 * 获取：水产介绍
	 */
    public String getShuichanContent() {
        return shuichanContent;
    }
    /**
	 * 设置：水产介绍
	 */

    public void setShuichanContent(String shuichanContent) {
        this.shuichanContent = shuichanContent;
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
        return "Shuichan{" +
            ", id=" + id +
            ", yangzhiquyuId=" + yangzhiquyuId +
            ", yonghuId=" + yonghuId +
            ", shuichanName=" + shuichanName +
            ", shuichanUuidNumber=" + shuichanUuidNumber +
            ", shuichanPhoto=" + shuichanPhoto +
            ", shuichanFile=" + shuichanFile +
            ", shuichanTypes=" + shuichanTypes +
            ", shuichanNumber=" + shuichanNumber +
            ", toufangTime=" + DateUtil.convertString(toufangTime,"yyyy-MM-dd") +
            ", laochuTime=" + DateUtil.convertString(laochuTime,"yyyy-MM-dd") +
            ", shuichanContent=" + shuichanContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
