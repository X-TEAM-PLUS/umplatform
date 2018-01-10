package com.platform.admin.security;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yankun on 2015/12/11 0011.
 */
public class UserInfo implements java.io.Serializable {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 机构代码
     */
    private String organizationCode;

    /**
     * 区域代码
     */
    private String areaCode;

    /**
     * 角色Id
     */
    private String roleIds;

    /**
     * 是否为超级管理员
     */
    private boolean isAdministrator = false;

    /**
     * 扩展属性
     */
    private Map<String, Object> extInfo = new HashMap<String, Object>();

    /**
     * 设置扩展属性
     *
     * @param key
     * @param value
     */
    public void putExtInfo(String key, Object value) {
        extInfo.put(key, value);
    }


    /**
     * 获取扩展属性
     *
     * @param key
     */
    public Object getExtInfo(String key) {
        return extInfo.get(key);
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }

    public Map<String, Object> getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(Map<String, Object> extInfo) {
        this.extInfo = extInfo;
    }
}
