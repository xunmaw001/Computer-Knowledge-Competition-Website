package com.entity.vo;

import com.entity.PingweiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 评委
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("pingwei")
public class PingweiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 评委编号
     */

    @TableField(value = "pingwei_uuid_number")
    private String pingweiUuidNumber;


    /**
     * 评委姓名
     */

    @TableField(value = "pingwei_name")
    private String pingweiName;


    /**
     * 评委手机号
     */

    @TableField(value = "pingwei_phone")
    private String pingweiPhone;


    /**
     * 评委身份证号
     */

    @TableField(value = "pingwei_id_number")
    private String pingweiIdNumber;


    /**
     * 评委头像
     */

    @TableField(value = "pingwei_photo")
    private String pingweiPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "pingwei_email")
    private String pingweiEmail;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：评委编号
	 */
    public String getPingweiUuidNumber() {
        return pingweiUuidNumber;
    }


    /**
	 * 获取：评委编号
	 */

    public void setPingweiUuidNumber(String pingweiUuidNumber) {
        this.pingweiUuidNumber = pingweiUuidNumber;
    }
    /**
	 * 设置：评委姓名
	 */
    public String getPingweiName() {
        return pingweiName;
    }


    /**
	 * 获取：评委姓名
	 */

    public void setPingweiName(String pingweiName) {
        this.pingweiName = pingweiName;
    }
    /**
	 * 设置：评委手机号
	 */
    public String getPingweiPhone() {
        return pingweiPhone;
    }


    /**
	 * 获取：评委手机号
	 */

    public void setPingweiPhone(String pingweiPhone) {
        this.pingweiPhone = pingweiPhone;
    }
    /**
	 * 设置：评委身份证号
	 */
    public String getPingweiIdNumber() {
        return pingweiIdNumber;
    }


    /**
	 * 获取：评委身份证号
	 */

    public void setPingweiIdNumber(String pingweiIdNumber) {
        this.pingweiIdNumber = pingweiIdNumber;
    }
    /**
	 * 设置：评委头像
	 */
    public String getPingweiPhoto() {
        return pingweiPhoto;
    }


    /**
	 * 获取：评委头像
	 */

    public void setPingweiPhoto(String pingweiPhoto) {
        this.pingweiPhoto = pingweiPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getPingweiEmail() {
        return pingweiEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setPingweiEmail(String pingweiEmail) {
        this.pingweiEmail = pingweiEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
