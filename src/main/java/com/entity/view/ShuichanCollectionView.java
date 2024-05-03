package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShuichanCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 水产收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shuichan_collection")
public class ShuichanCollectionView extends ShuichanCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String shuichanCollectionValue;

	//级联表 水产
										 
		/**
		* 水产 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer shuichanYonghuId;
		/**
		* 水产名称
		*/

		@ColumnInfo(comment="水产名称",type="varchar(200)")
		private String shuichanName;
		/**
		* 水产编号
		*/

		@ColumnInfo(comment="水产编号",type="varchar(200)")
		private String shuichanUuidNumber;
		/**
		* 水产照片
		*/

		@ColumnInfo(comment="水产照片",type="varchar(200)")
		private String shuichanPhoto;
		/**
		* 水产附件
		*/

		@ColumnInfo(comment="水产附件",type="varchar(200)")
		private String shuichanFile;
		/**
		* 水产类型
		*/
		@ColumnInfo(comment="水产类型",type="int(11)")
		private Integer shuichanTypes;
			/**
			* 水产类型的值
			*/
			@ColumnInfo(comment="水产类型的字典表值",type="varchar(200)")
			private String shuichanValue;
		/**
		* 养殖数量
		*/

		@ColumnInfo(comment="养殖数量",type="int(11)")
		private Integer shuichanNumber;
		/**
		* 投放日期
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="投放日期",type="timestamp")
		private Date toufangTime;
		/**
		* 捞出日期
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="捞出日期",type="timestamp")
		private Date laochuTime;
		/**
		* 水产介绍
		*/

		@ColumnInfo(comment="水产介绍",type="longtext")
		private String shuichanContent;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;



	public ShuichanCollectionView() {

	}

	public ShuichanCollectionView(ShuichanCollectionEntity shuichanCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, shuichanCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getShuichanCollectionValue() {
		return shuichanCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setShuichanCollectionValue(String shuichanCollectionValue) {
		this.shuichanCollectionValue = shuichanCollectionValue;
	}


	//级联表的get和set 水产
		/**
		* 获取：水产 的 用户
		*/
		public Integer getShuichanYonghuId() {
			return shuichanYonghuId;
		}
		/**
		* 设置：水产 的 用户
		*/
		public void setShuichanYonghuId(Integer shuichanYonghuId) {
			this.shuichanYonghuId = shuichanYonghuId;
		}

		/**
		* 获取： 水产名称
		*/
		public String getShuichanName() {
			return shuichanName;
		}
		/**
		* 设置： 水产名称
		*/
		public void setShuichanName(String shuichanName) {
			this.shuichanName = shuichanName;
		}

		/**
		* 获取： 水产编号
		*/
		public String getShuichanUuidNumber() {
			return shuichanUuidNumber;
		}
		/**
		* 设置： 水产编号
		*/
		public void setShuichanUuidNumber(String shuichanUuidNumber) {
			this.shuichanUuidNumber = shuichanUuidNumber;
		}

		/**
		* 获取： 水产照片
		*/
		public String getShuichanPhoto() {
			return shuichanPhoto;
		}
		/**
		* 设置： 水产照片
		*/
		public void setShuichanPhoto(String shuichanPhoto) {
			this.shuichanPhoto = shuichanPhoto;
		}

		/**
		* 获取： 水产附件
		*/
		public String getShuichanFile() {
			return shuichanFile;
		}
		/**
		* 设置： 水产附件
		*/
		public void setShuichanFile(String shuichanFile) {
			this.shuichanFile = shuichanFile;
		}
		/**
		* 获取： 水产类型
		*/
		public Integer getShuichanTypes() {
			return shuichanTypes;
		}
		/**
		* 设置： 水产类型
		*/
		public void setShuichanTypes(Integer shuichanTypes) {
			this.shuichanTypes = shuichanTypes;
		}


			/**
			* 获取： 水产类型的值
			*/
			public String getShuichanValue() {
				return shuichanValue;
			}
			/**
			* 设置： 水产类型的值
			*/
			public void setShuichanValue(String shuichanValue) {
				this.shuichanValue = shuichanValue;
			}

		/**
		* 获取： 养殖数量
		*/
		public Integer getShuichanNumber() {
			return shuichanNumber;
		}
		/**
		* 设置： 养殖数量
		*/
		public void setShuichanNumber(Integer shuichanNumber) {
			this.shuichanNumber = shuichanNumber;
		}

		/**
		* 获取： 投放日期
		*/
		public Date getToufangTime() {
			return toufangTime;
		}
		/**
		* 设置： 投放日期
		*/
		public void setToufangTime(Date toufangTime) {
			this.toufangTime = toufangTime;
		}

		/**
		* 获取： 捞出日期
		*/
		public Date getLaochuTime() {
			return laochuTime;
		}
		/**
		* 设置： 捞出日期
		*/
		public void setLaochuTime(Date laochuTime) {
			this.laochuTime = laochuTime;
		}

		/**
		* 获取： 水产介绍
		*/
		public String getShuichanContent() {
			return shuichanContent;
		}
		/**
		* 设置： 水产介绍
		*/
		public void setShuichanContent(String shuichanContent) {
			this.shuichanContent = shuichanContent;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}


	@Override
	public String toString() {
		return "ShuichanCollectionView{" +
			", shuichanCollectionValue=" + shuichanCollectionValue +
			", shuichanName=" + shuichanName +
			", shuichanUuidNumber=" + shuichanUuidNumber +
			", shuichanPhoto=" + shuichanPhoto +
			", shuichanFile=" + shuichanFile +
			", shuichanNumber=" + shuichanNumber +
			", toufangTime=" + DateUtil.convertString(toufangTime,"yyyy-MM-dd") +
			", laochuTime=" + DateUtil.convertString(laochuTime,"yyyy-MM-dd") +
			", shuichanContent=" + shuichanContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
