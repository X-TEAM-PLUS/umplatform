package com.platform.admin.api.vo;

import com.platform.admin.common.page.PageBean;

import java.io.Serializable;

/**
 * Created by codegeneratorplugin
 * User: yankun-develop@outlook.com
 * Date: 2015年09月23日
 * Time: 15:30:49
 * TableName:T_MANAGE_ORGANIZATION
 */

public class OrganizationVO extends PageBean implements Serializable {


    private String name;
    private java.util.Date updated;
    private String id;
    private String remark;
    private String operator;
    private java.util.Date created;
    private String parentId;
    private String code;
    private OrganizationVO parentVO;

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
     * @param name
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
     * 获取 id
     * return
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置 id
     *
     * @param id
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
     * @param remark
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
     * 获取 parentId
     * return
     */
    public String getParentId() {
        return this.parentId;
    }

    /**
     * 设置 parentId
     *
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取 code
     * return
     */
    public String getCode() {
        return this.code;
    }

    /**
     * 设置 code
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    public OrganizationVO getParentVO() {
        return parentVO;
    }

    public void setParentVO(OrganizationVO parentVO) {
        this.parentVO = parentVO;
    }
}
