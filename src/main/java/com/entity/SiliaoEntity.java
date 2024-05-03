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
 * 饲料
 *
 * @author 
 * @email
 */
@TableName("siliao")
public class SiliaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SiliaoEntity() {

	}

	public SiliaoEntity(T t) {
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
     * 饲料编号
     */
    @ColumnInfo(comment="饲料编号",type="varchar(200)")
    @TableField(value = "siliao_uuid_number")

    private String siliaoUuidNumber;


    /**
     * 饲料名称
     */
    @ColumnInfo(comment="饲料名称",type="varchar(200)")
    @TableField(value = "siliao_name")

    private String siliaoName;


    /**
     * 饲料照片
     */
    @ColumnInfo(comment="饲料照片",type="varchar(200)")
    @TableField(value = "siliao_photo")

    private String siliaoPhoto;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "siliao_file")

    private String siliaoFile;


    /**
     * 数量
     */
    @ColumnInfo(comment="数量",type="int(11)")
    @TableField(value = "siliao_number")

    private Integer siliaoNumber;


    /**
     * 单位
     */
    @ColumnInfo(comment="单位",type="varchar(200)")
    @TableField(value = "siliao_danwei")

    private String siliaoDanwei;


    /**
     * 饲料类型
     */
    @ColumnInfo(comment="饲料类型",type="int(11)")
    @TableField(value = "siliao_types")

    private Integer siliaoTypes;


    /**
     * 饲料介绍
     */
    @ColumnInfo(comment="饲料介绍",type="longtext")
    @TableField(value = "siliao_content")

    private String siliaoContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
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
	 * 获取：饲料编号
	 */
    public String getSiliaoUuidNumber() {
        return siliaoUuidNumber;
    }
    /**
	 * 设置：饲料编号
	 */

    public void setSiliaoUuidNumber(String siliaoUuidNumber) {
        this.siliaoUuidNumber = siliaoUuidNumber;
    }
    /**
	 * 获取：饲料名称
	 */
    public String getSiliaoName() {
        return siliaoName;
    }
    /**
	 * 设置：饲料名称
	 */

    public void setSiliaoName(String siliaoName) {
        this.siliaoName = siliaoName;
    }
    /**
	 * 获取：饲料照片
	 */
    public String getSiliaoPhoto() {
        return siliaoPhoto;
    }
    /**
	 * 设置：饲料照片
	 */

    public void setSiliaoPhoto(String siliaoPhoto) {
        this.siliaoPhoto = siliaoPhoto;
    }
    /**
	 * 获取：附件
	 */
    public String getSiliaoFile() {
        return siliaoFile;
    }
    /**
	 * 设置：附件
	 */

    public void setSiliaoFile(String siliaoFile) {
        this.siliaoFile = siliaoFile;
    }
    /**
	 * 获取：数量
	 */
    public Integer getSiliaoNumber() {
        return siliaoNumber;
    }
    /**
	 * 设置：数量
	 */

    public void setSiliaoNumber(Integer siliaoNumber) {
        this.siliaoNumber = siliaoNumber;
    }
    /**
	 * 获取：单位
	 */
    public String getSiliaoDanwei() {
        return siliaoDanwei;
    }
    /**
	 * 设置：单位
	 */

    public void setSiliaoDanwei(String siliaoDanwei) {
        this.siliaoDanwei = siliaoDanwei;
    }
    /**
	 * 获取：饲料类型
	 */
    public Integer getSiliaoTypes() {
        return siliaoTypes;
    }
    /**
	 * 设置：饲料类型
	 */

    public void setSiliaoTypes(Integer siliaoTypes) {
        this.siliaoTypes = siliaoTypes;
    }
    /**
	 * 获取：饲料介绍
	 */
    public String getSiliaoContent() {
        return siliaoContent;
    }
    /**
	 * 设置：饲料介绍
	 */

    public void setSiliaoContent(String siliaoContent) {
        this.siliaoContent = siliaoContent;
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
        return "Siliao{" +
            ", id=" + id +
            ", siliaoUuidNumber=" + siliaoUuidNumber +
            ", siliaoName=" + siliaoName +
            ", siliaoPhoto=" + siliaoPhoto +
            ", siliaoFile=" + siliaoFile +
            ", siliaoNumber=" + siliaoNumber +
            ", siliaoDanwei=" + siliaoDanwei +
            ", siliaoTypes=" + siliaoTypes +
            ", siliaoContent=" + siliaoContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
