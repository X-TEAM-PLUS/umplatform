package com.platform.admin.api;

/**
 * Created with IntelliJ IDEA.
 * User: yankun
 * Date: 13-12-24
 * Time: 下午6:56
 * To change this template use File | Settings | File Templates.
 */
public enum ResourceType {
    Application("0", "应用"), Menu("1", "菜单"), Button("2", "按钮"), ALL("", "");
    private String type;
    private String typeName;

    private ResourceType(String type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public static ResourceType form(String type) {
        if ("0".equalsIgnoreCase(type)) {
            return Application;
        }

        if ("1".equalsIgnoreCase(type)) {
            return Menu;
        }
        if ("2".equalsIgnoreCase(type)) {
            return Button;
        }
        return null;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getType() {
        return type;
    }
}
