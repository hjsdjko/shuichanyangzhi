package com.entity.vo;

import com.entity.ShuichanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 水产
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shuichan")
public class ShuichanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 养殖区域
     */

    @TableField(value = "yangzhiquyu_id")
    private Integer yangzhiquyuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 水产名称
     */

    @TableField(value = "shuichan_name")
    private String shuichanName;


    /**
     * 水产编号
     */

    @TableField(value = "shuichan_uuid_number")
    private String shuichanUuidNumber;


    /**
     * 水产照片
     */

    @TableField(value = "shuichan_photo")
    private String shuichanPhoto;


    /**
     * 水产附件
     */

    @TableField(value = "shuichan_file")
    private String shuichanFile;


    /**
     * 水产类型
     */

    @TableField(value = "shuichan_types")
    private Integer shuichanTypes;


    /**
     * 养殖数量
     */

    @TableField(value = "shuichan_number")
    private Integer shuichanNumber;


    /**
     * 投放日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "toufang_time")
    private Date toufangTime;


    /**
     * 捞出日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "laochu_time")
    private Date laochuTime;


    /**
     * 水产介绍
     */

    @TableField(value = "shuichan_content")
    private String shuichanContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：养殖区域
	 */
    public Integer getYangzhiquyuId() {
        return yangzhiquyuId;
    }


    /**
	 * 获取：养殖区域
	 */

    public void setYangzhiquyuId(Integer yangzhiquyuId) {
        this.yangzhiquyuId = yangzhiquyuId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：水产名称
	 */
    public String getShuichanName() {
        return shuichanName;
    }


    /**
	 * 获取：水产名称
	 */

    public void setShuichanName(String shuichanName) {
        this.shuichanName = shuichanName;
    }
    /**
	 * 设置：水产编号
	 */
    public String getShuichanUuidNumber() {
        return shuichanUuidNumber;
    }


    /**
	 * 获取：水产编号
	 */

    public void setShuichanUuidNumber(String shuichanUuidNumber) {
        this.shuichanUuidNumber = shuichanUuidNumber;
    }
    /**
	 * 设置：水产照片
	 */
    public String getShuichanPhoto() {
        return shuichanPhoto;
    }


    /**
	 * 获取：水产照片
	 */

    public void setShuichanPhoto(String shuichanPhoto) {
        this.shuichanPhoto = shuichanPhoto;
    }
    /**
	 * 设置：水产附件
	 */
    public String getShuichanFile() {
        return shuichanFile;
    }


    /**
	 * 获取：水产附件
	 */

    public void setShuichanFile(String shuichanFile) {
        this.shuichanFile = shuichanFile;
    }
    /**
	 * 设置：水产类型
	 */
    public Integer getShuichanTypes() {
        return shuichanTypes;
    }


    /**
	 * 获取：水产类型
	 */

    public void setShuichanTypes(Integer shuichanTypes) {
        this.shuichanTypes = shuichanTypes;
    }
    /**
	 * 设置：养殖数量
	 */
    public Integer getShuichanNumber() {
        return shuichanNumber;
    }


    /**
	 * 获取：养殖数量
	 */

    public void setShuichanNumber(Integer shuichanNumber) {
        this.shuichanNumber = shuichanNumber;
    }
    /**
	 * 设置：投放日期
	 */
    public Date getToufangTime() {
        return toufangTime;
    }


    /**
	 * 获取：投放日期
	 */

    public void setToufangTime(Date toufangTime) {
        this.toufangTime = toufangTime;
    }
    /**
	 * 设置：捞出日期
	 */
    public Date getLaochuTime() {
        return laochuTime;
    }


    /**
	 * 获取：捞出日期
	 */

    public void setLaochuTime(Date laochuTime) {
        this.laochuTime = laochuTime;
    }
    /**
	 * 设置：水产介绍
	 */
    public String getShuichanContent() {
        return shuichanContent;
    }


    /**
	 * 获取：水产介绍
	 */

    public void setShuichanContent(String shuichanContent) {
        this.shuichanContent = shuichanContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
