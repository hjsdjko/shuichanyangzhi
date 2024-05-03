package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YangzhiquyuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 养殖区域
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yangzhiquyu")
public class YangzhiquyuView extends YangzhiquyuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 养殖区域类型的值
	*/
	@ColumnInfo(comment="养殖区域类型的字典表值",type="varchar(200)")
	private String yangzhiquyuValue;




	public YangzhiquyuView() {

	}

	public YangzhiquyuView(YangzhiquyuEntity yangzhiquyuEntity) {
		try {
			BeanUtils.copyProperties(this, yangzhiquyuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 养殖区域类型的值
	*/
	public String getYangzhiquyuValue() {
		return yangzhiquyuValue;
	}
	/**
	* 设置： 养殖区域类型的值
	*/
	public void setYangzhiquyuValue(String yangzhiquyuValue) {
		this.yangzhiquyuValue = yangzhiquyuValue;
	}




	@Override
	public String toString() {
		return "YangzhiquyuView{" +
			", yangzhiquyuValue=" + yangzhiquyuValue +
			"} " + super.toString();
	}
}
