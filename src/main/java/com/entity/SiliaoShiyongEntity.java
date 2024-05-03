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
 * 饲料使用
 *
 * @author 
 * @email
 */
@TableName("siliao_shiyong")
public class SiliaoShiyongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SiliaoShiyongEntity() {

	}

	public SiliaoShiyongEntity(T t) {
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
     * 饲料
     */
    @ColumnInfo(comment="饲料",type="int(11)")
    @TableField(value = "siliao_id")

    private Integer siliaoId;


    /**
     * 水产
     */
    @ColumnInfo(comment="水产",type="int(11)")
    @TableField(value = "shuichan_id")

    private Integer shuichanId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 使用数量
     */
    @ColumnInfo(comment="使用数量",type="int(11)")
    @TableField(value = "siliao_shiyong_number")

    private Integer siliaoShiyongNumber;


    /**
     * 使用类型
     */
    @ColumnInfo(comment="使用类型",type="int(11)")
    @TableField(value = "siliao_shiyong_types")

    private Integer siliaoShiyongTypes;


    /**
     * 使用缘由
     */
    @ColumnInfo(comment="使用缘由",type="longtext")
    @TableField(value = "siliao_shiyong_content")

    private String siliaoShiyongContent;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "siliao_shiyong_file")

    private String siliaoShiyongFile;


    /**
     * 使用时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="使用时间",type="timestamp")
    @TableField(value = "siliao_shiyong_time")

    private Date siliaoShiyongTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：饲料
	 */
    public Integer getSiliaoId() {
        return siliaoId;
    }
    /**
	 * 设置：饲料
	 */

    public void setSiliaoId(Integer siliaoId) {
        this.siliaoId = siliaoId;
    }
    /**
	 * 获取：水产
	 */
    public Integer getShuichanId() {
        return shuichanId;
    }
    /**
	 * 设置：水产
	 */

    public void setShuichanId(Integer shuichanId) {
        this.shuichanId = shuichanId;
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
	 * 获取：使用数量
	 */
    public Integer getSiliaoShiyongNumber() {
        return siliaoShiyongNumber;
    }
    /**
	 * 设置：使用数量
	 */

    public void setSiliaoShiyongNumber(Integer siliaoShiyongNumber) {
        this.siliaoShiyongNumber = siliaoShiyongNumber;
    }
    /**
	 * 获取：使用类型
	 */
    public Integer getSiliaoShiyongTypes() {
        return siliaoShiyongTypes;
    }
    /**
	 * 设置：使用类型
	 */

    public void setSiliaoShiyongTypes(Integer siliaoShiyongTypes) {
        this.siliaoShiyongTypes = siliaoShiyongTypes;
    }
    /**
	 * 获取：使用缘由
	 */
    public String getSiliaoShiyongContent() {
        return siliaoShiyongContent;
    }
    /**
	 * 设置：使用缘由
	 */

    public void setSiliaoShiyongContent(String siliaoShiyongContent) {
        this.siliaoShiyongContent = siliaoShiyongContent;
    }
    /**
	 * 获取：附件
	 */
    public String getSiliaoShiyongFile() {
        return siliaoShiyongFile;
    }
    /**
	 * 设置：附件
	 */

    public void setSiliaoShiyongFile(String siliaoShiyongFile) {
        this.siliaoShiyongFile = siliaoShiyongFile;
    }
    /**
	 * 获取：使用时间
	 */
    public Date getSiliaoShiyongTime() {
        return siliaoShiyongTime;
    }
    /**
	 * 设置：使用时间
	 */

    public void setSiliaoShiyongTime(Date siliaoShiyongTime) {
        this.siliaoShiyongTime = siliaoShiyongTime;
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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SiliaoShiyong{" +
            ", id=" + id +
            ", siliaoId=" + siliaoId +
            ", shuichanId=" + shuichanId +
            ", yonghuId=" + yonghuId +
            ", siliaoShiyongNumber=" + siliaoShiyongNumber +
            ", siliaoShiyongTypes=" + siliaoShiyongTypes +
            ", siliaoShiyongContent=" + siliaoShiyongContent +
            ", siliaoShiyongFile=" + siliaoShiyongFile +
            ", siliaoShiyongTime=" + DateUtil.convertString(siliaoShiyongTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
