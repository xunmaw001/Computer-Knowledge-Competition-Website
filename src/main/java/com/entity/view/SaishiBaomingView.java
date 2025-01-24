package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SaishiBaomingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 赛事报名
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("saishi_baoming")
public class SaishiBaomingView extends SaishiBaomingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String saishiBaomingValue;

	//级联表 评委
		/**
		* 评委编号
		*/

		@ColumnInfo(comment="评委编号",type="varchar(200)")
		private String pingweiUuidNumber;
		/**
		* 评委姓名
		*/

		@ColumnInfo(comment="评委姓名",type="varchar(200)")
		private String pingweiName;
		/**
		* 评委手机号
		*/

		@ColumnInfo(comment="评委手机号",type="varchar(200)")
		private String pingweiPhone;
		/**
		* 评委身份证号
		*/

		@ColumnInfo(comment="评委身份证号",type="varchar(200)")
		private String pingweiIdNumber;
		/**
		* 评委头像
		*/

		@ColumnInfo(comment="评委头像",type="varchar(200)")
		private String pingweiPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String pingweiEmail;
	//级联表 赛事
		/**
		* 赛事名称
		*/

		@ColumnInfo(comment="赛事名称",type="varchar(200)")
		private String saishiName;
		/**
		* 赛事编号
		*/

		@ColumnInfo(comment="赛事编号",type="varchar(200)")
		private String saishiUuidNumber;
		/**
		* 赛事照片
		*/

		@ColumnInfo(comment="赛事照片",type="varchar(200)")
		private String saishiPhoto;
		/**
		* 试题文件
		*/

		@ColumnInfo(comment="试题文件",type="varchar(200)")
		private String saishiFile;
		/**
		* 赛事类型
		*/
		@ColumnInfo(comment="赛事类型",type="int(11)")
		private Integer saishiTypes;
			/**
			* 赛事类型的值
			*/
			@ColumnInfo(comment="赛事类型的字典表值",type="varchar(200)")
			private String saishiValue;
		/**
		* 赛事开始时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="赛事开始时间",type="timestamp")
		private Date saishiKaishiTime;
		/**
		* 赛事结束时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="赛事结束时间",type="timestamp")
		private Date saishiJieshuTime;
		/**
		* 赛事热度
		*/

		@ColumnInfo(comment="赛事热度",type="int(11)")
		private Integer saishiClicknum;
		/**
		* 赛事介绍
		*/

		@ColumnInfo(comment="赛事介绍",type="text")
		private String saishiContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer saishiDelete;
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
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public SaishiBaomingView() {

	}

	public SaishiBaomingView(SaishiBaomingEntity saishiBaomingEntity) {
		try {
			BeanUtils.copyProperties(this, saishiBaomingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getSaishiBaomingValue() {
		return saishiBaomingValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setSaishiBaomingValue(String saishiBaomingValue) {
		this.saishiBaomingValue = saishiBaomingValue;
	}


	//级联表的get和set 评委

		/**
		* 获取： 评委编号
		*/
		public String getPingweiUuidNumber() {
			return pingweiUuidNumber;
		}
		/**
		* 设置： 评委编号
		*/
		public void setPingweiUuidNumber(String pingweiUuidNumber) {
			this.pingweiUuidNumber = pingweiUuidNumber;
		}

		/**
		* 获取： 评委姓名
		*/
		public String getPingweiName() {
			return pingweiName;
		}
		/**
		* 设置： 评委姓名
		*/
		public void setPingweiName(String pingweiName) {
			this.pingweiName = pingweiName;
		}

		/**
		* 获取： 评委手机号
		*/
		public String getPingweiPhone() {
			return pingweiPhone;
		}
		/**
		* 设置： 评委手机号
		*/
		public void setPingweiPhone(String pingweiPhone) {
			this.pingweiPhone = pingweiPhone;
		}

		/**
		* 获取： 评委身份证号
		*/
		public String getPingweiIdNumber() {
			return pingweiIdNumber;
		}
		/**
		* 设置： 评委身份证号
		*/
		public void setPingweiIdNumber(String pingweiIdNumber) {
			this.pingweiIdNumber = pingweiIdNumber;
		}

		/**
		* 获取： 评委头像
		*/
		public String getPingweiPhoto() {
			return pingweiPhoto;
		}
		/**
		* 设置： 评委头像
		*/
		public void setPingweiPhoto(String pingweiPhoto) {
			this.pingweiPhoto = pingweiPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getPingweiEmail() {
			return pingweiEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setPingweiEmail(String pingweiEmail) {
			this.pingweiEmail = pingweiEmail;
		}
	//级联表的get和set 赛事

		/**
		* 获取： 赛事名称
		*/
		public String getSaishiName() {
			return saishiName;
		}
		/**
		* 设置： 赛事名称
		*/
		public void setSaishiName(String saishiName) {
			this.saishiName = saishiName;
		}

		/**
		* 获取： 赛事编号
		*/
		public String getSaishiUuidNumber() {
			return saishiUuidNumber;
		}
		/**
		* 设置： 赛事编号
		*/
		public void setSaishiUuidNumber(String saishiUuidNumber) {
			this.saishiUuidNumber = saishiUuidNumber;
		}

		/**
		* 获取： 赛事照片
		*/
		public String getSaishiPhoto() {
			return saishiPhoto;
		}
		/**
		* 设置： 赛事照片
		*/
		public void setSaishiPhoto(String saishiPhoto) {
			this.saishiPhoto = saishiPhoto;
		}

		/**
		* 获取： 试题文件
		*/
		public String getSaishiFile() {
			return saishiFile;
		}
		/**
		* 设置： 试题文件
		*/
		public void setSaishiFile(String saishiFile) {
			this.saishiFile = saishiFile;
		}
		/**
		* 获取： 赛事类型
		*/
		public Integer getSaishiTypes() {
			return saishiTypes;
		}
		/**
		* 设置： 赛事类型
		*/
		public void setSaishiTypes(Integer saishiTypes) {
			this.saishiTypes = saishiTypes;
		}


			/**
			* 获取： 赛事类型的值
			*/
			public String getSaishiValue() {
				return saishiValue;
			}
			/**
			* 设置： 赛事类型的值
			*/
			public void setSaishiValue(String saishiValue) {
				this.saishiValue = saishiValue;
			}

		/**
		* 获取： 赛事开始时间
		*/
		public Date getSaishiKaishiTime() {
			return saishiKaishiTime;
		}
		/**
		* 设置： 赛事开始时间
		*/
		public void setSaishiKaishiTime(Date saishiKaishiTime) {
			this.saishiKaishiTime = saishiKaishiTime;
		}

		/**
		* 获取： 赛事结束时间
		*/
		public Date getSaishiJieshuTime() {
			return saishiJieshuTime;
		}
		/**
		* 设置： 赛事结束时间
		*/
		public void setSaishiJieshuTime(Date saishiJieshuTime) {
			this.saishiJieshuTime = saishiJieshuTime;
		}

		/**
		* 获取： 赛事热度
		*/
		public Integer getSaishiClicknum() {
			return saishiClicknum;
		}
		/**
		* 设置： 赛事热度
		*/
		public void setSaishiClicknum(Integer saishiClicknum) {
			this.saishiClicknum = saishiClicknum;
		}

		/**
		* 获取： 赛事介绍
		*/
		public String getSaishiContent() {
			return saishiContent;
		}
		/**
		* 设置： 赛事介绍
		*/
		public void setSaishiContent(String saishiContent) {
			this.saishiContent = saishiContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getSaishiDelete() {
			return saishiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setSaishiDelete(Integer saishiDelete) {
			this.saishiDelete = saishiDelete;
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
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "SaishiBaomingView{" +
			", saishiBaomingValue=" + saishiBaomingValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", saishiName=" + saishiName +
			", saishiUuidNumber=" + saishiUuidNumber +
			", saishiPhoto=" + saishiPhoto +
			", saishiFile=" + saishiFile +
			", saishiKaishiTime=" + DateUtil.convertString(saishiKaishiTime,"yyyy-MM-dd") +
			", saishiJieshuTime=" + DateUtil.convertString(saishiJieshuTime,"yyyy-MM-dd") +
			", saishiClicknum=" + saishiClicknum +
			", saishiContent=" + saishiContent +
			", saishiDelete=" + saishiDelete +
			", pingweiUuidNumber=" + pingweiUuidNumber +
			", pingweiName=" + pingweiName +
			", pingweiPhone=" + pingweiPhone +
			", pingweiIdNumber=" + pingweiIdNumber +
			", pingweiPhoto=" + pingweiPhoto +
			", pingweiEmail=" + pingweiEmail +
			"} " + super.toString();
	}
}
