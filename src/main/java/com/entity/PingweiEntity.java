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
 * 评委
 *
 * @author 
 * @email
 */
@TableName("pingwei")
public class PingweiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PingweiEntity() {

	}

	public PingweiEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 评委编号
     */
    @ColumnInfo(comment="评委编号",type="varchar(200)")
    @TableField(value = "pingwei_uuid_number")

    private String pingweiUuidNumber;


    /**
     * 评委姓名
     */
    @ColumnInfo(comment="评委姓名",type="varchar(200)")
    @TableField(value = "pingwei_name")

    private String pingweiName;


    /**
     * 评委手机号
     */
    @ColumnInfo(comment="评委手机号",type="varchar(200)")
    @TableField(value = "pingwei_phone")

    private String pingweiPhone;


    /**
     * 评委身份证号
     */
    @ColumnInfo(comment="评委身份证号",type="varchar(200)")
    @TableField(value = "pingwei_id_number")

    private String pingweiIdNumber;


    /**
     * 评委头像
     */
    @ColumnInfo(comment="评委头像",type="varchar(200)")
    @TableField(value = "pingwei_photo")

    private String pingweiPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    @ColumnInfo(comment="电子邮箱",type="varchar(200)")
    @TableField(value = "pingwei_email")

    private String pingweiEmail;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：评委编号
	 */
    public String getPingweiUuidNumber() {
        return pingweiUuidNumber;
    }
    /**
	 * 设置：评委编号
	 */

    public void setPingweiUuidNumber(String pingweiUuidNumber) {
        this.pingweiUuidNumber = pingweiUuidNumber;
    }
    /**
	 * 获取：评委姓名
	 */
    public String getPingweiName() {
        return pingweiName;
    }
    /**
	 * 设置：评委姓名
	 */

    public void setPingweiName(String pingweiName) {
        this.pingweiName = pingweiName;
    }
    /**
	 * 获取：评委手机号
	 */
    public String getPingweiPhone() {
        return pingweiPhone;
    }
    /**
	 * 设置：评委手机号
	 */

    public void setPingweiPhone(String pingweiPhone) {
        this.pingweiPhone = pingweiPhone;
    }
    /**
	 * 获取：评委身份证号
	 */
    public String getPingweiIdNumber() {
        return pingweiIdNumber;
    }
    /**
	 * 设置：评委身份证号
	 */

    public void setPingweiIdNumber(String pingweiIdNumber) {
        this.pingweiIdNumber = pingweiIdNumber;
    }
    /**
	 * 获取：评委头像
	 */
    public String getPingweiPhoto() {
        return pingweiPhoto;
    }
    /**
	 * 设置：评委头像
	 */

    public void setPingweiPhoto(String pingweiPhoto) {
        this.pingweiPhoto = pingweiPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getPingweiEmail() {
        return pingweiEmail;
    }
    /**
	 * 设置：电子邮箱
	 */

    public void setPingweiEmail(String pingweiEmail) {
        this.pingweiEmail = pingweiEmail;
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
        return "Pingwei{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", pingweiUuidNumber=" + pingweiUuidNumber +
            ", pingweiName=" + pingweiName +
            ", pingweiPhone=" + pingweiPhone +
            ", pingweiIdNumber=" + pingweiIdNumber +
            ", pingweiPhoto=" + pingweiPhoto +
            ", sexTypes=" + sexTypes +
            ", pingweiEmail=" + pingweiEmail +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
