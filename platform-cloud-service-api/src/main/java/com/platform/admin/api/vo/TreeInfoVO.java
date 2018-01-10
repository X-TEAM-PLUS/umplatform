package com.platform.admin.api.vo;

/**
 * Created by xinleisong on 2018/1/8.
 */
public class TreeInfoVO {

    private String contextPath;

    private String roleId;

    private int resourceType;

    private boolean isUsedCheckBox;

    private boolean isAdministrator;

    private String appId;

    private String userId;

    public TreeInfoVO() {
        this.contextPath = contextPath;
        this.roleId = roleId;
        this.resourceType = resourceType;
        this.isUsedCheckBox = isUsedCheckBox;
        this.appId = appId;
        this.isAdministrator = isAdministrator;
        this.userId = userId;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    public boolean isUsedCheckBox() {
        return isUsedCheckBox;
    }

    public void setUsedCheckBox(boolean usedCheckBox) {
        isUsedCheckBox = usedCheckBox;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
