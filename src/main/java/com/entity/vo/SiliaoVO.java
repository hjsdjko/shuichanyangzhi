package com.entity.vo;

import com.entity.SiliaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 饲料
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("siliao")
public class SiliaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 饲料编号
     */

    @TableField(value = "siliao_uuid_number")
    private String siliaoUuidNumber;


    /**
     * 饲料名称
     */

    @TableField(value = "siliao_name")
    private String siliaoName;


    /**
     * 饲料照片
     */

    @TableField(value = "siliao_photo")
    private String siliaoPhoto;


    /**
     * 附件
     */

    @TableField(value = "siliao_file")
    private String siliaoFile;


    /**
     * 数量
     */

    @TableField(value = "siliao_number")
    private Integer siliaoNumber;


    /**
     * 单位
     */

    @TableField(value = "siliao_danwei")
    private String siliaoDanwei;


    /**
     * 饲料类型
     */

    @TableField(value = "siliao_types")
    private Integer siliaoTypes;


    /**
     * 饲料介绍
     */

    @TableField(value = "siliao_content")
    private String siliaoContent;


    /**
     * 录入时间
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
	 * 设置：饲料编号
	 */
    public String getSiliaoUuidNumber() {
        return siliaoUuidNumber;
    }


    /**
	 * 获取：饲料编号
	 */

    public void setSiliaoUuidNumber(String siliaoUuidNumber) {
        this.siliaoUuidNumber = siliaoUuidNumber;
    }
    /**
	 * 设置：饲料名称
	 */
    public String getSiliaoName() {
        return siliaoName;
    }


    /**
	 * 获取：饲料名称
	 */

    public void setSiliaoName(String siliaoName) {
        this.siliaoName = siliaoName;
    }
    /**
	 * 设置：饲料照片
	 */
    public String getSiliaoPhoto() {
        return siliaoPhoto;
    }


    /**
	 * 获取：饲料照片
	 */

    public void setSiliaoPhoto(String siliaoPhoto) {
        this.siliaoPhoto = siliaoPhoto;
    }
    /**
	 * 设置：附件
	 */
    public String getSiliaoFile() {
        return siliaoFile;
    }


    /**
	 * 获取：附件
	 */

    public void setSiliaoFile(String siliaoFile) {
        this.siliaoFile = siliaoFile;
    }
    /**
	 * 设置：数量
	 */
    public Integer getSiliaoNumber() {
        return siliaoNumber;
    }


    /**
	 * 获取：数量
	 */

    public void setSiliaoNumber(Integer siliaoNumber) {
        this.siliaoNumber = siliaoNumber;
    }
    /**
	 * 设置：单位
	 */
    public String getSiliaoDanwei() {
        return siliaoDanwei;
    }


    /**
	 * 获取：单位
	 */

    public void setSiliaoDanwei(String siliaoDanwei) {
        this.siliaoDanwei = siliaoDanwei;
    }
    /**
	 * 设置：饲料类型
	 */
    public Integer getSiliaoTypes() {
        return siliaoTypes;
    }


    /**
	 * 获取：饲料类型
	 */

    public void setSiliaoTypes(Integer siliaoTypes) {
        this.siliaoTypes = siliaoTypes;
    }
    /**
	 * 设置：饲料介绍
	 */
    public String getSiliaoContent() {
        return siliaoContent;
    }


    /**
	 * 获取：饲料介绍
	 */

    public void setSiliaoContent(String siliaoContent) {
        this.siliaoContent = siliaoContent;
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
