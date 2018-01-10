package com.platform.admin.api.vo;


import com.platform.admin.common.page.PageBean;

import java.io.Serializable;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * TableName:T_MANAGE_USER
 */

public class UserVO extends PageBean implements Serializable {


    /**
     * 0不是 1是
     */
    private Integer isAdministrator;
    /**
     * 登录次数
     */
    private Integer loginCount;
    private String areaCode;
    /**
     * 上次登录时间
     */
    private java.util.Date lastLoginTime;
    /**
     * 真实姓名
     */
    private String realName;
    private String remark;
    /**
     * 0:未锁定 1：已锁定
     */
    private Integer locked;
    private String operator;
    private java.util.Date created;
    /**
     * 问题
     */
    private String ask;
    /**
     * 个性图形
     */
    private String icon;
    /**
     * 手机号
     */
    private String mobileNo;
    /**
     * 固定电话
     */
    private String phoneNo;
    /**
     * 用户名
     */
    private String userName;
    private java.util.Date updated;
    /**
     * 用户ID
     */
    private String id;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 答案
     */
    private String strKey;
    /**
     * 密码 MD5加密
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;
    /**
     * 重复密码
     */
    private String rePassword;

    /**
     * 所属机构
     */
    private String organizationId;

    /**
     * 所属机构名称
     */
    private String organizationName;

    private String enterPwd;


    /**
     * 分配的角色ID
     */
    private String roles;

    /**
     * 多个ID
     */
    private String ids;


    public UserVO() {
    }

    public UserVO(String id) {
        this.id = id;
    }

    public UserVO(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    /**
     * 获取 isAdministrator
     * return
     */
    public Integer getIsAdministrator() {
        return this.isAdministrator;
    }

    /**
     * 设置 isAdministrator
     *
     * @param isAdministrator 0是 1不是
     */
    public void setIsAdministrator(Integer isAdministrator) {
        this.isAdministrator = isAdministrator;
    }

    /**
     * 获取 loginCount
     * return
     */
    public Integer getLoginCount() {
        return this.loginCount;
    }

    /**
     * 设置 loginCount
     *
     * @param loginCount 登录次数
     */
    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * 获取 areaCode
     * return
     */
    public String getAreaCode() {
        return this.areaCode;
    }

    /**
     * 设置 areaCode
     *
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 获取 lastLoginTime
     * return
     */
    public java.util.Date getLastLoginTime() {
        return this.lastLoginTime;
    }

    /**
     * 设置 lastLoginTime
     *
     * @param lastLoginTime 上次登录时间
     */
    public void setLastLoginTime(java.util.Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取 realName
     * return
     */
    public String getRealName() {
        return this.realName;
    }

    /**
     * 设置 realName
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取 remark
     * return
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置 remark
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取 locked
     * return
     */
    public Integer getLocked() {
        return this.locked;
    }

    /**
     * 设置 locked
     *
     * @param locked 0:公开 1：不公开
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    /**
     * 获取 operator
     * return
     */
    public String getOperator() {
        return this.operator;
    }

    /**
     * 设置 operator
     *
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 获取 created
     * return
     */
    public java.util.Date getCreated() {
        return this.created;
    }

    /**
     * 设置 created
     *
     * @param created
     */
    public void setCreated(java.util.Date created) {
        this.created = created;
    }

    /**
     * 获取 ask
     * return
     */
    public String getAsk() {
        return this.ask;
    }

    /**
     * 设置 ask
     *
     * @param ask 问题
     */
    public void setAsk(String ask) {
        this.ask = ask;
    }

    /**
     * 获取 icon
     * return
     */
    public String getIcon() {
        return this.icon;
    }

    /**
     * 设置 icon
     *
     * @param icon 个性图形
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取 mobileNo
     * return
     */
    public String getMobileNo() {
        return this.mobileNo;
    }

    /**
     * 设置 mobileNo
     *
     * @param mobileNo 手机号
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 获取 phoneNo
     * return
     */
    public String getPhoneNo() {
        return this.phoneNo;
    }

    /**
     * 设置 phoneNo
     *
     * @param phoneNo 固定电话
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * 获取 userName
     * return
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 userName
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 updated
     * return
     */
    public java.util.Date getUpdated() {
        return this.updated;
    }

    /**
     * 设置 updated
     *
     * @param updated
     */
    public void setUpdated(java.util.Date updated) {
        this.updated = updated;
    }

    /**
     * 获取 id
     * return
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置 id
     *
     * @param id 用户ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取 email
     * return
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 设置 email
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取 strKey
     * return
     */
    public String getStrKey() {
        return this.strKey;
    }

    /**
     * 设置 strKey
     *
     * @param strKey 答案
     */
    public void setStrKey(String strKey) {
        this.strKey = strKey;
    }

    /**
     * 获取 password
     * return
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置 password
     *
     * @param password 密码 MD5加密
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getEnterPwd() {
        return enterPwd;
    }

    public void setEnterPwd(String enterPwd) {
        this.enterPwd = enterPwd;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    /**
     * 获取 organizationId
     * return
     */
    public String getOrganizationId() {
        return this.organizationId;
    }

    /**
     * 设置 organizationId
     *
     * @param organizationId
     */
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
