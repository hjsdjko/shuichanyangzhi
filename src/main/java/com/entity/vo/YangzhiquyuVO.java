package com.entity.vo;

import com.entity.YangzhiquyuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 养殖区域
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yangzhiquyu")
public class YangzhiquyuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 区域名称
     */

    @TableField(value = "yangzhiquyu_name")
    private String yangzhiquyuName;


    /**
     * 养殖区域编号
     */

    @TableField(value = "yangzhiquyu_uuid_number")
    private String yangzhiquyuUuidNumber;


    /**
     * 养殖区域照片
     */

    @TableField(value = "yangzhiquyu_photo")
    private String yangzhiquyuPhoto;


    /**
     * 养殖区域地点
     */

    @TableField(value = "yangzhiquyu_address")
    private String yangzhiquyuAddress;


    /**
     * 养殖区域类型
     */

    @TableField(value = "yangzhiquyu_types")
    private Integer yangzhiquyuTypes;


    /**
     * 养殖区域介绍
     */

    @TableField(value = "yangzhiquyu_content")
    private String yangzhiquyuContent;


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
	 * 设置：区域名称
	 */
    public String getYangzhiquyuName() {
        return yangzhiquyuName;
    }


    /**
	 * 获取：区域名称
	 */

    public void setYangzhiquyuName(String yangzhiquyuName) {
        this.yangzhiquyuName = yangzhiquyuName;
    }
    /**
	 * 设置：养殖区域编号
	 */
    public String getYangzhiquyuUuidNumber() {
        return yangzhiquyuUuidNumber;
    }


    /**
	 * 获取：养殖区域编号
	 */

    public void setYangzhiquyuUuidNumber(String yangzhiquyuUuidNumber) {
        this.yangzhiquyuUuidNumber = yangzhiquyuUuidNumber;
    }
    /**
	 * 设置：养殖区域照片
	 */
    public String getYangzhiquyuPhoto() {
        return yangzhiquyuPhoto;
    }


    /**
	 * 获取：养殖区域照片
	 */

    public void setYangzhiquyuPhoto(String yangzhiquyuPhoto) {
        this.yangzhiquyuPhoto = yangzhiquyuPhoto;
    }
    /**
	 * 设置：养殖区域地点
	 */
    public String getYangzhiquyuAddress() {
        return yangzhiquyuAddress;
    }


    /**
	 * 获取：养殖区域地点
	 */

    public void setYangzhiquyuAddress(String yangzhiquyuAddress) {
        this.yangzhiquyuAddress = yangzhiquyuAddress;
    }
    /**
	 * 设置：养殖区域类型
	 */
    public Integer getYangzhiquyuTypes() {
        return yangzhiquyuTypes;
    }


    /**
	 * 获取：养殖区域类型
	 */

    public void setYangzhiquyuTypes(Integer yangzhiquyuTypes) {
        this.yangzhiquyuTypes = yangzhiquyuTypes;
    }
    /**
	 * 设置：养殖区域介绍
	 */
    public String getYangzhiquyuContent() {
        return yangzhiquyuContent;
    }


    /**
	 * 获取：养殖区域介绍
	 */

    public void setYangzhiquyuContent(String yangzhiquyuContent) {
        this.yangzhiquyuContent = yangzhiquyuContent;
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
