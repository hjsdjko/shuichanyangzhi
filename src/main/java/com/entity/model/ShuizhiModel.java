package com.entity.model;

import com.entity.ShuizhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 水质
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShuizhiModel implements Serializable {
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
     * 水质编号
     */
    private String shuizhiUuidNumber;


    /**
     * 水质照片
     */
    private String shuizhiPhoto;


    /**
     * 附件
     */
    private String shuizhiFile;


    /**
     * 水质状态
     */
    private Integer shuizhiTypes;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shuizhiTime;


    /**
     * 水质详情
     */
    private String shuizhiContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
