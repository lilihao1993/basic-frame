package com.basicframe.demo.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lilihao
 * @since 2017-08-09
 */
@TableName("blog_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    @TableId("ID")
	private String id;
    /**
     * 用户名
     */
	@TableField("USER_NAME")
	private String userName;
    /**
     * 密码
     */
	@TableField("PASSWORD")
	private String password;
    /**
     * 姓名
     */
	@TableField("NAME")
	private String name;
    /**
     * 性别(0:女 1:男)
     */
	@TableField("SEX")
	private String sex;
    /**
     * 地址
     */
	@TableField("ADDRESS")
	private String address;
    /**
     * 生日
     */
	@TableField("DIRTHDAY")
	private Date dirthday;
    /**
     * 手机号
     */
	@TableField("MOBILE")
	private String mobile;
    /**
     * 邮箱
     */
	@TableField("MAIL")
	private String mail;
    /**
     * 微信号
     */
	@TableField("WECHAT")
	private String wechat;
    /**
     * 描述
     */
	@TableField("SKETCH")
	private String sketch;
    /**
     * 加盐值
     */
	@TableField("ENCRYPT_SALT")
	private String encryptSalt;
    /**
     * 创建时间
     */
	@TableField("CREATE_TIME")
	private Date createTime;
    /**
     * 操作时间
     */
	@TableField("OPERATE_TIME")
	private Date operateTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDirthday() {
		return dirthday;
	}

	public void setDirthday(Date dirthday) {
		this.dirthday = dirthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getSketch() {
		return sketch;
	}

	public void setSketch(String sketch) {
		this.sketch = sketch;
	}

	public String getEncryptSalt() {
		return encryptSalt;
	}

	public void setEncryptSalt(String encryptSalt) {
		this.encryptSalt = encryptSalt;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", userName=" + userName +
			", password=" + password +
			", name=" + name +
			", sex=" + sex +
			", address=" + address +
			", dirthday=" + dirthday +
			", mobile=" + mobile +
			", mail=" + mail +
			", wechat=" + wechat +
			", sketch=" + sketch +
			", encryptSalt=" + encryptSalt +
			", createTime=" + createTime +
			", operateTime=" + operateTime +
			"}";
	}
}
