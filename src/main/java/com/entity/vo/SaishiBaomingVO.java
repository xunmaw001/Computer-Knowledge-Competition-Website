package com.entity.vo;

import com.entity.SaishiBaomingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 赛事报名
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("saishi_baoming")
public class SaishiBaomingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "saishi_baoming_uuid_number")
    private String saishiBaomingUuidNumber;


    /**
     * 赛事
     */

    @TableField(value = "saishi_id")
    private Integer saishiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 评委
     */

    @TableField(value = "pingwei_id")
    private Integer pingweiId;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 赛事成果
     */

    @TableField(value = "saishi_baoming_file")
    private String saishiBaomingFile;


    /**
     * 报名状态
     */

    @TableField(value = "saishi_baoming_types")
    private Integer saishiBaomingTypes;


    /**
     * 评审得分
     */

    @TableField(value = "defen")
    private Double defen;


    /**
     * 评审意见
     */

    @TableField(value = "saishi_baoming_text")
    private String saishiBaomingText;


    /**
     * 评审时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "pingshen_time")
    private Date pingshenTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：报名编号
	 */
    public String getSaishiBaomingUuidNumber() {
        return saishiBaomingUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setSaishiBaomingUuidNumber(String saishiBaomingUuidNumber) {
        this.saishiBaomingUuidNumber = saishiBaomingUuidNumber;
    }
    /**
	 * 设置：赛事
	 */
    public Integer getSaishiId() {
        return saishiId;
    }


    /**
	 * 获取：赛事
	 */

    public void setSaishiId(Integer saishiId) {
        this.saishiId = saishiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：评委
	 */
    public Integer getPingweiId() {
        return pingweiId;
    }


    /**
	 * 获取：评委
	 */

    public void setPingweiId(Integer pingweiId) {
        this.pingweiId = pingweiId;
    }
    /**
	 * 设置：报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：赛事成果
	 */
    public String getSaishiBaomingFile() {
        return saishiBaomingFile;
    }


    /**
	 * 获取：赛事成果
	 */

    public void setSaishiBaomingFile(String saishiBaomingFile) {
        this.saishiBaomingFile = saishiBaomingFile;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getSaishiBaomingTypes() {
        return saishiBaomingTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setSaishiBaomingTypes(Integer saishiBaomingTypes) {
        this.saishiBaomingTypes = saishiBaomingTypes;
    }
    /**
	 * 设置：评审得分
	 */
    public Double getDefen() {
        return defen;
    }


    /**
	 * 获取：评审得分
	 */

    public void setDefen(Double defen) {
        this.defen = defen;
    }
    /**
	 * 设置：评审意见
	 */
    public String getSaishiBaomingText() {
        return saishiBaomingText;
    }


    /**
	 * 获取：评审意见
	 */

    public void setSaishiBaomingText(String saishiBaomingText) {
        this.saishiBaomingText = saishiBaomingText;
    }
    /**
	 * 设置：评审时间
	 */
    public Date getPingshenTime() {
        return pingshenTime;
    }


    /**
	 * 获取：评审时间
	 */

    public void setPingshenTime(Date pingshenTime) {
        this.pingshenTime = pingshenTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
