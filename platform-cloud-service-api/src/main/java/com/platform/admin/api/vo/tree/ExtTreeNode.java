package com.platform.admin.api.vo.tree;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: yankun
 * Date: 12-9-19
 * Time: 下午10:50
 * 扩展树节点对象
 */
@JsonAutoDetect
public class ExtTreeNode extends TreeNode  {
    /**
     * 应用ID
     */
    private String appId;

    /**
     * 类别
     */
    private String type;


    /**
     * 0:可修改
     * 1:不可修改
     */
    private String isCanModify;


    /**
     * 描述
     */
    private String remark;


    /**
     * 操作者
     */
    private String operator;


    /**
     * 创建时间
     */
    private Date created;


    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 是否窗口
     */
    private boolean isWin;

    /**
     * 角色
     */
    private String roles;
    /**
     * 编号
     */
    private String code;

    /**
     * 事件
     */
    private NodeEvent event;

    /**
     * 获取类别
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 类别
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }


    public String getCanModify() {
        return isCanModify;
    }

    public void setCanModify(String canModify) {
        isCanModify = canModify;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getIsCanModify() {
        return isCanModify;
    }

    public void setIsCanModify(String isCanModify) {
        this.isCanModify = isCanModify;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public NodeEvent getEvent() {
        return event;
    }

    public void setEvent(NodeEvent event) {
        this.event = event;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
