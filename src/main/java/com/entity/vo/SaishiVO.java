package com.entity.vo;

import com.entity.SaishiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 赛事
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("saishi")
public class SaishiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 赛事名称
     */

    @TableField(value = "saishi_name")
    private String saishiName;


    /**
     * 赛事编号
     */

    @TableField(value = "saishi_uuid_number")
    private String saishiUuidNumber;


    /**
     * 赛事照片
     */

    @TableField(value = "saishi_photo")
    private String saishiPhoto;


    /**
     * 试题文件
     */

    @TableField(value = "saishi_file")
    private String saishiFile;


    /**
     * 赛事类型
     */

    @TableField(value = "saishi_types")
    private Integer saishiTypes;


    /**
     * 赛事开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "saishi_kaishi_time")
    private Date saishiKaishiTime;


    /**
     * 赛事结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "saishi_jieshu_time")
    private Date saishiJieshuTime;


    /**
     * 赛事热度
     */

    @TableField(value = "saishi_clicknum")
    private Integer saishiClicknum;


    /**
     * 赛事介绍
     */

    @TableField(value = "saishi_content")
    private String saishiContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "saishi_delete")
    private Integer saishiDelete;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：赛事名称
	 */
    public String getSaishiName() {
        return saishiName;
    }


    /**
	 * 获取：赛事名称
	 */

    public void setSaishiName(String saishiName) {
        this.saishiName = saishiName;
    }
    /**
	 * 设置：赛事编号
	 */
    public String getSaishiUuidNumber() {
        return saishiUuidNumber;
    }


    /**
	 * 获取：赛事编号
	 */

    public void setSaishiUuidNumber(String saishiUuidNumber) {
        this.saishiUuidNumber = saishiUuidNumber;
    }
    /**
	 * 设置：赛事照片
	 */
    public String getSaishiPhoto() {
        return saishiPhoto;
    }


    /**
	 * 获取：赛事照片
	 */

    public void setSaishiPhoto(String saishiPhoto) {
        this.saishiPhoto = saishiPhoto;
    }
    /**
	 * 设置：试题文件
	 */
    public String getSaishiFile() {
        return saishiFile;
    }


    /**
	 * 获取：试题文件
	 */

    public void setSaishiFile(String saishiFile) {
        this.saishiFile = saishiFile;
    }
    /**
	 * 设置：赛事类型
	 */
    public Integer getSaishiTypes() {
        return saishiTypes;
    }


    /**
	 * 获取：赛事类型
	 */

    public void setSaishiTypes(Integer saishiTypes) {
        this.saishiTypes = saishiTypes;
    }
    /**
	 * 设置：赛事开始时间
	 */
    public Date getSaishiKaishiTime() {
        return saishiKaishiTime;
    }


    /**
	 * 获取：赛事开始时间
	 */

    public void setSaishiKaishiTime(Date saishiKaishiTime) {
        this.saishiKaishiTime = saishiKaishiTime;
    }
    /**
	 * 设置：赛事结束时间
	 */
    public Date getSaishiJieshuTime() {
        return saishiJieshuTime;
    }


    /**
	 * 获取：赛事结束时间
	 */

    public void setSaishiJieshuTime(Date saishiJieshuTime) {
        this.saishiJieshuTime = saishiJieshuTime;
    }
    /**
	 * 设置：赛事热度
	 */
    public Integer getSaishiClicknum() {
        return saishiClicknum;
    }


    /**
	 * 获取：赛事热度
	 */

    public void setSaishiClicknum(Integer saishiClicknum) {
        this.saishiClicknum = saishiClicknum;
    }
    /**
	 * 设置：赛事介绍
	 */
    public String getSaishiContent() {
        return saishiContent;
    }


    /**
	 * 获取：赛事介绍
	 */

    public void setSaishiContent(String saishiContent) {
        this.saishiContent = saishiContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getSaishiDelete() {
        return saishiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setSaishiDelete(Integer saishiDelete) {
        this.saishiDelete = saishiDelete;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
