package com.platform.admin.api.vo;

import java.io.Serializable;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * TableName:T_MANAGE_ROLE_POPEDOM
 */

public class RoleResourceVO implements Serializable {


    private java.util.Date updated;
    /**
     * ID
     */
    private String id;
    /**
     * 授权级别 1:允许 2：拒绝
     */
    private String authorizeLevel;
    private String operator;
    private java.util.Date created;
    /**
     * 资源ID
     */
    private String resourceId;
    /**
     * 角色ID
     */
    private String roleId;

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
     * @param id ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取 authorizeLevel
     * return
     */
    public String getAuthorizeLevel() {
        return this.authorizeLevel;
    }

    /**
     * 设置 authorizeLevel
     *
     * @param authorizeLevel 授权级别 1:允许 2：拒绝
     */
    public void setAuthorizeLevel(String authorizeLevel) {
        this.authorizeLevel = authorizeLevel;
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
     * 获取 resourceId
     * return
     */
    public String getResourceId() {
        return this.resourceId;
    }

    /**
     * 设置 resourceId
     *
     * @param resourceId 资源ID
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取 roleId
     * return
     */
    public String getRoleId() {
        return this.roleId;
    }

    /**
     * 设置 roleId
     *
     * @param roleId 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
