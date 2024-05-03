package com.entity.model;

import com.entity.SiliaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 饲料
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SiliaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 饲料编号
     */
    private String siliaoUuidNumber;


    /**
     * 饲料名称
     */
    private String siliaoName;


    /**
     * 饲料照片
     */
    private String siliaoPhoto;


    /**
     * 附件
     */
    private String siliaoFile;


    /**
     * 数量
     */
    private Integer siliaoNumber;


    /**
     * 单位
     */
    private String siliaoDanwei;


    /**
     * 饲料类型
     */
    private Integer siliaoTypes;


    /**
     * 饲料介绍
     */
    private String siliaoContent;


    /**
     * 录入时间
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
