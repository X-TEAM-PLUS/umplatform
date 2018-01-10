package com.platform.admin.domain;


import java.io.Serializable;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * TableName:T_MANAGE_RESOURCE
 */

public class Resource implements Serializable {


    private String icon;
    /**
     * 资源名称
     */
    private String name;
    private java.util.Date updated;
    /**
     * 0:可修改 1:不可修改
     */
    private String isCanModify;
    /**
     * 资源ID
     */
    private String id;
    /**
     * 资源描述
     */
    private String remark;
    private String operator;
    private java.util.Date created;
    /**
     * 资源地址
     */
    private String url;
    /**
     * 资源类型：1：菜单2：按钮
     */
    private String resourceType;
    /**
     * 父资源ID
     */
    private String parentId;
    /**
     * 业务模块ID
     */
    private String appId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private String roles;

    public Resource(String id) {
        this.id = id;
    }

    public Resource() {

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
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取 id
     * return
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置 id
     *
     * @param id 资源ID
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
     * @param remark 资源描述
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
     * @param url 资源地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取 resourceType
     * return
     */
    public String getResourceType() {
        return this.resourceType;
    }

    /**
     * 设置 resourceType
     *
     * @param resourceType 资源类型：1：菜单2：按钮
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * 获取 parentId
     * return
     */
    public String getParentId() {
        return this.parentId;
    }

    /**
     * 设置 parentId
     *
     * @param parentId 父资源ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取 appId
     * return
     */
    public String getAppId() {
        return this.appId;
    }

    /**
     * 设置 appId
     *
     * @param appId 业务模块ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
