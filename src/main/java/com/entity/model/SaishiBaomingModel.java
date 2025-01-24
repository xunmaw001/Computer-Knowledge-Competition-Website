package com.entity.model;

import com.entity.SaishiBaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛事报名
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SaishiBaomingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String saishiBaomingUuidNumber;


    /**
     * 赛事
     */
    private Integer saishiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 评委
     */
    private Integer pingweiId;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 赛事成果
     */
    private String saishiBaomingFile;


    /**
     * 报名状态
     */
    private Integer saishiBaomingTypes;


    /**
     * 评审得分
     */
    private Double defen;


    /**
     * 评审意见
     */
    private String saishiBaomingText;


    /**
     * 评审时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date pingshenTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
