package com.entity.model;

import com.entity.SiliaoShiyongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 饲料使用
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SiliaoShiyongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 饲料
     */
    private Integer siliaoId;


    /**
     * 水产
     */
    private Integer shuichanId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 使用数量
     */
    private Integer siliaoShiyongNumber;


    /**
     * 使用类型
     */
    private Integer siliaoShiyongTypes;


    /**
     * 使用缘由
     */
    private String siliaoShiyongContent;


    /**
     * 附件
     */
    private String siliaoShiyongFile;


    /**
     * 使用时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date siliaoShiyongTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
