package com.entity.vo;

import com.entity.SiliaoShiyongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 饲料使用
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("siliao_shiyong")
public class SiliaoShiyongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 饲料
     */

    @TableField(value = "siliao_id")
    private Integer siliaoId;


    /**
     * 水产
     */

    @TableField(value = "shuichan_id")
    private Integer shuichanId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 使用数量
     */

    @TableField(value = "siliao_shiyong_number")
    private Integer siliaoShiyongNumber;


    /**
     * 使用类型
     */

    @TableField(value = "siliao_shiyong_types")
    private Integer siliaoShiyongTypes;


    /**
     * 使用缘由
     */

    @TableField(value = "siliao_shiyong_content")
    private String siliaoShiyongContent;


    /**
     * 附件
     */

    @TableField(value = "siliao_shiyong_file")
    private String siliaoShiyongFile;


    /**
     * 使用时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "siliao_shiyong_time")
    private Date siliaoShiyongTime;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：饲料
	 */
    public Integer getSiliaoId() {
        return siliaoId;
    }


    /**
	 * 获取：饲料
	 */

    public void setSiliaoId(Integer siliaoId) {
        this.siliaoId = siliaoId;
    }
    /**
	 * 设置：水产
	 */
    public Integer getShuichanId() {
        return shuichanId;
    }


    /**
	 * 获取：水产
	 */

    public void setShuichanId(Integer shuichanId) {
        this.shuichanId = shuichanId;
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
	 * 设置：使用数量
	 */
    public Integer getSiliaoShiyongNumber() {
        return siliaoShiyongNumber;
    }


    /**
	 * 获取：使用数量
	 */

    public void setSiliaoShiyongNumber(Integer siliaoShiyongNumber) {
        this.siliaoShiyongNumber = siliaoShiyongNumber;
    }
    /**
	 * 设置：使用类型
	 */
    public Integer getSiliaoShiyongTypes() {
        return siliaoShiyongTypes;
    }


    /**
	 * 获取：使用类型
	 */

    public void setSiliaoShiyongTypes(Integer siliaoShiyongTypes) {
        this.siliaoShiyongTypes = siliaoShiyongTypes;
    }
    /**
	 * 设置：使用缘由
	 */
    public String getSiliaoShiyongContent() {
        return siliaoShiyongContent;
    }


    /**
	 * 获取：使用缘由
	 */

    public void setSiliaoShiyongContent(String siliaoShiyongContent) {
        this.siliaoShiyongContent = siliaoShiyongContent;
    }
    /**
	 * 设置：附件
	 */
    public String getSiliaoShiyongFile() {
        return siliaoShiyongFile;
    }


    /**
	 * 获取：附件
	 */

    public void setSiliaoShiyongFile(String siliaoShiyongFile) {
        this.siliaoShiyongFile = siliaoShiyongFile;
    }
    /**
	 * 设置：使用时间
	 */
    public Date getSiliaoShiyongTime() {
        return siliaoShiyongTime;
    }


    /**
	 * 获取：使用时间
	 */

    public void setSiliaoShiyongTime(Date siliaoShiyongTime) {
        this.siliaoShiyongTime = siliaoShiyongTime;
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
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
