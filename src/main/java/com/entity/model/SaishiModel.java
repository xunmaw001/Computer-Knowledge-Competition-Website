package com.entity.model;

import com.entity.SaishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赛事
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SaishiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 赛事名称
     */
    private String saishiName;


    /**
     * 赛事编号
     */
    private String saishiUuidNumber;


    /**
     * 赛事照片
     */
    private String saishiPhoto;


    /**
     * 试题文件
     */
    private String saishiFile;


    /**
     * 赛事类型
     */
    private Integer saishiTypes;


    /**
     * 赛事开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date saishiKaishiTime;


    /**
     * 赛事结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date saishiJieshuTime;


    /**
     * 赛事热度
     */
    private Integer saishiClicknum;


    /**
     * 赛事介绍
     */
    private String saishiContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer saishiDelete;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
