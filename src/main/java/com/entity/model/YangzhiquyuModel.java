package com.entity.model;

import com.entity.YangzhiquyuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 养殖区域
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YangzhiquyuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 区域名称
     */
    private String yangzhiquyuName;


    /**
     * 养殖区域编号
     */
    private String yangzhiquyuUuidNumber;


    /**
     * 养殖区域照片
     */
    private String yangzhiquyuPhoto;


    /**
     * 养殖区域地点
     */
    private String yangzhiquyuAddress;


    /**
     * 养殖区域类型
     */
    private Integer yangzhiquyuTypes;


    /**
     * 养殖区域介绍
     */
    private String yangzhiquyuContent;


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
