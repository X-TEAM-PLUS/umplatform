package com.platform.admin.domain;


import com.platform.admin.common.page.PageBean;

import java.io.Serializable;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * TableName:T_MANAGE_APPLICATION
 */

public class Application extends PageBean implements Serializable {


    private String icon;
    /**
     * 应用名称
     */
    private String name;
    private String logoutUrl;
    private java.util.Date updated;
    /**
     * 0:可修改 1:不可修改
     */
    private String isCanModify;
    private String cipherKey;
    private String md5Key;
    /**
     * ID
     */
    private String id;
    /**
     * 描述
     */
    private String remark;
    private String operator;
    private java.util.Date created;
    private String url;

    /**
     * 用户Id
     */
    private String userId;

    public Application() {
    }

    public Application(String id) {
        this.id = id;
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
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取 name
     * return
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置 name
     *
     * @param name 应用名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 logoutUrl
     * return
     */
    public String getLogoutUrl() {
        return this.logoutUrl;
    }

    /**
     * 设置 logoutUrl
     *
     * @param logoutUrl
     */
    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
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
     * 获取 isCanModify
     * return
     */
    public String getIsCanModify() {
        return this.isCanModify;
    }

    /**
     * 设置 isCanModify
     *
     * @param isCanModify 0:可修改 1:不可修改
     */
    public void setIsCanModify(String isCanModify) {
        this.isCanModify = isCanModify;
    }

    /**
     * 获取 cipherKey
     * return
     */
    public String getCipherKey() {
        return this.cipherKey;
    }

    /**
     * 设置 cipherKey
     *
     * @param cipherKey
     */
    public void setCipherKey(String cipherKey) {
        this.cipherKey = cipherKey;
    }

    /**
     * 获取 md5Key
     * return
     */
    public String getMd5Key() {
        return this.md5Key;
    }

    /**
     * 设置 md5Key
     *
     * @param md5Key
     */
    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key;
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
     * @param id ID
     */
    public void setId(String id) {
        this.id = id;
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
     * @param remark 描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * 获取 url
     * return
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * 设置 url
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
