package com.entity.model;

import com.entity.PingweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 评委
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PingweiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 评委编号
     */
    private String pingweiUuidNumber;


    /**
     * 评委姓名
     */
    private String pingweiName;


    /**
     * 评委手机号
     */
    private String pingweiPhone;


    /**
     * 评委身份证号
     */
    private String pingweiIdNumber;


    /**
     * 评委头像
     */
    private String pingweiPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String pingweiEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
