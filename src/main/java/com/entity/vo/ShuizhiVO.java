package com.entity.vo;

import com.entity.ShuizhiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 水质
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shuizhi")
public class ShuizhiVO implements Serializable {
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
     * 水质编号
     */

    @TableField(value = "shuizhi_uuid_number")
    private String shuizhiUuidNumber;


    /**
     * 水质照片
     */

    @TableField(value = "shuizhi_photo")
    private String shuizhiPhoto;


    /**
     * 附件
     */

    @TableField(value = "shuizhi_file")
    private String shuizhiFile;


    /**
     * 水质状态
     */

    @TableField(value = "shuizhi_types")
    private Integer shuizhiTypes;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shuizhi_time")
    private Date shuizhiTime;


    /**
     * 水质详情
     */

    @TableField(value = "shuizhi_content")
    private String shuizhiContent;


    /**
     * 上传时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：水质编号
	 */
    public String getShuizhiUuidNumber() {
        return shuizhiUuidNumber;
    }


    /**
	 * 获取：水质编号
	 */

    public void setShuizhiUuidNumber(String shuizhiUuidNumber) {
        this.shuizhiUuidNumber = shuizhiUuidNumber;
    }
    /**
	 * 设置：水质照片
	 */
    public String getShuizhiPhoto() {
        return shuizhiPhoto;
    }


    /**
	 * 获取：水质照片
	 */

    public void setShuizhiPhoto(String shuizhiPhoto) {
        this.shuizhiPhoto = shuizhiPhoto;
    }
    /**
	 * 设置：附件
	 */
    public String getShuizhiFile() {
        return shuizhiFile;
    }


    /**
	 * 获取：附件
	 */

    public void setShuizhiFile(String shuizhiFile) {
        this.shuizhiFile = shuizhiFile;
    }
    /**
	 * 设置：水质状态
	 */
    public Integer getShuizhiTypes() {
        return shuizhiTypes;
    }


    /**
	 * 获取：水质状态
	 */

    public void setShuizhiTypes(Integer shuizhiTypes) {
        this.shuizhiTypes = shuizhiTypes;
    }
    /**
	 * 设置：所属日期
	 */
    public Date getShuizhiTime() {
        return shuizhiTime;
    }


    /**
	 * 获取：所属日期
	 */

    public void setShuizhiTime(Date shuizhiTime) {
        this.shuizhiTime = shuizhiTime;
    }
    /**
	 * 设置：水质详情
	 */
    public String getShuizhiContent() {
        return shuizhiContent;
    }


    /**
	 * 获取：水质详情
	 */

    public void setShuizhiContent(String shuizhiContent) {
        this.shuizhiContent = shuizhiContent;
    }
    /**
	 * 设置：上传时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：上传时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
