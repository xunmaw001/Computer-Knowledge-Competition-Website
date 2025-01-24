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
 * 赛事报名
 *
 * @author 
 * @email
 */
@TableName("saishi_baoming")
public class SaishiBaomingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SaishiBaomingEntity() {

	}

	public SaishiBaomingEntity(T t) {
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
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "saishi_baoming_uuid_number")

    private String saishiBaomingUuidNumber;


    /**
     * 赛事
     */
    @ColumnInfo(comment="赛事",type="int(11)")
    @TableField(value = "saishi_id")

    private Integer saishiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 评委
     */
    @ColumnInfo(comment="评委",type="int(11)")
    @TableField(value = "pingwei_id")

    private Integer pingweiId;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 赛事成果
     */
    @ColumnInfo(comment="赛事成果",type="varchar(200)")
    @TableField(value = "saishi_baoming_file")

    private String saishiBaomingFile;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "saishi_baoming_types")

    private Integer saishiBaomingTypes;


    /**
     * 评审得分
     */
    @ColumnInfo(comment="评审得分",type="decimal(10,2)")
    @TableField(value = "defen")

    private Double defen;


    /**
     * 评审意见
     */
    @ColumnInfo(comment="评审意见",type="text")
    @TableField(value = "saishi_baoming_text")

    private String saishiBaomingText;


    /**
     * 评审时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="评审时间",type="timestamp")
    @TableField(value = "pingshen_time")

    private Date pingshenTime;


    /**
     * 创建时间  listShow
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
	 * 获取：报名编号
	 */
    public String getSaishiBaomingUuidNumber() {
        return saishiBaomingUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setSaishiBaomingUuidNumber(String saishiBaomingUuidNumber) {
        this.saishiBaomingUuidNumber = saishiBaomingUuidNumber;
    }
    /**
	 * 获取：赛事
	 */
    public Integer getSaishiId() {
        return saishiId;
    }
    /**
	 * 设置：赛事
	 */

    public void setSaishiId(Integer saishiId) {
        this.saishiId = saishiId;
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
	 * 获取：评委
	 */
    public Integer getPingweiId() {
        return pingweiId;
    }
    /**
	 * 设置：评委
	 */

    public void setPingweiId(Integer pingweiId) {
        this.pingweiId = pingweiId;
    }
    /**
	 * 获取：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：赛事成果
	 */
    public String getSaishiBaomingFile() {
        return saishiBaomingFile;
    }
    /**
	 * 设置：赛事成果
	 */

    public void setSaishiBaomingFile(String saishiBaomingFile) {
        this.saishiBaomingFile = saishiBaomingFile;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getSaishiBaomingTypes() {
        return saishiBaomingTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setSaishiBaomingTypes(Integer saishiBaomingTypes) {
        this.saishiBaomingTypes = saishiBaomingTypes;
    }
    /**
	 * 获取：评审得分
	 */
    public Double getDefen() {
        return defen;
    }
    /**
	 * 设置：评审得分
	 */

    public void setDefen(Double defen) {
        this.defen = defen;
    }
    /**
	 * 获取：评审意见
	 */
    public String getSaishiBaomingText() {
        return saishiBaomingText;
    }
    /**
	 * 设置：评审意见
	 */

    public void setSaishiBaomingText(String saishiBaomingText) {
        this.saishiBaomingText = saishiBaomingText;
    }
    /**
	 * 获取：评审时间
	 */
    public Date getPingshenTime() {
        return pingshenTime;
    }
    /**
	 * 设置：评审时间
	 */

    public void setPingshenTime(Date pingshenTime) {
        this.pingshenTime = pingshenTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SaishiBaoming{" +
            ", id=" + id +
            ", saishiBaomingUuidNumber=" + saishiBaomingUuidNumber +
            ", saishiId=" + saishiId +
            ", yonghuId=" + yonghuId +
            ", pingweiId=" + pingweiId +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", saishiBaomingFile=" + saishiBaomingFile +
            ", saishiBaomingTypes=" + saishiBaomingTypes +
            ", defen=" + defen +
            ", saishiBaomingText=" + saishiBaomingText +
            ", pingshenTime=" + DateUtil.convertString(pingshenTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
