package com.platform.admin.api.vo;



import com.platform.admin.common.page.PageBean;

import java.io.Serializable;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * TableName:T_MANAGE_ROLE
 */

public class RoleVO extends PageBean implements Serializable {


    private String icon;
    private java.util.Date updated;
    /**
     * 角色ID
     */
    private String id;
    /**
     * 资源描述
     */
    private String remark;
    private String operator;
    /**
     * 角色名
     */
    private String roleName;
    private java.util.Date created;
    private String organizationId;

    /**
     * 资源IDS
     */
    private String resourceIds;

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
     * @param id 角色ID
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
     * 获取 roleName
     * return
     */
    public String getRoleName() {
        return this.roleName;
    }

    /**
     * 设置 roleName
     *
     * @param roleName 角色名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }
}
