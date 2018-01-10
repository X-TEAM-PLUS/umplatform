package com.platform.admin.api.vo.tree;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yankun
 * Date: 12-9-19
 * Time: 下午10:37
 * 树节点对象
 */
public class TreeNode implements Serializable {
    /**
     * ID
     */
    private String id;

    /**
     * 文本名称
     */
    private String text;

    /**
     * 样式
     */
    private String cls;

    /**
     * 小图标
     */
    private String icon;

    /**
     * 展开状态
     */
    private boolean expanded = true;

    /**
     * 是否是叶节点
     */
    private boolean leaf;

    /**
     * 链接
     */
    private String url;

    /**
     * 目标框架
     */
    private String hrefTarget;

    /**
     * 选 择状态
     */
    private Boolean checked;

    /**
     * 父节点ID
     */
    private String parentId;

    /**
     * 子节点
     */
    private List children;

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHrefTarget() {
        return hrefTarget;
    }

    public void setHrefTarget(String hrefTarget) {
        this.hrefTarget = hrefTarget;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean isChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
