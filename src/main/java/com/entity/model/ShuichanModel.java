package com.entity.model;

import com.entity.ShuichanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 水产
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShuichanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 养殖区域
     */
    private Integer yangzhiquyuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 水产名称
     */
    private String shuichanName;


    /**
     * 水产编号
     */
    private String shuichanUuidNumber;


    /**
     * 水产照片
     */
    private String shuichanPhoto;


    /**
     * 水产附件
     */
    private String shuichanFile;


    /**
     * 水产类型
     */
    private Integer shuichanTypes;


    /**
     * 养殖数量
     */
    private Integer shuichanNumber;


    /**
     * 投放日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date toufangTime;


    /**
     * 捞出日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date laochuTime;


    /**
     * 水产介绍
     */
    private String shuichanContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
