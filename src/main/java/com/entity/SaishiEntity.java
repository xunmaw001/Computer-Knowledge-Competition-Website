package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 赛事
 *
 * @author 
 * @email
 */
@TableName("saishi")
public class SaishiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SaishiEntity() {

	}

	public SaishiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 赛事名称
     */
    @ColumnInfo(comment="赛事名称",type="varchar(200)")
    @TableField(value = "saishi_name")

    private String saishiName;


    /**
     * 赛事编号
     */
    @ColumnInfo(comment="赛事编号",type="varchar(200)")
    @TableField(value = "saishi_uuid_number")

    private String saishiUuidNumber;


    /**
     * 赛事照片
     */
    @ColumnInfo(comment="赛事照片",type="varchar(200)")
    @TableField(value = "saishi_photo")

    private String saishiPhoto;


    /**
     * 试题文件
     */
    @ColumnInfo(comment="试题文件",type="varchar(200)")
    @TableField(value = "saishi_file")

    private String saishiFile;


    /**
     * 赛事类型
     */
    @ColumnInfo(comment="赛事类型",type="int(11)")
    @TableField(value = "saishi_types")

    private Integer saishiTypes;


    /**
     * 赛事开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="赛事开始时间",type="timestamp")
    @TableField(value = "saishi_kaishi_time")

    private Date saishiKaishiTime;


    /**
     * 赛事结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="赛事结束时间",type="timestamp")
    @TableField(value = "saishi_jieshu_time")

    private Date saishiJieshuTime;


    /**
     * 赛事热度
     */
    @ColumnInfo(comment="赛事热度",type="int(11)")
    @TableField(value = "saishi_clicknum")

    private Integer saishiClicknum;


    /**
     * 赛事介绍
     */
    @ColumnInfo(comment="赛事介绍",type="text")
    @TableField(value = "saishi_content")

    private String saishiContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "saishi_delete")

    private Integer saishiDelete;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="发布时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：赛事名称
	 */
    public String getSaishiName() {
        return saishiName;
    }
    /**
	 * 设置：赛事名称
	 */

    public void setSaishiName(String saishiName) {
        this.saishiName = saishiName;
    }
    /**
	 * 获取：赛事编号
	 */
    public String getSaishiUuidNumber() {
        return saishiUuidNumber;
    }
    /**
	 * 设置：赛事编号
	 */

    public void setSaishiUuidNumber(String saishiUuidNumber) {
        this.saishiUuidNumber = saishiUuidNumber;
    }
    /**
	 * 获取：赛事照片
	 */
    public String getSaishiPhoto() {
        return saishiPhoto;
    }
    /**
	 * 设置：赛事照片
	 */

    public void setSaishiPhoto(String saishiPhoto) {
        this.saishiPhoto = saishiPhoto;
    }
    /**
	 * 获取：试题文件
	 */
    public String getSaishiFile() {
        return saishiFile;
    }
    /**
	 * 设置：试题文件
	 */

    public void setSaishiFile(String saishiFile) {
        this.saishiFile = saishiFile;
    }
    /**
	 * 获取：赛事类型
	 */
    public Integer getSaishiTypes() {
        return saishiTypes;
    }
    /**
	 * 设置：赛事类型
	 */

    public void setSaishiTypes(Integer saishiTypes) {
        this.saishiTypes = saishiTypes;
    }
    /**
	 * 获取：赛事开始时间
	 */
    public Date getSaishiKaishiTime() {
        return saishiKaishiTime;
    }
    /**
	 * 设置：赛事开始时间
	 */

    public void setSaishiKaishiTime(Date saishiKaishiTime) {
        this.saishiKaishiTime = saishiKaishiTime;
    }
    /**
	 * 获取：赛事结束时间
	 */
    public Date getSaishiJieshuTime() {
        return saishiJieshuTime;
    }
    /**
	 * 设置：赛事结束时间
	 */

    public void setSaishiJieshuTime(Date saishiJieshuTime) {
        this.saishiJieshuTime = saishiJieshuTime;
    }
    /**
	 * 获取：赛事热度
	 */
    public Integer getSaishiClicknum() {
        return saishiClicknum;
    }
    /**
	 * 设置：赛事热度
	 */

    public void setSaishiClicknum(Integer saishiClicknum) {
        this.saishiClicknum = saishiClicknum;
    }
    /**
	 * 获取：赛事介绍
	 */
    public String getSaishiContent() {
        return saishiContent;
    }
    /**
	 * 设置：赛事介绍
	 */

    public void setSaishiContent(String saishiContent) {
        this.saishiContent = saishiContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getSaishiDelete() {
        return saishiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setSaishiDelete(Integer saishiDelete) {
        this.saishiDelete = saishiDelete;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Saishi{" +
            ", id=" + id +
            ", saishiName=" + saishiName +
            ", saishiUuidNumber=" + saishiUuidNumber +
            ", saishiPhoto=" + saishiPhoto +
            ", saishiFile=" + saishiFile +
            ", saishiTypes=" + saishiTypes +
            ", saishiKaishiTime=" + DateUtil.convertString(saishiKaishiTime,"yyyy-MM-dd") +
            ", saishiJieshuTime=" + DateUtil.convertString(saishiJieshuTime,"yyyy-MM-dd") +
            ", saishiClicknum=" + saishiClicknum +
            ", saishiContent=" + saishiContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", saishiDelete=" + saishiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
