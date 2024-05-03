package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SiliaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 饲料
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("siliao")
public class SiliaoView extends SiliaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 饲料类型的值
	*/
	@ColumnInfo(comment="饲料类型的字典表值",type="varchar(200)")
	private String siliaoValue;




	public SiliaoView() {

	}

	public SiliaoView(SiliaoEntity siliaoEntity) {
		try {
			BeanUtils.copyProperties(this, siliaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 饲料类型的值
	*/
	public String getSiliaoValue() {
		return siliaoValue;
	}
	/**
	* 设置： 饲料类型的值
	*/
	public void setSiliaoValue(String siliaoValue) {
		this.siliaoValue = siliaoValue;
	}




	@Override
	public String toString() {
		return "SiliaoView{" +
			", siliaoValue=" + siliaoValue +
			"} " + super.toString();
	}
}
